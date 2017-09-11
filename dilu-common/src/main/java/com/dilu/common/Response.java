package com.dilu.common;

import java.io.Serializable;

/**
 * 界面返回数据封装类
 *
 * @author guonima
 * @create 2017-09-08 16:05
 */
public class Response implements Serializable {

    private int code;
    private String message;
    private Object data;

    public Response() {
    }

    public Response(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Response(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Response(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public Response(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Response{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
