package com.haife.app.nobles.spirits.kotlin.mvp.http.entity.base;

import java.io.Serializable;

/**
 * @author Eddie Android Developer
 * @company Q | 樽尚汇
 * @since 2019/1/22
 * 请求体基类
 */
public class BaseRequest<T> implements Serializable {
    private Token token;
    private T param;

    public BaseRequest(T param) {
        this.token = new Token();
        this.param = param;
    }

}
