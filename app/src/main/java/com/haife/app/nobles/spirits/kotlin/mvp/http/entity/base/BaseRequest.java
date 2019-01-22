package com.haife.app.nobles.spirits.kotlin.mvp.http.entity.base;

import com.haife.app.nobles.spirits.kotlin.BuildConfig;
import com.haife.app.nobles.spirits.kotlin.mvp.ui.utlis.MD5;

/**
 * @author Eddie Android Developer
 * @company Q | 樽尚汇
 * @since 2019/1/22
 * 请求体基类
 */
public class BaseRequest<T> {
    private TokenBean token = new TokenBean();
    private T param;


    public T getParam() {
        return param;
    }

    public void setParam(T param) {
        this.param = param;
    }

    public static class TokenBean {
        String time = String.valueOf(System.currentTimeMillis());
        String uuid = "1";
        String sign = MD5.encryptMD5ToString(BuildConfig.App_CODE + time + uuid);
        String from = "android";
        String lang = "cn";


    }
}
