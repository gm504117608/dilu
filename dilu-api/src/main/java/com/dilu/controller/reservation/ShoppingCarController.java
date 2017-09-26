package com.dilu.controller.reservation;

import com.dilu.common.Response;
import com.dilu.common.base.BaseController;
import com.dilu.controller.photo.PhotoUtil;
import com.dilu.domain.Reservation.ShoppingCarDTO;
import com.dilu.domain.reservation.ShoppingCarDO;
import com.dilu.service.dictionary.DictionaryService;
import com.dilu.service.photo.PhotoDetailService;
import com.dilu.service.photo.PhotoService;
import com.dilu.service.reservation.ShoppingCarService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guonima
 * @create 2017-09-25 16:48
 */
@RestController
@RequestMapping("/shopping")
@Api(value = "ShoppingCarController", description = "购物车信息处理")
public class ShoppingCarController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ShoppingCarService shoppingCarService;

    @Autowired
    private PhotoService photoService;

    @Autowired
    private PhotoDetailService photoDetailService;

    @Autowired
    private DictionaryService dictionaryService;


    @ApiOperation(value = "获取购物车信息", notes = "通过查询条件获取购物车信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "memberId", value = "会员唯一标识id", required = true, dataType = "String", paramType = "path"),
    })
    @RequestMapping(value = "/member/{memberId}", method = {RequestMethod.GET})
    public Response findShoppingCar(@PathVariable String memberId) {
        logger.info("获取购物车信息，会员id：{}", memberId);

        if (StringUtils.isEmpty(memberId)) {
            return error(1000, "会员唯一标识为空");
        }
        ShoppingCarDO shoppingCarDO = new ShoppingCarDO();
        shoppingCarDO.setMemberId(Long.valueOf(memberId));
        shoppingCarDO.setType(0);
        List<ShoppingCarDO> list = shoppingCarService.queryListAll(shoppingCarDO);
        List<ShoppingCarDTO> result = new ArrayList<>();
        ShoppingCarDTO shoppingCarDTO = null;
        for (ShoppingCarDO scd : list) {
            shoppingCarDTO = ShoppingCarUtil.ShoppingCarDO2ShoppingCarDTO(scd);
            shoppingCarDTO.setPhotoDTO(PhotoUtil.PhotoDO2PhotoDTO(
                    photoService.findById(scd.getPhotoId()), dictionaryService));
            result.add(shoppingCarDTO);
        }
        return success(result);
    }

    @ApiOperation(value = "删除购物车信息", notes = "通过购物车id删除购物车的信息")
    @ApiImplicitParam(name = "id", value = "购物车唯一标识id", required = true, dataType = "String", paramType = "path")
    @RequestMapping(value = "/{id}", method = {RequestMethod.DELETE})
    public Response delete(@PathVariable(value = "id", required = true) String id) {
        logger.info("删除购物车信息：" + id);

        if (StringUtils.isEmpty(id)) {
            return error(1000, "购物车唯一标识为空");
        }
        return success(shoppingCarService.deleteById(Long.valueOf(id)));
    }

    @ApiOperation(value = "新增购物车信息", notes = "保存购物车的基本信息")
    @ApiImplicitParam(name = "shoppingCarDO", value = "购物车实体信息", dataType = "ShoppingCarDO")
    @RequestMapping(value = "", method = {RequestMethod.POST})
    public Response save(@RequestBody ShoppingCarDO shoppingCarDO) {
        logger.info("待保存购物车信息：" + shoppingCarDO.toString());

        StringBuilder sb = new StringBuilder();
        if(null == shoppingCarDO.getMemberId()){
            sb.append("会员id不能为空;");
        }
        if(null == shoppingCarDO.getPhotoId()){
            sb.append("相册模板id不能为空;");
        }
        if(null == shoppingCarDO.getQuantity()){
            sb.append("预订数量不能为空;");
        }
        if (sb.length() != 0) {
            return error(1000, sb.toString());
        }
        return success(shoppingCarService.insert(shoppingCarDO));
    }

    @ApiOperation(value = "修改购物车信息", notes = "修改购物车的基本信息")
    @ApiImplicitParam(name = "memberDTO", value = "购物车实体信息", dataType = "MemberDTO")
    @RequestMapping(value = "", method = {RequestMethod.PUT})
    public Response update(@RequestBody ShoppingCarDO shoppingCarDO) {
        logger.info("待修改购物车信息：" + shoppingCarDO.toString());

        if (null == shoppingCarDO.getId()) {
            return error(1000, "购物车唯一标识不能为空");
        }
        return success(shoppingCarService.update(shoppingCarDO));
    }

}
