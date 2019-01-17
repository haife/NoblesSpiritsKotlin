package com.haife.app.nobles.spirits.kotlin.mvp.http.entity.result;

/**
 * @author Eddie Android Developer
 * @company Q | 樽尚汇
 * @since 2019/1/17$
 * TODO:
 */
public class HRecommendBannerBean {
    private int int_id;
    private String string_title;
    private String string_pic_url;
    private int int_jump_type;
    private int int_prodect_id;
    private String string_jump_type_name;

    public int getInt_id() {
        return int_id;
    }

    public void setInt_id(int int_id) {
        this.int_id = int_id;
    }

    public String getString_title() {
        return string_title;
    }

    public void setString_title(String string_title) {
        this.string_title = string_title;
    }

    public String getString_pic_url() {
        return string_pic_url;
    }

    public void setString_pic_url(String string_pic_url) {
        this.string_pic_url = string_pic_url;
    }

    public int getInt_jump_type() {
        return int_jump_type;
    }

    public void setInt_jump_type(int int_jump_type) {
        this.int_jump_type = int_jump_type;
    }

    public int getInt_prodect_id() {
        return int_prodect_id;
    }

    public void setInt_prodect_id(int int_prodect_id) {
        this.int_prodect_id = int_prodect_id;
    }

    public String getString_jump_type_name() {
        return string_jump_type_name;
    }

    public void setString_jump_type_name(String string_jump_type_name) {
        this.string_jump_type_name = string_jump_type_name;
    }
}
