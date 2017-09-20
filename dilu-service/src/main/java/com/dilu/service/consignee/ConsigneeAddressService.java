package com.dilu.service.consignee;

import com.dilu.domain.consignee.ConsigneeAddressDO;

import java.util.List;

/**
 * @author guonima
 * @create 2017-09-20 11:23
 */
public interface ConsigneeAddressService {

    public int save(ConsigneeAddressDO consigneeAddressDO);

    public int deleteById(Long id);

    public ConsigneeAddressDO findById(Long id);

    public List<ConsigneeAddressDO> queryListAll(ConsigneeAddressDO consigneeAddressDO);
}
