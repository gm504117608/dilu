package com.dilu.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author guonima
 * @create 2017-09-11 9:47
 */
@Configuration
@PropertySource(value = "classpath:config/system-resources.properties", encoding = "utf-8")
public class SystemResourcesConfig {

    // 微信小程序获取openid地址
    public static String WX_URL;

    // 微信小程序appid
    public static String WX_APPID;

    // 微信小程序appid密码
    public static String WX_SECRET;

    @Value(value = "${wx.code.url}")
    public static void setWxUrl(String wxUrl) {
        WX_URL = wxUrl;
    }

    @Value(value = "${wx.appid}")
    public static void setWxAppid(String wxAppid) {
        WX_APPID = wxAppid;
    }

    @Value(value = "${wx.secret}")
    public static void setWxSecret(String wxSecret) {
        WX_SECRET = wxSecret;
    }
}
