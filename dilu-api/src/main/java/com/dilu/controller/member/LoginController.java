package com.dilu.controller.member;

import com.dilu.common.Response;
import com.dilu.common.base.BaseController;
import com.dilu.config.SystemResourcesConfig;
import com.dilu.domain.member.MemberDO;
import com.dilu.domain.member.MemberDTO;
import com.dilu.service.member.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author : guonima
 * @create : 2017-09-10-17:00
 */
@Api(value = "LoginController", description = "登录、登出业务处理入口")
@RestController
public class LoginController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MemberService memberService;

    @ApiOperation(value = "登录", notes = "用户登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "memberDTO", value = "用户信息", required = true, dataType = "MemberDTO"),
            @ApiImplicitParam(name = "token", value = "会话唯一标识", required = false, dataType = "String", paramType = "header"),
    })
    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    public Response login(@RequestBody MemberDTO memberDTO, @RequestHeader String token) {
        logger.info("会员信息memberDTO：{}；会话token：{}", memberDTO.toString(), token);

        StringBuffer sb = new StringBuffer();
        String code = memberDTO.getCode();
        if (StringUtils.isEmpty(code)) {
            sb.append("登录凭证code不能为空;");
        }
        if (sb.length() != 0) {
            return error(1000, sb.toString());
        }
        MemberDO memberDO = new MemberDO();
        MemberUtil.MemberDTO2MemberDO(memberDTO, memberDO);
        String result = memberService.getWxOpenidSessionKey(memberDO, code,
                memberDTO.getEncryptedData(), memberDTO.getIv());
        if (StringUtils.isNotEmpty(result)) {
            return error(2000, result);
        }
        return success(memberService.login(memberDO, token));
    }

    @ApiOperation(value = "退出登录", notes = "用户退出登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户唯一标识token", required = true, paramType = "query", dataType = "String"),
    })
    @RequestMapping(value = "/logout", method = {RequestMethod.GET})
    public Response logout(@RequestParam(value = "token", required = true) String token) throws Exception {
        logger.info("token=" + token + " ======= " + SystemResourcesConfig.WX_APPID);


        //TODO 待开发。。。
        return null;
    }
}
