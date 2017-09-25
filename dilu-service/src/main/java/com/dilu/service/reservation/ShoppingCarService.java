package com.dilu.service.reservation;

import com.dilu.domain.reservation.ShoppingCarDO;

import java.util.List;

/**
 * @author guonima
 * @create 2017-09-25 16:42
 */
public interface ShoppingCarService {

    public int insert(ShoppingCarDO shoppingCarDO);

    public int update(ShoppingCarDO shoppingCarDO);

    public int deleteById(Long id);

    public List<ShoppingCarDO> queryListAll(ShoppingCarDO shoppingCarDO);

}
