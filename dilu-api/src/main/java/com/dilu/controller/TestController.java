package com.dilu.controller;

import com.dilu.common.Response;
import com.dilu.common.base.BaseController;
import com.dilu.domain.feedback.FeedbackDO;
import com.dilu.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * 测试事务控制
 *
 * @author guonima
 * @create 2017-10-27 11:23
 */
@RestController
@RequestMapping("/test")
public class TestController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TestService testService;

    @RequestMapping(value = "", method = {RequestMethod.GET})
    public Response testTransactional() {
        FeedbackDO feedbackDO = new FeedbackDO();
        feedbackDO.setContent("123");
        feedbackDO.setType("123");
        feedbackDO.setIsDispose(1);
        feedbackDO.setMemberId(123L);
        feedbackDO.setMobile("122222223");
        feedbackDO.setCreateUser(123L);
        try {
            testService.insert(feedbackDO);
        } catch(Exception e) {
            logger.error("保存出现异常");
            e.printStackTrace();
            throw e;
        }
        feedbackDO.setId(12L);
        testService.update(feedbackDO);

        return null;
    }

}
