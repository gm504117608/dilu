package com.dilu.controller.member;

import com.dilu.domain.member.MemberDO;
import com.dilu.domain.member.MemberDTO;

/**
 * @author guonima
 * @create 2017-09-11 18:10
 */
public class MemberUtil {

    private MemberUtil() {
    }

    /**
     * 将界面传入实体数据赋值到数据库表对应实体数据
     *
     * @param memberDTO 界面传入会员实体信息
     * @param memberDO  数据库表会员实体信息
     */
    public static void memberDTO2MemberDO(MemberDTO memberDTO, MemberDO memberDO) {
        memberDO.setId(memberDTO.getId());
        memberDO.setNickName(memberDTO.getNickName());
        memberDO.setMobile(memberDTO.getMobile());
        memberDO.setEmail(memberDTO.getEmail());
        memberDO.setGender(memberDTO.getGender());
        memberDO.setCountry(memberDTO.getCountry());
        memberDO.setProvince(memberDTO.getProvince());
        memberDO.setCity(memberDTO.getCity());
        memberDO.setAvatarUrl(memberDTO.getAvatarUrl());
        memberDO.setSignature(memberDTO.getSignature());
    }

}
