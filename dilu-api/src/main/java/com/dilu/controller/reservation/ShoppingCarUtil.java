package com.dilu.controller.reservation;

import com.dilu.domain.Reservation.ShoppingCarDTO;
import com.dilu.domain.reservation.ShoppingCarDO;

/**
 * @author guonima
 * @create 2017-09-25 17:13
 */
public class ShoppingCarUtil {

    public static ShoppingCarDTO ShoppingCarDO2ShoppingCarDTO(ShoppingCarDO shoppingCarDO){
        if(shoppingCarDO == null){
            return null;
        }
        ShoppingCarDTO shoppingCarDTO = new ShoppingCarDTO();
        shoppingCarDTO.setId(shoppingCarDO.getId());
        shoppingCarDTO.setMemberId(shoppingCarDO.getMemberId());
        shoppingCarDTO.setPhotoId(shoppingCarDO.getPhotoId());
        shoppingCarDTO.setType(shoppingCarDO.getType());
        shoppingCarDTO.setQuantity(shoppingCarDO.getQuantity());
        shoppingCarDTO.setCreateTime(shoppingCarDO.getCreateTime());
        shoppingCarDTO.setModifyTime(shoppingCarDO.getCreateTime());

        return shoppingCarDTO;
    }
}
