package com.dilu.controller.consignee;

import com.dilu.domain.consignee.ConsigneeAddressDO;
import com.dilu.domain.consignee.ConsigneeAddressDTO;
import com.dilu.service.district.DistrictService;

/**
 * @author guonima
 * @create 2017-09-20 16:17
 */
public class ConsigneeAddressUtil {

    /**
     * 将收货地址数据库实体转成界面传输实体
     *
     * @param cado  数据库实体数据
     * @param cadto 界面展示数据
     */
    public static void consigneeAddressDO2consigneeAddressDTO(ConsigneeAddressDO cado, ConsigneeAddressDTO cadto,
                                                              DistrictService districtService) {
        cadto.setId(cado.getId());// 唯一标识id
        cadto.setMemberId(cado.getMemberId()); //会员唯一标识id
        cadto.setName(cado.getName()); //收件人
        cadto.setMobile(cado.getMobile()); //手机号码
        cadto.setProvince(cado.getProvince()); //省份
        cadto.setProvinceName(districtService.findProvinceName(cado.getProvince())); //省份名称
        cadto.setCity(cado.getCity()); //城市
        cadto.setCityName(districtService.findCityName(cado.getCity())); //城市名称
        cadto.setArea(cado.getArea()); //区域
        cadto.setAreaName(districtService.findAreaName(cado.getArea())); //区域名称
        cadto.setAddress(cado.getAddress()); //详细地址
        cadto.setPostcode(cado.getPostcode()); //邮编
        cadto.setIsUsing(cado.getIsUsing()); //是否默认地址【1：是；0：否】
        cadto.setCreateTime(cado.getCreateTime());
        cadto.setModifyTime(cado.getModifyTime());
    }
}
