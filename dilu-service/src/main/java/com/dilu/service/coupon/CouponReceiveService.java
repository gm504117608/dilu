package com.dilu.service.coupon;

import com.dilu.domain.coupon.CouponReceiveDO;

import java.util.List;

/**
 * @author guonima
 * @create 2017-09-21 15:54
 */
public interface CouponReceiveService {

    public int update(CouponReceiveDO couponReceiveDO);

    public int insert(CouponReceiveDO couponReceiveDO);

    public CouponReceiveDO findById(Long id);

    public List<CouponReceiveDO> queryListAll(CouponReceiveDO couponReceiveDO);
}
