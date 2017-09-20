package com.dilu.service.district;

import com.dilu.domain.district.DistrictDO;

import java.util.List;

/**
 * @author guonima
 * @create 2017-09-20 10:01
 */
public interface DistrictService {
    /**
     * 获取省份数据
     * @return
     */
    public List<DistrictDO> findProvinces();

    /**
     * 获取省份数据
     * @param code 省份代码值
     * @return
     */
    public DistrictDO findProvince(String code);

    /**
     * 获取省份名称
     * @param code 省份代码值
     * @return
     */
    public String findProvinceName(String code);

    /**
     * 获取城市数据
     * @param code 省份代码值
     * @return
     */
    public List<DistrictDO> findCities(String code);

    /**
     * 获取城市数据
     * @param code 城市代码值
     * @return
     */
    public DistrictDO findCity(String code);

    /**
     * 获取城市数据
     * @param code 城市代码值
     * @return
     */
    public String findCityName(String code);

    /**
     * 获取行政区数据
     * @param code 城市代码值
     * @return
     */
    public List<DistrictDO> findAreas(String code);

    /**
     * 获取行政区数据
     * @param code 行政区代码值
     * @return
     */
    public DistrictDO findArea(String code);

    /**
     * 获取行政区数据
     * @param code 行政区代码值
     * @return
     */
    public String findAreaName(String code);

}
