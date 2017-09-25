package com.dilu.service.reservation.impl;

import com.dilu.common.base.impl.AbstractService;
import com.dilu.dao.reservation.ShoppingCarMapper;
import com.dilu.domain.reservation.ShoppingCarDO;
import com.dilu.service.reservation.ShoppingCarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author guonima
 * @create 2017-09-25 16:42
 */
@Service("shoppingCarService")
public class ShoppingCarServiceImpl extends AbstractService<ShoppingCarDO, Long> implements ShoppingCarService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ShoppingCarMapper shoppingCarMapper;

    @Autowired
    public void setBaseMapper() {
        super.setBaseMapper(shoppingCarMapper);
    }

    public int insert(ShoppingCarDO shoppingCarDO){
        shoppingCarDO.setType(0);
        return super.insert(shoppingCarDO);
    }

}
