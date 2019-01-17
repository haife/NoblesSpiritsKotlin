package com.haife.app.nobles.spirits.kotlin.mvp.http.entity.base;


import com.haife.app.nobles.spirits.kotlin.mvp.http.service.Api;

import java.io.Serializable;

/**
 * @ author haife
 * @ email 773938795@gmail.com
 * @ since 2018/11/22
 * TODO：
 */
public class Data<T> extends BaseResponse<T> implements Serializable {

    private String code;
    private String msg;
    private T result;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    /**
     * 请求是否成功
     *
     * @return
     */
    public boolean isSuccess() {
        if (Integer.parseInt(code) == Api.RequestSuccess) {
            return true;
        } else {
            return false;
        }
    }
}
