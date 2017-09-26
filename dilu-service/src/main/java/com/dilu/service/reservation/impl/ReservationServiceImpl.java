package com.dilu.service.reservation.impl;

import com.dilu.common.base.impl.AbstractService;
import com.dilu.dao.reservation.ReservationMapper;
import com.dilu.domain.reservation.ReservationDO;
import com.dilu.service.reservation.ReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author guonima
 * @create 2017-09-26 14:35
 */
@Service("reservationService")
public class ReservationServiceImpl extends AbstractService<ReservationDO, Long> implements ReservationService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ReservationMapper reservationMapper;

    @Autowired
    public void setBaseMapper() {
        super.setBaseMapper(reservationMapper);
    }


}
