package com.dilu.service;

import com.dilu.common.base.impl.AbstractService;
import com.dilu.dao.feedback.FeedbackMapper;
import com.dilu.domain.feedback.FeedbackDO;
import com.dilu.service.feedback.FeedbackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * transactional 事务控制测试
 *  Transaction rolled back because it has been marked as rollback-only
 *  异常处理
 *
 * @author guonima
 * @create 2017-10-27 11:24
 */
@Service("testService")
public class TestServiceImpl extends AbstractService<FeedbackDO, Long> implements TestService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FeedbackMapper feedbackMapper;

    @Autowired
    private FeedbackService feedbackService;

    @Autowired
    public void setBaseMapper(){
        super.setBaseMapper(feedbackMapper);
    }

    @Transactional
    public int update(FeedbackDO feedbackDO){
        return super.update(feedbackDO);
    }

    @Transactional
    public int insert(FeedbackDO feedbackDO) {
        return super.insert(feedbackDO);
    }

    /**
     * 测试事务回滚 与 不回滚
     * @param feedbackDO
     * @return
     */
    @Transactional
    public int save(FeedbackDO feedbackDO){
        try {
            feedbackService.insert(feedbackDO);
        } catch(Exception e) {
            logger.error("保存出现异常");
            e.printStackTrace();
//            throw e;
        }
        feedbackDO.setId(12L);
        update(feedbackDO);
        return -1;
    }



}
