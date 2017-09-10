package com.dilu.service.member.impl;

import com.alibaba.fastjson.JSONObject;
import com.dilu.common.base.impl.AbstractService;
import com.dilu.dao.member.MemberMapper;
import com.dilu.domain.member.MemberDO;
import com.dilu.service.member.MemberService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

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

    public Map<String, Object> login(MemberDO memberDO){
        return null;
    }


    @Override
    public String getWxOpenidSessionKey(MemberDO memberDO, String code, String encryptedData, String iv) {

        String url = Environment.WX_CODE_URL +
                "?appid=" + Environment.WX_APPID +
                "&secret=" + Environment.WX_SECRET +
                "&js_code=" + code +
                "&grant_type=authorization_code";
        String result = HttpUtil.getResponseByPost(url);
        logger.debug("通过登录凭证获取微信信息 ： " + result);

        if (StringUtils.isEmpty(result)) {
            return "通过登录凭证获取微信信息出现异常";
        }
        JSONObject wxInfo = JSONObject.parseObject(result);
        Integer errCode = (Integer) wxInfo.get("errcode");
        if (null == errCode) {
            // 通过sessionKey 和 iv 来解密 encryptedData 数据获取 UnionID (小程序绑定公众号之后的关联值) 。
            String session_key = (String) wxInfo.get("session_key"); //
            String openid = (String) wxInfo.get("openid");
            Integer expires_in = (Integer) wxInfo.get("expires_in");
            memberDO.setOpenid(openid);
            // 对encryptedData加密数据进行AES解密
            decryptEncryptedData(memberDO, encryptedData, session_key, iv);
        }
        return (String) wxInfo.get("errmsg");
    }

}
