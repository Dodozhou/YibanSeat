package com.star.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.HashMap;

@Component
@JsonInclude(JsonInclude.Include.NON_NULL) //空值的序列化支持
public class Response<T> implements Serializable {
    int retCode; //返回码 0正常 1插入订单失败

    String msg;  //具体错误信息

    T result;
    private HashMap<String,Object> extend; //扩展字段

    private static final long serialVersionUID = 2633283546876721484L;

    public Response() {
    }

    public Response(int retCode, String msg) {
        this.retCode = retCode;
        this.msg = msg;
    }

    public Response(int retCode, String msg, T result) {
        this(retCode,msg);
        this.result = result;
    }

    public Response(int retCode, String msg, T result, HashMap<String,Object> extend) {
        this(retCode,msg,result);
        this.extend = extend;
    }

    public int getRetCode() {
        return retCode;
    }

    public void setRetCode(int retCode) {
        this.retCode = retCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public HashMap<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(HashMap<String, Object> extend) {
        this.extend = extend;
    }
}
