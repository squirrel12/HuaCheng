package com.ett.csz.huacheng.http;


import com.ett.csz.huacheng.entry.ErrorEntity;
import com.ett.csz.huacheng.entry.JobEntry;
import com.ett.csz.huacheng.entry.RepairEntity;
import com.ett.csz.huacheng.util.PageInfo;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;


import java.util.List;

import cz.msebera.android.httpclient.Header;

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
    public static void GetAllList(String conditionJSON,final PageInfo pageInfo, final ClientCallback callback){
        RequestParams params = new RequestParams();
        params.add("jsonParams", conditionJSON);
        params.add("pageSize", String.valueOf(pageInfo.getShowCount()));
        params.add("pageNo", String.valueOf(pageInfo.getCurrentPage()));
        BaseClient.post("GetAllList", params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String json = new String(responseBody);
                List<RepairEntity> entities = RepairEntity.parseBySimple(json, pageInfo);
                if (entities == null) {
                    ErrorEntity.parseBySimple(json);
                }
                callback.onSuccess(entities);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                callback.onFailure(message_error);
            }
        });
    }

}
