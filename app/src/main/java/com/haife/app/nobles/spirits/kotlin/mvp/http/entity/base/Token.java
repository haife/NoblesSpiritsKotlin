package com.haife.app.nobles.spirits.kotlin.mvp.http.entity.base;


import com.haife.app.nobles.spirits.kotlin.app.utlis.MD5;

public class Token {


    /**
     * token : {"from":"android","lang":"cn","sign":"6DB2D52245E2BC9F854FF32D430FC0E5","time":"1538103823213","uuid":"1"}
     */

    private TokenBean token;

    public Token() {
        TokenBean token = new TokenBean();
        this.token = token;
    }

    public TokenBean getToken() {
        return token;
    }

    public void setToken(TokenBean token) {
        this.token = token;
    }

    public static class TokenBean {
        /**
         * from : android
         * lang : cn
         * sign : 6DB2D52245E2BC9F854FF32D430FC0E5
         * time : 1538103823213
         * uuid : 1
         */

        String time = String.valueOf(System.currentTimeMillis());
        String uuid = "1";
        String sign = MD5.encryptMD5ToString("098F6BCD4621D373CADE4E832627B4F6" + time + uuid);
        String from = "android";
        String lang = "cn";


        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getLang() {
            return lang;
        }

        public void setLang(String lang) {
            this.lang = lang;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }
    }
}
