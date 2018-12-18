package com.haife.app.nobles.spirits.kotlin.mvp.http.entity.base;


import com.haife.app.nobles.spirits.kotlin.BuildConfig;
import com.haife.app.nobles.spirits.kotlin.app.utlis.MD5;

public class Token {

    private TokenBean token;

    public Token() {
        TokenBean token = new TokenBean();
        this.token = token;
    }

    public static class TokenBean {
        String time = String.valueOf(System.currentTimeMillis());
        String uuid = "1";
        String sign = MD5.encryptMD5ToString(BuildConfig.App_CODE + time + uuid);
        String from = "android";
        String lang = "cn";
    }
}
