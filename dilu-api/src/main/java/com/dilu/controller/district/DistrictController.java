package com.dilu.controller.district;

import com.dilu.common.Response;
import com.dilu.common.base.BaseController;
import com.dilu.service.district.DistrictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guonima
 * @create 2017-09-20 11:20
 */
@RestController
@RequestMapping("/district")
@Api(value = "DistrictController", description = "区域信息处理")
public class DistrictController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DistrictService districtService;

    @ApiOperation(value = "获取省份信息", notes = "获取地区表中配置的省份信息")
    @RequestMapping(value = "/province", method = {RequestMethod.GET})
    public Response findProvinceData() {
        return success(districtService.findProvinces());
    }


    @ApiOperation(value = "获取城市信息", notes = "获取地区表中配置的城市信息")
    @ApiImplicitParam(name = "code", value = "区域代码值", dataType = "String", paramType = "path", required = true)
    @RequestMapping(value = "/city/{code}", method = {RequestMethod.GET})
    public Response findCityData(@PathVariable String code) {
        if(StringUtils.isEmpty(code)){
            return error(1000, "区域代码值不能为空");
        }
        return success(districtService.findCities(code));
    }

    @ApiOperation(value = "获取行政区信息", notes = "获取地区表中配置的行政区信息")
    @ApiImplicitParam(name = "code", value = "区域代码值", dataType = "String", paramType = "path", required = true)
    @RequestMapping(value = "/area/{code}", method = {RequestMethod.GET})
    public Response findAreaData(@PathVariable String code) {

        if(StringUtils.isEmpty(code)){
            return error(1000, "区域代码值不能为空");
        }
        return success(districtService.findAreas(code));
    }

}
