package com.dilu.dao.coupon;

import com.dilu.common.base.BaseMapper;
import com.dilu.domain.coupon.CouponDO;
import com.dilu.domain.coupon.CouponReceiveDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author guonima
 * @create 2017-09-21 15:37
 */
@Mapper
public interface CouponReceiveMapper extends BaseMapper<CouponReceiveDO, Long> {

    public CouponDO findCouponById(Long id);
}
