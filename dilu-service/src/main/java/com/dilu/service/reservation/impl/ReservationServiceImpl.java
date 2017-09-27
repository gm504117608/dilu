package com.dilu.service.reservation.impl;

import com.dilu.common.Constant;
import com.dilu.common.base.impl.AbstractService;
import com.dilu.common.util.OrderUtil;
import com.dilu.dao.reservation.ReservationMapper;
import com.dilu.domain.coupon.CouponReceiveDO;
import com.dilu.domain.photo.PhotoDO;
import com.dilu.domain.reservation.ReservationDO;
import com.dilu.domain.reservation.ShoppingCarDO;
import com.dilu.service.coupon.CouponReceiveService;
import com.dilu.service.photo.PhotoService;
import com.dilu.service.reservation.ReservationService;
import com.dilu.service.reservation.ShoppingCarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author guonima
 * @create 2017-09-26 14:35
 */
@Service("reservationService")
public class ReservationServiceImpl extends AbstractService<ReservationDO, Long> implements ReservationService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ReservationMapper reservationMapper;

    @Autowired
    private ShoppingCarService shoppingCarService;

    @Autowired
    private PhotoService photoService;

    @Autowired
    private CouponReceiveService couponReceiveService;

    @Autowired
    public void setBaseMapper() {
        super.setBaseMapper(reservationMapper);
    }

    @Transactional
    public String insertReservation(ReservationDO reservationDO) {

        // 计算购物车金额
        String[] shoppingCarIdArray = reservationDO.getShoppingCarIds().split(",");
        int size = shoppingCarIdArray.length;
        if (size == 0) {
            return "购物车无数据";
        }
        BigDecimal cost = new BigDecimal(0);
        ShoppingCarDO shoppingCarDO = null;
        PhotoDO photoDO = null;
        while (size > 0) {
            shoppingCarDO = shoppingCarService.findById(Long.valueOf(shoppingCarIdArray[size - 1]));
            photoDO = photoService.findById(shoppingCarDO.getPhotoId());
            cost = cost.add(photoDO.getPrice().multiply(new BigDecimal(shoppingCarDO.getQuantity())));
            size--;
        }
        if (cost.intValue() == 0) {
            return "订单金额不能为0";
        }
        reservationDO.setCost(cost);
        // 计算优惠券金额
        if (reservationDO.getCouponReceiveId() == null) {
            reservationDO.setCouponCost(new BigDecimal(0));
        } else {
            CouponReceiveDO couponReceiveDO = couponReceiveService.findById(reservationDO.getCouponReceiveId());
            BigDecimal limitingCondition = couponReceiveDO.getLimitingCondition();
            if (cost.compareTo(limitingCondition) >= 0) {
                reservationDO.setCouponCost(couponReceiveDO.getAmount());
            } else {
                reservationDO.setCouponCost(new BigDecimal(0));
            }
        }
        // 计算运费 (大于99的消费免运费)
        if (cost.compareTo(Constant.EXPRESS_COST_LIMIT) >= 0) {
            reservationDO.setExpressCost(new BigDecimal(0));
        } else {
            reservationDO.setExpressCost(Constant.EXPRESS_COST);
        }
        // 计算最终实际需要支付金额
        reservationDO.setReallyCost(reservationDO.getCost()
                .subtract(reservationDO.getCouponCost())
                .subtract(reservationDO.getExpressCost()));
        reservationDO.setStatus("O11"); //订单状态
        reservationDO.setOrderNo(OrderUtil.createOrderNo());

        super.insert(reservationDO);

        shoppingCarDO = new ShoppingCarDO();
        shoppingCarDO.setMemberId(reservationDO.getMemberId());
        shoppingCarDO.setType(1);// 购买状态【0：未购买；1：已购买；】
        shoppingCarService.update(shoppingCarDO);
        return null;
    }


}
