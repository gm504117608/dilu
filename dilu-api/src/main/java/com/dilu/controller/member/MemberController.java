package com.dilu.controller.member;

import com.dilu.common.Response;
import com.dilu.common.base.BaseController;
import com.dilu.common.util.CommonUtil;
import com.dilu.domain.member.MemberDO;
import com.dilu.domain.member.MemberDTO;
import com.dilu.service.member.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author guonima
 * @create 2017-09-06 11:18
 */
@RestController
@RequestMapping("/members")
@Api(value = "MemberController", description = "会员管理api提供服务类")
public class MemberController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MemberService memberService;

    @ApiOperation(value = "获取用户信息", notes = "通过用户id获取用户的信息")
    @ApiImplicitParam(name = "id", value = "用户唯一标识id", required = true, dataType = "String", paramType = "path")
    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    public Response findMembers(@PathVariable(value = "id") String id) {
        logger.info("获取用户信息：" + id);
        if (StringUtils.isEmpty(id)) {
            return null;
        }
        return success(memberService.findById(Long.valueOf(id)));
    }

    @ApiOperation(value = "删除用户信息", notes = "通过用户id删除用户的信息")
    @ApiImplicitParam(name = "id", value = "用户唯一标识id", required = true, dataType = "String", paramType = "path")
    @RequestMapping(value = "/{id}", method = {RequestMethod.DELETE})
    public Response delete(@PathVariable(value = "id", required = true) String id) {
        logger.info("删除用户信息：" + id);
        if (StringUtils.isEmpty(id)) {
            return error(1000, "用户唯一标识为空");
        }
        return success(memberService.deleteById(Long.valueOf(id)));
    }

    @ApiOperation(value = "新增用户信息", notes = "保存用户的基本信息")
    @ApiImplicitParam(name = "memberDTO", value = "用户实体信息", dataType = "MemberDTO")
    @RequestMapping(value = "", method = {RequestMethod.POST})
    public Response save(@RequestBody MemberDTO memberDTO) {
        logger.info("待保存用户信息：" + memberDTO.toString());

        MemberDO memberDO = new MemberDO();
        MemberUtil.memberDTO2MemberDO(memberDTO, memberDO);
        return success(memberService.insert(memberDO));
    }

    @ApiOperation(value = "修改用户信息", notes = "修改用户的基本信息")
    @ApiImplicitParam(name = "memberDTO", value = "用户实体信息", dataType = "MemberDTO")
    @RequestMapping(value = "", method = {RequestMethod.PUT})
    public Response update(@RequestBody MemberDTO memberDTO) {
        logger.info("待修改用户信息：" + memberDTO.toString());

        StringBuilder sb = new StringBuilder();
        String signature = memberDTO.getSignature();
        if (StringUtils.isNotEmpty(signature)) {
            if (!CommonUtil.checkLength(signature, 1, 180)) {
                sb.append("【个性签名】长度在1到180之间;");
            }
        }
        String mobile = memberDTO.getMobile();
        if (StringUtils.isEmpty(mobile)) {
            sb.append("【联系电话】不能为空;");
        } else {
            if (!CommonUtil.isPhoneNum(mobile)) {
                sb.append("【联系电话】格式不正确;");
            }
        }
        String email = memberDTO.getEmail();
        if (StringUtils.isNotEmpty(email)) {
            if (!CommonUtil.checkEmail(email)) {
                sb.append("【邮箱】格式不正确;");
            }
        }
        if (sb.length() != 0) {
            return error(1000, sb.toString());
        }
        MemberDO memberDO = new MemberDO();
        MemberUtil.memberDTO2MemberDO(memberDTO, memberDO);
        return success(memberService.update(memberDO));
    }
}
