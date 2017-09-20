package com.dilu.controller.feedback;

import com.dilu.common.Response;
import com.dilu.common.base.BaseController;
import com.dilu.common.util.CommonUtil;
import com.dilu.domain.feedback.FeedbackDO;
import com.dilu.service.dictionary.DictionaryService;
import com.dilu.service.feedback.FeedbackService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
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

    @Autowired
    private DictionaryService dictionaryService;

    @ApiOperation(value = "新增用户反馈信息", notes = "保存用户反馈的基本信息")
    @ApiImplicitParam(name = "feedbackDO", value = "用户反馈实体信息", dataType = "FeedbackDO")
    @RequestMapping(value = "", method = {RequestMethod.POST})
    public Response save(@RequestBody FeedbackDO feedbackDO) {
        logger.info("待保存用户反馈信息：" + feedbackDO.toString());

        StringBuilder sb = new StringBuilder();
        String type = feedbackDO.getType();
        if (StringUtils.isEmpty(type)) {
            sb.append("【反馈类型】不能为空;");
        }
        String mobile = feedbackDO.getMobile();
        if (StringUtils.isEmpty(mobile)) {
            sb.append("【联系电话】不能为空;");
        } else {
            if (!CommonUtil.isPhoneNum(mobile)) {
                sb.append("【联系电话】格式不正确;");
            }
        }
        String content = feedbackDO.getContent();
        if (StringUtils.isEmpty(content)) {
            sb.append("【反馈内容】不能为空;");
        } else {
            if (!CommonUtil.checkLength(content, 0, 400)) {
                sb.append("【反馈内容】长度在0到400之间;");
            }
        }
        if (sb.length() != 0) {
            return error(1000, sb.toString());
        }
        return success(feedbackService.insert(feedbackDO));
    }

    @ApiOperation(value = "获取用户反馈类型信息", notes = "获取用户反馈类型在字典表中配置的信息")
    @RequestMapping(value = "/dictionary", method = {RequestMethod.GET})
    public Response findFeedbackType() {
        return success(dictionaryService.getDictionaries("feedback"));
    }

}
