package com.dilu.controller.reservation;

import com.dilu.common.Response;
import com.dilu.common.base.BaseController;
import com.dilu.domain.reservation.ReservationDO;
import com.dilu.service.reservation.ReservationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author guonima
 * @create 2017-09-26 14:17
 */
@RestController
@RequestMapping("/reservations")
@Api(value = "ReservationController", description = "预定订单信息处理")
public class ReservationController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ReservationService reservationService;

    @ApiOperation(value = "新增订单信息", notes = "保存订单的基本信息")
    @ApiImplicitParam(name = "reservationDO", value = "订单实体信息", dataType = "ReservationDO")
    @RequestMapping(value = "", method = {RequestMethod.POST})
    public Response save(@RequestBody ReservationDO reservationDO) {
        logger.info("待保存订单信息：" + reservationDO.toString());

        StringBuilder sb = new StringBuilder();
        if(null == reservationDO.getMemberId()){
            sb.append("会员id不能为空;");
        }
        if(StringUtils.isEmpty(reservationDO.getShoppingCarIds())){
            sb.append("购物车无数据;");
        }
        if(null == reservationDO.getConsigneeId()){
            sb.append("收货地址不能为空;");
        }
        if(null == reservationDO.getCost() || reservationDO.getCost().intValue() == 0){
            sb.append("订单金额不能为空;");
        }
        if (sb.length() != 0) {
            return error(1000, sb.toString());
        }
        return success(reservationService.insert(reservationDO));
    }

    @ApiOperation(value = "修改订单信息", notes = "修改订单的基本信息")
    @ApiImplicitParam(name = "reservationDO", value = "订单实体信息", dataType = "ReservationDO")
    @RequestMapping(value = "", method = {RequestMethod.PUT})
    public Response update(@RequestBody ReservationDO reservationDO) {
        logger.info("待修改订单信息：" + reservationDO.toString());

        if (null == reservationDO.getId()) {
            return error(1000, "订单唯一标识不能为空");
        }
        return success(reservationService.update(reservationDO));
    }

    @ApiOperation(value = "获取订单信息", notes = "通过分页信息、查询条件获取订单信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "第几页", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页数量", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "status", value = "订单状态", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "memberId", value = "会员唯一标识id", required = true, dataType = "String", paramType = "query"),
    })
    @RequestMapping(value = "", method = {RequestMethod.GET})
    public Response findReservations(@RequestParam String pageNum, @RequestParam String pageSize,
                               @RequestParam String status, @RequestParam String memberId) {
        logger.info("获取订单信息，第几页：{}；每页数量{}", pageNum, pageSize);

        if (StringUtils.isEmpty(pageNum)) {
            pageNum = "1";
        }
        if (StringUtils.isEmpty(pageSize)) {
            pageSize = "10";
        }
        Map<String, Object> param = new HashMap<>();
        param.put("status", status);
        param.put("memberId", memberId);
        PageHelper.startPage(Integer.valueOf(pageNum), Integer.valueOf(pageSize), " create_time desc ");
        List<ReservationDO> list = reservationService.queryListByPageEntity(param);
        for (ReservationDO rd : list) {
            // TODO 待处理
        }
        return handlerPagination(new PageInfo(list));
    }

    @ApiOperation(value = "获取指定订单信息", notes = "通过订单唯一标识获取订单信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "订单信息唯一标识", required = true, dataType = "String", paramType = "path"),
    })
    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    public Response findReservationById(@PathVariable String id) {
        logger.info("获取订单信息，订单唯一标示ID：{}", id);

        return success(reservationService.findById(Long.valueOf(id)));
    }

}
