package com.haife.app.nobles.spirits.kotlin.mvp.http.entity.base;

/**
 * @author Eddie Android Developer
 * @company Q | 樽尚汇
 * @since 2019/1/22
 * 请求体基类
 */
public class BaseRequest<T> {
    private Token.TokenBean token = new Token.TokenBean();
    private T param;

    public T getParam() {
        return param;
    }

    public void setParam(T param) {
        this.param = param;
    }


}
