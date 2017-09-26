package com.dilu.service.reservation;

import com.dilu.domain.reservation.ReservationDO;

import java.util.List;
import java.util.Map;

/**
 * @author guonima
 * @create 2017-09-26 14:34
 */
public interface ReservationService {

    public int insert(ReservationDO reservationDO);

    public int update(ReservationDO reservationDO);

    public List<ReservationDO> queryListByPageEntity(Map<String, Object> param);

    public ReservationDO findById(Long id);
}
