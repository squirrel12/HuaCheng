package com.ett.csz.huacheng.entry;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 处理错误消息
 * Created by csz on 2016/10/8.
 */

public class ErrorEntity extends BaseEntity {
    private static final long serialVersionUID = -7443579027796502368L;

    private Integer errCode;
    private String msg;

    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ErrorEntity(Integer errCode, String msg) {
        super();
        this.errCode = errCode;
        this.msg = msg;
    }

    public static void parseBySimple(String json) {
        try {
            JSONObject dataJSON = new JSONObject(json);
            if (dataJSON.has("ErrCode"))
                getErrorEntity().setErrCode(dataJSON.getInt("ErrCode"));
            if (dataJSON.has("Msg"))
                getErrorEntity().setMsg(dataJSON.getString("Msg"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private ErrorEntity() {
    }

    private static ErrorEntity entity;

    public static ErrorEntity getErrorEntity() {
        if (entity == null)
            entity = new ErrorEntity();
        return entity;
    }

    public static void reset() {
        entity = null;
    }
}
