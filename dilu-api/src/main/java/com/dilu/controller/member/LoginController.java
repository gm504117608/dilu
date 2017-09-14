package com.dilu.controller.member;

import com.dilu.common.Response;
import com.dilu.common.base.BaseController;
import com.dilu.config.SystemResourcesConfig;
import com.dilu.domain.WeiXinDTO;
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
            @ApiImplicitParam(name = "weiXinDTO", value = "微信用户信息加解密信息", required = true, dataType = "WeiXinDTO"),
            @ApiImplicitParam(name = "token", value = "会话唯一标识", required = false, dataType = "String", paramType = "header"),
    })
    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    public Response login(@RequestBody WeiXinDTO weiXinDTO, @RequestHeader String token) {
        logger.info("用户加解密信息weiXinDTO：{}；会话token：{}", weiXinDTO.toString(), token);

        StringBuffer sb = new StringBuffer();
        String signature = weiXinDTO.getSignature();
        if (StringUtils.isEmpty(signature)) {
            sb.append("签名串不能为空;");
        }
        String iv = weiXinDTO.getIv();
        if (StringUtils.isEmpty(iv)) {
            sb.append("加密算法的初始向量不能为空;");
        }
        String encryptedData = weiXinDTO.getEncryptedData();
        if (StringUtils.isEmpty(encryptedData)) {
            sb.append("用户加密信息不能为空;");
        }
        if (sb.length() != 0) {
            return error(1000, sb.toString());
        }
        return success(memberService.login(encryptedData, iv, signature, token));
    }

    @ApiOperation(value = "退出登录", notes = "用户退出登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户唯一标识token", required = true, paramType = "query", dataType = "String"),
    })
    @RequestMapping(value = "/logout", method = {RequestMethod.GET})
    public Response logout(@RequestParam(value = "token", required = true) String token) throws Exception {
        logger.info("token=" + token);


        //TODO 待开发。。。
        return null;
    }

    @ApiOperation(value = "微信登录code处理", notes = "用户微信进入小程序之后对获取到的code进行处理")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code", value = "登录凭证code", required = true, paramType = "path", dataType = "String"),
            @ApiImplicitParam(name = "token", value = "会话唯一标识", required = false, dataType = "String", paramType = "header"),
    })
    @RequestMapping(value = "/code/{code}", method = {RequestMethod.GET})
    public Response parseCode(@PathVariable String code, @RequestHeader String token) {
        logger.info("code={}, token={}", code, token);

        StringBuffer sb = new StringBuffer();
        if (StringUtils.isEmpty(code)) {
            sb.append("登录凭证code不能为空;");
        }
        if (sb.length() != 0) {
            return error(1000, sb.toString());
        }
        return success(memberService.getWxOpenidSessionKey(code, token));
    }
}
