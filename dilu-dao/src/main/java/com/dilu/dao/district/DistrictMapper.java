package com.dilu.dao.district;

import com.dilu.common.base.BaseMapper;
import com.dilu.domain.district.DistrictDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author guonima
 * @create 2017-09-20 9:49
 */
@Mapper
public interface DistrictMapper extends BaseMapper<DistrictDO, Long> {

    /**
     * 获取地区数据
     * @param districtDO
     * @return
     */
    public List<DistrictDO> findDistrictData(DistrictDO districtDO);
}
