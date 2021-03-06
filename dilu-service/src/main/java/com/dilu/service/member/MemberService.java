package com.dilu.service.member;

import com.dilu.domain.member.MemberDO;

import java.util.Map;

/**
 * @author guonima
 * @create 2017-09-06 11:24
 */
public interface MemberService {

    public MemberDO findById(Long id);

    public int deleteById(Long id);

    public int insert(MemberDO memberDO);

    public int update(MemberDO memberDO);

    public Long login(String encryptedData, String iv, String signature, String token);

    public String getWxOpenidSessionKey(String code, String token);

}
