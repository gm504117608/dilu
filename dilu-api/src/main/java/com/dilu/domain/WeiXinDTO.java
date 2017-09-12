package com.dilu.domain;

import java.io.Serializable;

/**
 * 微信获取用户信息加解密信息
 * @author guonima
 * @create 2017-09-12 17:45
 */
public class WeiXinDTO implements Serializable {

    private String code; // 登录凭证
    private String encryptedData; // 包括敏感数据在内的完整用户信息的加密数据
    private String iv; // 加密算法的初始向量
    private String signature; // 微信对用户信息签名串（用于验证用户信息是否完整）

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEncryptedData() {
        return encryptedData;
    }

    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "WeiXinDTO{" +
                "code='" + code + '\'' +
                ", encryptedData='" + encryptedData + '\'' +
                ", iv='" + iv + '\'' +
                ", signature='" + signature + '\'' +
                '}';
    }
}
