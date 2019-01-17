package com.haife.app.nobles.spirits.kotlin.mvp.http.entity.result;

import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.base.Data;

import java.util.List;

/**
 * @author Eddie Android Developer
 * @company Q | 樽尚汇
 * @since 2019/1/15
 * TODO: 首页推荐数据
 */
public class HomeRecommendData extends Data<HomeRecommendData> {
    private List<HRecommendBannerBean> arr_index_banner_data;
    private List<ArrModuleDataBean> arr_module_data;
    private List<ArrTableDataBean> arr_table_data;

    public List<HRecommendBannerBean> getArr_index_banner_data() {
        return arr_index_banner_data;
    }

    public void setArr_index_banner_data(List<HRecommendBannerBean> arr_index_banner_data) {
        this.arr_index_banner_data = arr_index_banner_data;
    }

    public List<ArrModuleDataBean> getArr_module_data() {
        return arr_module_data;
    }

    public void setArr_module_data(List<ArrModuleDataBean> arr_module_data) {
        this.arr_module_data = arr_module_data;
    }

    public List<ArrTableDataBean> getArr_table_data() {
        return arr_table_data;
    }

    public void setArr_table_data(List<ArrTableDataBean> arr_table_data) {
        this.arr_table_data = arr_table_data;
    }


    public static class ArrModuleDataBean {

        private ArrTitleDataBean arr_title_data;
        private List<ArrDataBean> arr_data;

        public ArrTitleDataBean getArr_title_data() {
            return arr_title_data;
        }

        public void setArr_title_data(ArrTitleDataBean arr_title_data) {
            this.arr_title_data = arr_title_data;
        }

        public List<ArrDataBean> getArr_data() {
            return arr_data;
        }

        public void setArr_data(List<ArrDataBean> arr_data) {
            this.arr_data = arr_data;
        }

        public static class ArrTitleDataBean {


            private String string_positive_title;
            private String sting_negative_title;
            private String sting_module_name;

            public String getString_positive_title() {
                return string_positive_title;
            }

            public void setString_positive_title(String string_positive_title) {
                this.string_positive_title = string_positive_title;
            }

            public String getSting_negative_title() {
                return sting_negative_title;
            }

            public void setSting_negative_title(String sting_negative_title) {
                this.sting_negative_title = sting_negative_title;
            }

            public String getSting_module_name() {
                return sting_module_name;
            }

            public void setSting_module_name(String sting_module_name) {
                this.sting_module_name = sting_module_name;
            }
        }

        public static class ArrDataBean {
            private int int_id;
            private int int_surplus_time;
            private int int_origin_price;
            private int int_group_price;
            private int int_surplus;
            private int float_price;
            private int float_origin_price;
            private int int_status;
            private int int_goods_id;
            private int float_spend;
            private String string_pic_url;
            private String string_title;
            private String string_btn_text;
            private String string_brief_index;
            private String sting_pic_url;
            private String string_title_en;
            private String string_slogn;
            private String string_cover_url;


            public int getInt_id() {
                return int_id;
            }

            public int getInt_surplus_time() {
                return int_surplus_time;
            }

            public int getInt_origin_price() {
                return int_origin_price;
            }

            public int getInt_group_price() {
                return int_group_price;
            }

            public int getInt_surplus() {
                return int_surplus;
            }

            public int getFloat_price() {
                return float_price;
            }

            public int getFloat_origin_price() {
                return float_origin_price;
            }

            public int getInt_status() {
                return int_status;
            }

            public int getInt_goods_id() {
                return int_goods_id;
            }

            public int getFloat_spend() {
                return float_spend;
            }

            public String getString_pic_url() {
                return string_pic_url;
            }

            public String getString_title() {
                return string_title;
            }

            public String getString_btn_text() {
                return string_btn_text;
            }

            public String getString_brief_index() {
                return string_brief_index;
            }

            public String getSting_pic_url() {
                return sting_pic_url;
            }

            public String getString_title_en() {
                return string_title_en;
            }

            public String getString_slogn() {
                return string_slogn;
            }

            public String getString_cover_url() {
                return string_cover_url;
            }
        }
    }

    public static class ArrTableDataBean {

        private String string_title_cn;
        private String string_title_en;
        private boolean bool_is_new;
        private String string_api_url;

        public String getString_title_cn() {
            return string_title_cn;
        }

        public void setString_title_cn(String string_title_cn) {
            this.string_title_cn = string_title_cn;
        }

        public String getString_title_en() {
            return string_title_en;
        }

        public void setString_title_en(String string_title_en) {
            this.string_title_en = string_title_en;
        }

        public boolean isBool_is_new() {
            return bool_is_new;
        }

        public void setBool_is_new(boolean bool_is_new) {
            this.bool_is_new = bool_is_new;
        }

        public String getString_api_url() {
            return string_api_url;
        }

        public void setString_api_url(String string_api_url) {
            this.string_api_url = string_api_url;
        }
    }
}
