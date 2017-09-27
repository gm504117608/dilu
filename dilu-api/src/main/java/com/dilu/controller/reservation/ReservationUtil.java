package com.dilu.controller.reservation;

import com.dilu.domain.Reservation.ReservationDTO;
import com.dilu.domain.reservation.ReservationDO;
import com.dilu.service.dictionary.DictionaryService;

/**
 * @author guonima
 * @create 2017-09-27 11:18
 */
public class ReservationUtil {

    public static ReservationDTO ReservationDO2ReservationDTO(ReservationDO reservationDO,
                                                              DictionaryService dictionaryService){
        if(reservationDO == null){
            return null;
        }
        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setId(reservationDO.getId());
        reservationDTO.setMemberId(reservationDO.getMemberId());
        reservationDTO.setShoppingCarIds(reservationDO.getShoppingCarIds());
        reservationDTO.setConsigneeId(reservationDO.getConsigneeId());
        reservationDTO.setCouponReceiveId(reservationDO.getCouponReceiveId());
        reservationDTO.setOrderNo(reservationDO.getOrderNo());
        reservationDTO.setCost(reservationDO.getCost());
        reservationDTO.setExpressCost(reservationDO.getExpressCost());
        reservationDTO.setCouponCost(reservationDO.getCouponCost());
        reservationDTO.setReallyCost(reservationDO.getReallyCost());
        reservationDTO.setStatus(reservationDO.getStatus());
        reservationDTO.setStatusName(dictionaryService.getDictionaryName("order-status", reservationDO.getStatus()));
        reservationDTO.setRemark(reservationDO.getRemark());
        reservationDTO.setCreateTime(reservationDO.getCreateTime());
        reservationDTO.setModifyTime(reservationDO.getModifyTime());

        return reservationDTO;
    }
}
