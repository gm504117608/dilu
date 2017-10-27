package com.dilu.service;


import com.dilu.domain.feedback.FeedbackDO;

/**
 * @author guonima
 * @create 2017-10-27 11:24
 */
public interface TestService {

    public int update(FeedbackDO feedbackDO);

    public int insert(FeedbackDO feedbackDO);

    public int save(FeedbackDO feedbackDO);

}
