package com.haife.app.nobles.spirits.kotlin.mvp.http.entity.base;


import com.haife.app.nobles.spirits.kotlin.mvp.http.api.Api;

import java.io.Serializable;


public class BaseResponse<T> implements Serializable {
    private T data;
    private int status;
    private String msg;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 请求是否成功
     *
     * @return
     */
    public boolean isSuccess() {
        if (status == Api.RequestSuccess) {
            return true;
        } else {
            return false;
        }
    }
}
