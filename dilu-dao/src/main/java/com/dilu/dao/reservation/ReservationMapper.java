package com.dilu.dao.reservation;

import com.dilu.common.base.BaseMapper;
import com.dilu.domain.reservation.ReservationDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author guonima
 * @create 2017-09-26 14:32
 */
@Mapper
public interface ReservationMapper extends BaseMapper<ReservationDO, Long> {
}
