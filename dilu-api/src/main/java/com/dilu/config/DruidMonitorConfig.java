package com.dilu.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * druid监控配置类
 *
 * @author guonima
 * @create 2017-09-08 15:29
 */
@Configuration
@ConfigurationProperties(prefix = "druid.monitor")
@PropertySource(value = {"classpath:config/druid-monitor.properties"}, encoding = "utf-8")
public class DruidMonitorConfig {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // druid监控拦截配置
    private String loginUsername;
    private String loginPassword;
    private String allow;
    private String deny;
    private String exclusions;
    private String profileEnable;
    private String resetEnable;


    /**
     * druid监控拦截配置、类似于web.xml中servlet拦截配置
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean druidServlet() {
        ServletRegistrationBean reg = new ServletRegistrationBean();
        reg.setServlet(new StatViewServlet());
        reg.addUrlMappings("/druid/*");
        reg.addInitParameter("loginUsername", loginUsername);
        reg.addInitParameter("loginPassword", loginPassword);
        reg.addInitParameter("allow", allow);// IP白名单(没有配置或者为空，则允许所有访问)
        reg.addInitParameter("deny", deny);// IP黑名单 (存在共同时，deny优先于allow)
        reg.addInitParameter("resetEnable", resetEnable); // 是否能够重置数据
        return reg;
    }

    /**
     * druid监控拦截过滤配置、类似于web.xml中filter的配置
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", exclusions); // 过滤资源
        filterRegistrationBean.addInitParameter("profileEnable", profileEnable);
        return filterRegistrationBean;
    }

    public String getLoginUsername() {
        return loginUsername;
    }

    public void setLoginUsername(String loginUsername) {
        this.loginUsername = loginUsername;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getAllow() {
        return allow;
    }

    public void setAllow(String allow) {
        this.allow = allow;
    }

    public String getDeny() {
        return deny;
    }

    public void setDeny(String deny) {
        this.deny = deny;
    }

    public String getExclusions() {
        return exclusions;
    }

    public void setExclusions(String exclusions) {
        this.exclusions = exclusions;
    }

    public String getProfileEnable() {
        return profileEnable;
    }

    public void setProfileEnable(String profileEnable) {
        this.profileEnable = profileEnable;
    }

    public String getResetEnable() {
        return resetEnable;
    }

    public void setResetEnable(String resetEnable) {
        this.resetEnable = resetEnable;
    }
}
