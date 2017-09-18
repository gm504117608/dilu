package com.dilu.controller.feedback;

import com.dilu.common.Response;
import com.dilu.common.base.BaseController;
import com.dilu.domain.feedback.FeedbackDO;
import com.dilu.service.feedback.FeedbackService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guonima
 * @create 2017-09-18 16:37
 */
@RestController
@RequestMapping("/feedback")
@Api(value = "FeedbackController", description = "用户反馈信息处理")
public class FeedbackController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FeedbackService feedbackService;

    @ApiOperation(value = "新增用户反馈信息", notes = "保存用户反馈的基本信息")
    @ApiImplicitParam(name = "feedbackDO", value = "用户反馈实体信息", dataType = "FeedbackDO")
    @RequestMapping(value = "", method = {RequestMethod.POST})
    public Response save(@RequestBody FeedbackDO feedbackDO) {
        logger.info("待保存用户反馈信息：" + feedbackDO.toString());

        return success(feedbackService.insert(feedbackDO));
    }

}
