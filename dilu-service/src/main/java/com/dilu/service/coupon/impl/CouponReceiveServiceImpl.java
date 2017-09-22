package com.dilu.service.coupon.impl;

import com.dilu.common.base.impl.AbstractService;
import com.dilu.common.util.DateUtil;
import com.dilu.dao.coupon.CouponReceiveMapper;
import com.dilu.domain.coupon.CouponDO;
import com.dilu.domain.coupon.CouponReceiveDO;
import com.dilu.service.coupon.CouponReceiveService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


/**
 * @author guonima
 * @create 2017-09-21 15:54
 */
@Service("couponReceiveService")
public class CouponReceiveServiceImpl extends AbstractService<CouponReceiveDO, Long> implements CouponReceiveService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CouponReceiveMapper couponReceiveMapper;

    @Autowired
    private void setBaseMapper() {
        super.setBaseMapper(couponReceiveMapper);
    }

    public int insert(CouponReceiveDO couponReceiveDO){
        //TODO 业务处理
        CouponDO couponDO = couponReceiveMapper.findCouponById(couponReceiveDO.getCouponId());

        Integer validRange = couponDO.getValidRange();
        couponReceiveDO.setStartTime(new Date());
        couponReceiveDO.setEndTime(DateUtil.plusDays(new Date(), validRange));
        couponReceiveDO.setAmount(couponDO.getAmount());
        couponReceiveDO.setLimitingCondition(couponDO.getLimitingCondition());
        return super.insert(couponReceiveDO);
    }


}
