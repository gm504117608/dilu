package com.dilu.controller.coupon;

import com.dilu.domain.coupon.CouponReceiveDO;
import com.dilu.domain.coupon.CouponReceiveDTO;
import com.dilu.service.dictionary.DictionaryService;

/**
 * @author guonima
 * @create 2017-09-27 11:36
 */
public class CouponUtil {

    /**
     * 实体值之间的转换
     *
     * @param couponReceiveDO
     */
    public static CouponReceiveDTO couponReceiveDO2CouponReceiveDTO(CouponReceiveDO couponReceiveDO,
                                                                    DictionaryService dictionaryService) {
        if(couponReceiveDO == null){
            return null;
        }
        CouponReceiveDTO couponReceiveDTO = new CouponReceiveDTO();
        couponReceiveDTO.setId(couponReceiveDO.getId());
        couponReceiveDTO.setMemberId(couponReceiveDO.getMemberId());
        couponReceiveDTO.setCouponId(couponReceiveDO.getCouponId());
        couponReceiveDTO.setAmount(couponReceiveDO.getAmount());
        couponReceiveDTO.setLimitingCondition(couponReceiveDO.getLimitingCondition());
        couponReceiveDTO.setStartTime(couponReceiveDO.getStartTime());
        couponReceiveDTO.setEndTime(couponReceiveDO.getEndTime());
        couponReceiveDTO.setStatus(couponReceiveDO.getStatus());
        couponReceiveDTO.setCreateTime(couponReceiveDO.getCreateTime());
        couponReceiveDTO.setModifyTime(couponReceiveDO.getModifyTime());
        couponReceiveDTO.setName(couponReceiveDO.getName());
        couponReceiveDTO.setCouponNo(couponReceiveDO.getCouponNo());
        couponReceiveDTO.setType(couponReceiveDO.getType());
        couponReceiveDTO.setTypeName(dictionaryService.getDictionaryName("coupon-type",
                couponReceiveDO.getType()));

        return couponReceiveDTO;
    }
}
