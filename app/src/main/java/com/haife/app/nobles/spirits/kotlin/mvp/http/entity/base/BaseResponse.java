package com.haife.app.nobles.spirits.kotlin.mvp.http.entity.base;


import java.io.Serializable;


public class BaseResponse<T> implements Serializable {

    private Data<T> data;

    public Data<T> getData() {
        return data;
    }

    public void setData(Data<T> data) {
        this.data = data;
    }
}
