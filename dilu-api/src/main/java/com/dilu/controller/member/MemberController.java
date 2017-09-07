package com.dilu.controller.member;

import com.dilu.common.base.BaseController;
import com.dilu.domain.member.MemberDO;
import com.dilu.service.member.MemberService;
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
 * @create 2017-09-06 11:18
 */
@RestController
@RequestMapping("/members")
public class MemberController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MemberService memberService;

    @ApiOperation(value = "获取用户信息", notes = "通过用户id获取用户的信息")
    @ApiImplicitParam(name = "id", value = "用户唯一标识id", required = true, dataType = "String")
    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    public MemberDO findUsers(@PathVariable(value = "id") String id) {
        logger.info("获取用户信息：" + id);
        if (StringUtils.isEmpty(id)) {
            return null;
        }
        return memberService.findById(Long.valueOf(id));
    }

    @ApiOperation(value = "删除用户信息", notes = "通过用户id删除用户的信息")
    @ApiImplicitParam(name = "id", value = "用户唯一标识id", required = true, dataType = "String")
    @RequestMapping(value = "/{id}", method = {RequestMethod.DELETE})
    public int delete(@PathVariable(value = "id", required = true) String id) {
        logger.info("删除用户信息：" + id);
        if (StringUtils.isEmpty(id)) {
            return 0;
        }
        return memberService.deleteById(Long.valueOf(id));
    }
}
