package com.dilu.controller.coupon;

import com.dilu.common.Response;
import com.dilu.common.base.BaseController;
import com.dilu.domain.coupon.CouponReceiveDO;
import com.dilu.domain.coupon.CouponReceiveDTO;
import com.dilu.service.coupon.CouponReceiveService;
import com.dilu.service.dictionary.DictionaryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author guonima
 * @create 2017-09-21 15:57
 */
@RestController
@RequestMapping("/coupons")
@Api(value = "CouponReceiveController", description = "优惠券信息处理")
public class CouponReceiveController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CouponReceiveService couponReceiveService;

    @Autowired
    private DictionaryService dictionaryService;

    @ApiOperation(value = "修改用户优惠券信息", notes = "修改用户的优惠券基本信息")
    @ApiImplicitParam(name = "couponReceiveDO", value = "用户优惠券实体信息", dataType = "CouponReceiveDO")
    @RequestMapping(value = "", method = {RequestMethod.PUT})
    public Response update(@RequestBody CouponReceiveDO couponReceiveDO) {
        logger.info("待修改用户优惠券信息：" + couponReceiveDO.toString());

        // 基本规则校验
        StringBuilder sb = new StringBuilder();
        Integer status = couponReceiveDO.getStatus();
        if (null == status) {
            sb.append("【优惠券状态】不能为空;");
        }
        Long id = couponReceiveDO.getId();
        if (null == id) {
            sb.append("【优惠券id】不能为空;");
        }
        if (sb.length() != 0) {
            return error(1000, sb.toString());
        }
        return success(couponReceiveService.update(couponReceiveDO));
    }

    @ApiOperation(value = "新增用户优惠券信息", notes = "新增用户的优惠券基本信息")
    @ApiImplicitParam(name = "couponReceiveDO", value = "用户优惠券实体信息", dataType = "CouponReceiveDO")
    @RequestMapping(value = "", method = {RequestMethod.POST})
    public Response insert(@RequestBody CouponReceiveDO couponReceiveDO) {
        logger.info("待新增用户优惠券信息：" + couponReceiveDO.toString());

        // 基本规则校验
        StringBuilder sb = new StringBuilder();
        Long memberId = couponReceiveDO.getMemberId();
        if (null == memberId) {
            sb.append("【会员id】不能为空;");
        }
        Long couponId = couponReceiveDO.getCouponId();
        if (null == couponId) {
            sb.append("【优惠券id】不能为空;");
        }
        if (sb.length() != 0) {
            return error(1000, sb.toString());
        }
        return success(couponReceiveService.insert(couponReceiveDO));
    }

    @ApiOperation(value = "获取用户优惠券信息", notes = "通过用户id获取用户的优惠券信息")
    @ApiImplicitParam(name = "id", value = "优惠券唯一标识id", required = true, dataType = "String", paramType = "path")
    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    public Response findById(@PathVariable String id) {
        logger.info("获取用户优惠券信息：" + id);

        CouponReceiveDTO couponReceiveDTO = CouponUtil.couponReceiveDO2CouponReceiveDTO(
                couponReceiveService.findById(Long.valueOf(id)),  dictionaryService);
        return success(couponReceiveDTO);
    }

    @ApiOperation(value = "获取用户所有优惠券信息", notes = "获取用户的所有优惠券信息")
    @ApiImplicitParam(name = "memberId", value = "用户唯一标识id", required = true, dataType = "String", paramType = "path")
    @RequestMapping(value = "/member/{memberId}", method = {RequestMethod.GET})
    public Response findListAll(@PathVariable String memberId) {
        logger.info("获取用户所有优惠券信息会员id ：" + memberId);

        CouponReceiveDO couponReceiveDO = new CouponReceiveDO();
        couponReceiveDO.setMemberId(Long.valueOf(memberId));
        couponReceiveDO.setEndTime(new Date());// 查询有效结束时间为当前时间之后的优惠券
        List<CouponReceiveDO> list = couponReceiveService.queryListAll(couponReceiveDO);

        CouponReceiveDTO couponReceiveDTO = null;
        List<CouponReceiveDTO> result = new ArrayList<>();
        for (CouponReceiveDO cd : list) {
            couponReceiveDTO = CouponUtil.couponReceiveDO2CouponReceiveDTO(cd, dictionaryService);
            result.add(couponReceiveDTO);
        }
        return success(result);
    }



}
