package com.dilu.service.district.impl;

import com.dilu.common.base.impl.AbstractService;
import com.dilu.common.cache.RedisClient;
import com.dilu.dao.district.DistrictMapper;
import com.dilu.domain.district.DistrictDO;
import com.dilu.service.district.DistrictService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author guonima
 * @create 2017-09-20 10:02
 */
@Service("districtService")
public class DistrictServiceImpl extends AbstractService<DistrictDO, Long> implements DistrictService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DistrictMapper districtMapper;

    @Autowired
    private RedisClient redisClient;

    @Autowired
    public void setBaseMapper(){
        super.setBaseMapper(districtMapper);
    }

    @Override
    public List<DistrictDO> findProvinces() {
        List<DistrictDO> list = redisClient.hgetAll("province", DistrictDO.class);
        if (null != list) {
            return list;
        }
        list = findDistrictData(null);
        for (DistrictDO dd : list) {
            if (dd.getCode().length() == 2) {
                redisClient.hset("province", dd.getCode(), dd);
            }
        }
        redisClient.expire("province", 10 * 24 * 60 *60);
        return list;
    }

    @Override
    public DistrictDO findProvince(String code) {
        if (StringUtils.isEmpty(code)) {
            return null;
        }
        List<DistrictDO> list = findProvinces();
        for (DistrictDO dd : list) {
            if (code.equals(dd.getCode())) {
                return dd;
            }
        }
        return null;
    }

    @Override
    public String findProvinceName(String code) {
        if (StringUtils.isEmpty(code)) {
            return null;
        }
        DistrictDO districtDO = findProvince(code);
        if (null != districtDO) {
            return districtDO.getDescription();
        }
        return null;
    }

    @Override
    public List<DistrictDO> findCities(String code) {
        if (StringUtils.isEmpty(code) || code.length() != 2) {
            return null;
        }
        List<DistrictDO> list = redisClient.hgetAll("city:" + code, DistrictDO.class);
        if (null != list) {
            return list;
        }
        list = findDistrictData(code);
        for (DistrictDO dd : list) {
            if (dd.getCode().length() == 4) {
                redisClient.hset("city:" + code, dd.getCode(), dd);
            }
        }
        redisClient.expire("city:" + code, 10 * 24 * 60 *60);
        return list;
    }

    @Override
    public DistrictDO findCity(String code) {
        if (StringUtils.isEmpty(code)) {
            return null;
        }
        List<DistrictDO> list = findCities(code.substring(0, 2));
        for (DistrictDO dd : list) {
            if (code.equals(dd.getCode())) {
                return dd;
            }
        }
        return null;
    }

    @Override
    public String findCityName(String code) {
        if (StringUtils.isEmpty(code)) {
            return null;
        }
        DistrictDO districtDO = findCity(code);
        if (null != districtDO) {
            return districtDO.getDescription();
        }
        return null;
    }

    @Override
    public List<DistrictDO> findAreas(String code) {
        if (StringUtils.isEmpty(code) || code.length() != 4) {
            return null;
        }
        List<DistrictDO> list = redisClient.hgetAll("area:" + code, DistrictDO.class);
        if (null != list) {
            return list;
        }
        list = findDistrictData(code);
        for (DistrictDO dd : list) {
            if (dd.getCode().length() == 6) {
                redisClient.hset("area:" + code, dd.getCode(), dd);
            }
        }
        redisClient.expire("area:" + code, 10 * 24 * 60 *60);
        return list;
    }

    @Override
    public DistrictDO findArea(String code) {
        if (StringUtils.isEmpty(code)) {
            return null;
        }
        List<DistrictDO> list = findAreas(code.substring(0, 4));
        for (DistrictDO dd : list) {
            if (code.equals(dd.getCode())) {
                return dd;
            }
        }
        return null;
    }

    @Override
    public String findAreaName(String code) {
        if (StringUtils.isEmpty(code)) {
            return null;
        }
        DistrictDO districtDO = findArea(code);
        if (null != districtDO) {
            return districtDO.getDescription();
        }
        return null;
    }

    /**
     * 获取行政区数据
     * @param code
     * @return
     */
    private List<DistrictDO> findDistrictData(String code) {
        logger.info("获取行政区数据:{}", code);

        DistrictDO districtDO = new DistrictDO();
        if(code == null){
            code = "";
        }
        districtDO.setCode(code);
        return districtMapper.findDistrictData(districtDO);
    }
}
