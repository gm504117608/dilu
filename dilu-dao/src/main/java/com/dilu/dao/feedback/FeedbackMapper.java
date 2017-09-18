package com.dilu.dao.feedback;

import com.dilu.common.base.BaseMapper;
import com.dilu.domain.feedback.FeedbackDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author guonima
 * @create 2017-09-18 16:25
 */
@Mapper
public interface FeedbackMapper extends BaseMapper<FeedbackDO, Long> {
}
