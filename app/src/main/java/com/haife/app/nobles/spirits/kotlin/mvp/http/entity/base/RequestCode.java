package com.haife.app.nobles.spirits.kotlin.mvp.http.entity.base;

/**
 * @author Eddie Android Developer
 * @company Q | 樽尚汇
 * @since 2019/1/22$
 * TODO: code 登陆成功后返回的code,退出登录需要清空
 */
public class RequestCode extends Token {
    public String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
