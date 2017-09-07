package com.dilu.dao.member;

import com.dilu.common.base.BaseMapper;
import com.dilu.domain.member.MemberDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author guonima
 * @create 2017-09-06 11:31
 */
@Mapper
public interface MemberMapper extends BaseMapper<MemberDO, Long> {
}
