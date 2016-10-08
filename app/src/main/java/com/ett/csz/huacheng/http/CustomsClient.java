package com.ett.csz.huacheng.http;

/**
 * web方法
 * Created by csz on 2016/9/19.
 */
public class CustomsClient {
    public final static String message_error = "服务器连接超时";

    public interface ClientCallback {
        abstract void onSuccess(Object data);
        abstract void onFailure(String message);
        abstract void onError(Exception e);
    }
    public static void login(){

    }
}
