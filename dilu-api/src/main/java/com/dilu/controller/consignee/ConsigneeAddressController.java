package com.dilu.controller.consignee;

import com.dilu.common.Response;
import com.dilu.common.base.BaseController;
import com.dilu.common.util.CommonUtil;
import com.dilu.domain.consignee.ConsigneeAddressDO;
import com.dilu.domain.consignee.ConsigneeAddressDTO;
import com.dilu.service.consignee.ConsigneeAddressService;
import com.dilu.service.district.DistrictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
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
 * @create 2017-09-20 11:11
 */
@RestController
@RequestMapping("/consignee")
@Api(value = "ConsigneeAddressController", description = "用户收件地址信息处理")
public class ConsigneeAddressController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ConsigneeAddressService consigneeAddressService;

    @Autowired
    private DistrictService districtService;


    @ApiOperation(value = "修改用户收件地址信息", notes = "修改用户的收件地址基本信息")
    @ApiImplicitParam(name = "consigneeAddressDO", value = "用户收件地址实体信息", dataType = "ConsigneeAddressDO")
    @RequestMapping(value = "", method = {RequestMethod.PUT})
    public Response update(@RequestBody ConsigneeAddressDO consigneeAddressDO) {
        logger.info("待修改用户收件地址信息：" + consigneeAddressDO.toString());

        // 基本规则校验
        StringBuilder sb = new StringBuilder();
        String name = consigneeAddressDO.getName();
        if (StringUtils.isEmpty(name)) {
            sb.append("【姓名】不能为空;");
        } else {
            if (!CommonUtil.checkLength(name, 1, 40)) {
                sb.append("【姓名】长度在1到40之间;");
            }
        }
        String mobile = consigneeAddressDO.getMobile();
        if (StringUtils.isEmpty(mobile)) {
            sb.append("【联系电话】不能为空;");
        } else {
            if (!CommonUtil.isPhoneNum(mobile)) {
                sb.append("【联系电话】格式不正确;");
            }
        }
        String address = consigneeAddressDO.getAddress();
        if (StringUtils.isEmpty(address)) {
            sb.append("【详细地址】不能为空;");
        } else {
            if (!CommonUtil.checkLength(address, 1, 90)) {
                sb.append("【详细地址】长度在1到90之间;");
            }
        }
        String postcode = consigneeAddressDO.getPostcode();
        if (StringUtils.isEmpty(postcode)) {
            sb.append("【邮编】不能为空;");
        } else {
            if (!CommonUtil.checkLength(postcode, 0, 6)) {
                sb.append("【邮编】长度在0到6之间;");
            }
        }
        if (sb.length() != 0) {
            return error(1000, sb.toString());
        }
        return success(consigneeAddressService.save(consigneeAddressDO));
    }

    @ApiOperation(value = "新增用户收件地址信息", notes = "新增用户的收件地址基本信息")
    @ApiImplicitParam(name = "consigneeAddressDO", value = "用户收件地址实体信息", dataType = "ConsigneeAddressDO")
    @RequestMapping(value = "", method = {RequestMethod.POST})
    public Response insert(@RequestBody ConsigneeAddressDO consigneeAddressDO) {
        logger.info("待新增用户收件地址信息：" + consigneeAddressDO.toString());

        // 基本规则校验
        StringBuilder sb = new StringBuilder();
        String name = consigneeAddressDO.getName();
        if (StringUtils.isEmpty(name)) {
            sb.append("【姓名】不能为空;");
        } else {
            if (!CommonUtil.checkLength(name, 1, 40)) {
                sb.append("【姓名】长度在1到40之间;");
            }
        }
        String mobile = consigneeAddressDO.getMobile();
        if (StringUtils.isEmpty(mobile)) {
            sb.append("【联系电话】不能为空;");
        } else {
            if (!CommonUtil.isPhoneNum(mobile)) {
                sb.append("【联系电话】格式不正确;");
            }
        }
        String address = consigneeAddressDO.getAddress();
        if (StringUtils.isEmpty(address)) {
            sb.append("【详细地址】不能为空;");
        } else {
            if (!CommonUtil.checkLength(address, 1, 90)) {
                sb.append("【详细地址】长度在1到90之间;");
            }
        }
        String postcode = consigneeAddressDO.getPostcode();
        if (StringUtils.isEmpty(postcode)) {
            sb.append("【邮编】不能为空;");
        } else {
            if (!CommonUtil.checkLength(postcode, 0, 6)) {
                sb.append("【邮编】长度在0到6之间;");
            }
        }
        if (sb.length() != 0) {
            return error(1000, sb.toString());
        }
        return success(consigneeAddressService.save(consigneeAddressDO));
    }

    @ApiOperation(value = "删除用户收件地址信息", notes = "通过用户id删除用户的收件地址信息")
    @ApiImplicitParam(name = "id", value = "用户唯一标识id", required = true, dataType = "String", paramType = "path")
    @RequestMapping(value = "/{id}", method = {RequestMethod.DELETE})
    public Response delete(@PathVariable(value = "id", required = true) String id) {
        logger.info("删除用户收件地址信息：" + id);

        if (StringUtils.isEmpty(id)) {
            return error(1000, "用户唯一标识为空");
        }
        return success(consigneeAddressService.deleteById(Long.valueOf(id)));
    }

    @ApiOperation(value = "获取用户收件地址信息", notes = "通过用户id获取用户的收件地址信息")
    @ApiImplicitParam(name = "id", value = "收件地址唯一标识id", required = true, dataType = "String", paramType = "path")
    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    public Response findById(@PathVariable(value = "id", required = true) String id) {
        logger.info("获取用户收件地址信息：" + id);

        return success(consigneeAddressService.findById(Long.valueOf(id)));
    }

    @ApiOperation(value = "获取用户所有收件地址信息", notes = "获取用户的所有收件地址信息")
    @ApiImplicitParam(name = "memberId", value = "用户唯一标识id", required = true, dataType = "String", paramType = "path")
    @RequestMapping(value = "/member/{memberId}", method = {RequestMethod.GET})
    public Response findListAll(@PathVariable String memberId) {
        logger.info("获取用户所有收件地址信息会员id ：" + memberId);

        ConsigneeAddressDO consigneeAddressDO = new ConsigneeAddressDO();
        consigneeAddressDO.setMemberId(Long.valueOf(memberId));
        List<ConsigneeAddressDO> list = consigneeAddressService.queryListAll(consigneeAddressDO);

        ConsigneeAddressDTO consigneeAddressDTO = null;
        List<ConsigneeAddressDTO> result = new ArrayList<>();
        for (ConsigneeAddressDO cd : list) {
            consigneeAddressDTO = new ConsigneeAddressDTO();
            ConsigneeAddressUtil.consigneeAddressDO2consigneeAddressDTO(
                    cd, consigneeAddressDTO, districtService);
            result.add(consigneeAddressDTO);
        }

        return success(result);
    }

}
