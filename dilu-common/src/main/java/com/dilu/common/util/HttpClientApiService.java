package com.dilu.common.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * httpclient封装类
 *
 * @author guonima
 * @create 2017-09-11 11:25
 */
@Component
public class HttpClientApiService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CloseableHttpClient httpClient;

    @Autowired
    private RequestConfig config;

    /**
     * 不带参数的get请求，如果状态码为200，则返回body，如果不为200，则返回null
     *
     * @param url
     * @return
     * @throws Exception
     */
    public String doGet(String url) throws Exception {
        logger.info("get请求地址：" + url);

        // 声明 http get 请求
        HttpGet httpGet = new HttpGet(url);
        // 装载配置信息
        httpGet.setConfig(config);

        CloseableHttpResponse response = null;
        HttpEntity entity = null;

        try {
            // 发起请求
            response = this.httpClient.execute(httpGet);
            entity = response.getEntity();
            // 判断状态码是否为200
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                // 返回响应体的内容
                return EntityUtils.toString(response.getEntity(), "UTF-8");
            }
            EntityUtils.consumeQuietly(entity); // 释放资源
            response.close();
        } catch (Exception e) {
            throw e;
        } finally {
            if (entity != null) {
                EntityUtils.consumeQuietly(entity);
            }
            if (response != null) {
                response.close();
            }
        }
        return null;
    }

    /**
     * 带参数的get请求，如果状态码为200，则返回body，如果不为200，则返回null
     *
     * @param url
     * @return
     * @throws Exception
     */
    public String doGet(String url, Map<String, Object> map) throws Exception {
        logger.info("get请求参数：" + map.toString());

        URIBuilder uriBuilder = new URIBuilder(url);
        if (map != null) {
            // 遍历map,拼接请求参数
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                uriBuilder.setParameter(entry.getKey(), entry.getValue().toString());
            }
        }
        // 调用不带参数的get请求
        return this.doGet(uriBuilder.build().toString());
    }

    /**
     * 带参数的post请求
     *
     * @param url
     * @param map
     * @return
     * @throws Exception
     */
    public String doPost(String url, Map<String, Object> map) throws Exception {
        logger.info("post请求地址：{}； post请求参数：{}", url, map.toString());

        // 声明httpPost请求
        HttpPost httpPost = new HttpPost(url);
        // 加入配置信息
        httpPost.setConfig(config);
        // 判断map是否为空，不为空则进行遍历，封装from表单对象
        if (map != null) {
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                list.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
            }
            // 构造from表单对象
            UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(list, "UTF-8");
            // 把表单放到post里
            httpPost.setEntity(urlEncodedFormEntity);
        }
        return doPost(httpPost);
    }

    /**
     * 不带参数post请求
     *
     * @param url
     * @return
     * @throws Exception
     */
    public String doPost(String url) throws Exception {
        logger.info("post请求地址：" + url);

        // 声明httpPost请求
        HttpPost httpPost = new HttpPost(url);
        // 加入配置信息
        httpPost.setConfig(config);
        return doPost(httpPost);
    }

    /**
     * post通过json方式调用url
     *
     * @param url     调用URL地址
     * @param jsonStr json格式字符串
     * @return
     */
    public String doPost(String url, String jsonStr) throws Exception {
        logger.info("post请求地址：{}； post请求参数：{}", url, jsonStr);

        // 声明httpPost请求
        HttpPost httpPost = new HttpPost(url);
        // 加入配置信息
        httpPost.setConfig(config);
        // 构建参数
        if (StringUtils.isNotEmpty(jsonStr)) {
            StringEntity se = new StringEntity(jsonStr, "UTF-8");
            se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
            httpPost.setEntity(se);
        }
        return doPost(httpPost);
    }

    /**
     * post请求处理
     *
     * @param httpPost
     * @return
     * @throws Exception
     */
    private String doPost(HttpPost httpPost) throws Exception {
        CloseableHttpResponse response = null;
        HttpEntity entity = null;
        try {
            // 发起请求
            response = this.httpClient.execute(httpPost);
            entity = response.getEntity();
            // 判断状态码是否为200
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                // 返回响应体的内容
                return EntityUtils.toString(entity, "UTF-8");
            }
            EntityUtils.consumeQuietly(entity); // 释放资源
            response.close();
        } catch (Exception e) {
            throw e;
        } finally {
            if (entity != null) {
                EntityUtils.consumeQuietly(entity);
            }
            if (response != null) {
                response.close();
            }
        }
        return null;
    }

}
