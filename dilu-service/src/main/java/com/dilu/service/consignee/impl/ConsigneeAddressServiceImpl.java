package com.dilu.service.consignee.impl;

import com.dilu.common.base.impl.AbstractService;
import com.dilu.dao.consignee.ConsigneeAddressMapper;
import com.dilu.domain.consignee.ConsigneeAddressDO;
import com.dilu.service.consignee.ConsigneeAddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author guonima
 * @create 2017-09-20 11:23
 */
@Service("consigneeAddressService")
public class ConsigneeAddressServiceImpl extends AbstractService<ConsigneeAddressDO, Long> implements ConsigneeAddressService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ConsigneeAddressMapper consigneeAddressMapper;

    @Autowired
    public void setBaseMapper(){
        super.setBaseMapper(consigneeAddressMapper);
    }

    @Override
    @Transactional
    public int save(ConsigneeAddressDO consigneeAddressDO) {
        Long id = consigneeAddressDO.getId();
        Integer isUsing = consigneeAddressDO.getIsUsing();
        // 是否默认地址处理 是否默认地址【1：是；0：否】
        if (isUsing == 1) {
            ConsigneeAddressDO temp = new ConsigneeAddressDO();
            temp.setIsUsing(0);
            temp.setMemberId(consigneeAddressDO.getMemberId());
            super.update(temp);
        }
        // 保存数据
        if (null == id) {
            return super.insert(consigneeAddressDO);
        } else {
            return super.update(consigneeAddressDO);
        }
    }
}
