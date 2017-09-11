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

    public Map<String, Object> login(MemberDO memberDO, String token);

    public String getWxOpenidSessionKey(MemberDO memberDO, String code, String encryptedData, String iv);

}
