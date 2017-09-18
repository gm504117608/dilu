package com.dilu.service.feedback.impl;

import com.dilu.common.base.impl.AbstractService;
import com.dilu.dao.feedback.FeedbackMapper;
import com.dilu.domain.feedback.FeedbackDO;
import com.dilu.service.feedback.FeedbackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author guonima
 * @create 2017-09-18 16:33
 */
@Service("feedbackService")
public class FeedbackServiceImpl extends AbstractService<FeedbackDO, Long> implements FeedbackService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FeedbackMapper feedbackMapper;

    @Autowired
    public void setBaseMapper() {
        super.setBaseMapper(feedbackMapper);
    }
}
