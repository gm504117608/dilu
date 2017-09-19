package com.dilu.service.member.impl;

import com.alibaba.fastjson.JSONObject;
import com.dilu.common.base.impl.AbstractService;
import com.dilu.common.cache.RedisClient;
import com.dilu.common.exception.ServiceException;
import com.dilu.common.util.AESUtil;
import com.dilu.common.util.HttpClientApiService;
import com.dilu.common.util.MD5Util;
import com.dilu.config.SystemResourcesConfig;
import com.dilu.dao.member.MemberMapper;
import com.dilu.domain.member.MemberDO;
import com.dilu.service.member.MemberService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private RedisClient redisClient;

    @Autowired
    private HttpClientApiService httpClientApiService;

    @Autowired
    public void setBaseMapper() {
        super.setBaseMapper(memberMapper);
    }

    @Transactional
    public Long login(String encryptedData, String iv, String signature, String token) {
        String openid = getRedisToken(token, "openid");
        if (StringUtils.isNotEmpty(openid)) {
            String session_key = getRedisToken(token, "session_key");
            MemberDO memberDO = new MemberDO();
            memberDO.setOpenid(openid);
            // 对encryptedData加密数据进行AES解密
            decryptEncryptedData(memberDO, encryptedData, session_key, iv);
            MemberDO member = getMemberInfo(memberDO);
            Long id = null;
            try {
                if (null == member) { // 新增
                    insert(memberDO);
                    id = memberDO.getId();
                } else { // 修改
                    update(memberDO);
                    id = member.getId();
                }
            } catch (Exception e) {
                throw new ServiceException("微信登录我方应用出现错误：" + e.getMessage());
            }
            return id;
        }
        return null;
    }


    @Override
    public String getWxOpenidSessionKey(String code, String token) {
        if (StringUtils.isNotEmpty(getRedisToken(token, "openid"))) {
            return token;
        }
        String url = SystemResourcesConfig.WX_URL +
                "?appid=" + SystemResourcesConfig.WX_APPID +
                "&secret=" + SystemResourcesConfig.WX_SECRET +
                "&js_code=" + code + "&grant_type=authorization_code";
        String result = null;
        try {
            result = httpClientApiService.doPost(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("通过登录凭证获取微信信息 ： " + result);

        if (StringUtils.isEmpty(result)) {
            return null;
        }
        JSONObject wxInfo = JSONObject.parseObject(result);
        Integer errCode = (Integer) wxInfo.get("errcode");
        if (null == errCode) {
            // 通过sessionKey 和 iv 来解密 encryptedData 数据获取 UnionID (小程序绑定公众号之后的关联值) 。
            String session_key = (String) wxInfo.get("session_key");
            String openid = (String) wxInfo.get("openid");
            return createRedisToken(openid, session_key);
        }
        logger.info("通过登录凭证获取微信信息 ： " + (String) wxInfo.get("errmsg"));
        return null;
    }


    /**
     * 对encryptedData加密数据进行AES解密
     *
     * @param memberDO
     * @param encryptedData
     * @param session_key
     * @param iv
     */
    private void decryptEncryptedData(MemberDO memberDO, String encryptedData, String session_key, String iv) {
        // 解密出来的数据包含了用户的所有信息
        String result = AESUtil.decrypt(encryptedData, session_key, iv);
        if (StringUtils.isNotEmpty(result)) {
            JSONObject userInfo = JSONObject.parseObject(result);
            memberDO.setUnionid(userInfo.getString("unionId"));
            memberDO.setNickName(userInfo.getString("nickName"));
            memberDO.setAvatarUrl(userInfo.getString("avatarUrl"));
            memberDO.setCity(userInfo.getString("city"));
            memberDO.setCountry(userInfo.getString("country"));
            memberDO.setGender(userInfo.getInteger("gender"));
            memberDO.setProvince(userInfo.getString("province"));
        }
    }

    /**
     * 生成token存入redis
     *
     * @param openid      用户唯一标识
     * @param session_key 用户数据进行加密签名的密钥
     */
    private String createRedisToken(String openid, String session_key) {
        String token = MD5Util.md5(openid);
        redisClient.hset(token, "openid", openid);
        redisClient.hset(token, "session_key", session_key);
        redisClient.expire(token, 3 * 24 * 60 * 60);
        return token;
    }

    /**
     * 从redis获取token信息
     *
     * @param token 会话token值
     */
    private String getRedisToken(String token, String filed) {
        return redisClient.hget(token, filed);
    }


    /**
     * 获取会员信息
     *
     * @param memberDO
     * @return
     */
    private MemberDO getMemberInfo(MemberDO memberDO) {
        // 父类里面的方法
        return find(memberDO);
    }

}
