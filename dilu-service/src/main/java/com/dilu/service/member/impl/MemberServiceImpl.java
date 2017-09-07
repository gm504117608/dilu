package com.dilu.service.member.impl;

import com.dilu.common.base.impl.AbstractService;
import com.dilu.dao.member.MemberMapper;
import com.dilu.domain.member.MemberDO;
import com.dilu.service.member.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author guonima
 * @create 2017-09-06 11:25
 */
@Service("memberService")
public class MemberServiceImpl extends AbstractService<MemberDO, Long> implements MemberService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    public void setBaseMapper(){
        super.setBaseMapper(memberMapper);
    }

}
