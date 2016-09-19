package com.ett.csz.huacheng.http;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

/**
 * web服务调用方法
 * Created by csz on 2016/9/19.
 */
public class BaseClient {
    private static AsyncHttpClient client = new AsyncHttpClient();

    private static String auditURL = "http://202.127.48.102/appapi/AppSearchServer.asmx/LabAssisService";
    private static String BASE_URL = "http://202.127.48.102/appapi/AppSearchServer.asmx/";

    public static AsyncHttpClient getIntance() {
        return client;
    }

    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void get(Context context, String url, RequestParams params,
                           AsyncHttpResponseHandler responseHandler) {
        client.get(context, url, params, responseHandler);
    }

    public static void get(String url, AsyncHttpResponseHandler responseHandler) {
        client.get(getAbsoluteUrl(url), responseHandler);
    }

    public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.post(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void post(Context context, String url, RequestParams params,
                            AsyncHttpResponseHandler responseHandler) {
        client.post(context, getAbsoluteUrl(url), params, responseHandler);
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        client.setTimeout(5 * 1000);
        client.setMaxConnections(10);
        return BASE_URL + relativeUrl;
    }

    public static void post2(RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.post(auditURL, params, responseHandler);
    }

    public static boolean isConnect(Context context) {
        // 获取手机所有连接管理对象（包括对wi-fi,net等连接的管理）
        try {
            ConnectivityManager connectivity = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivity != null) {
                // 获取网络连接管理的对象
                NetworkInfo info = connectivity.getActiveNetworkInfo();
                if (info != null && info.isConnected()) {
                    // 判断当前网络是否已经连接
                    if (info.getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            Toast.makeText(context, "默认Toast样式", Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}
