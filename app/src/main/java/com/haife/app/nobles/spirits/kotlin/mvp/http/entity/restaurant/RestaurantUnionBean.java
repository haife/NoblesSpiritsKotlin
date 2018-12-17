package com.haife.app.nobles.spirits.kotlin.mvp.http.entity.restaurant;

import java.util.List;

public class RestaurantUnionBean {

    private ResultBean result;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        private List<ArrCityBean> arr_city;
        private List<ArrShopTypesBean> arr_shop_types;
        private List<ArrBrandDataBean> arr_brand_data;
        private List<ArrAverageSpendBean> arr_average_spend;
        private List<ArrSearchShopDataBean> arr_search_shop_data;

        public List<ArrCityBean> getArr_city() {
            return arr_city;
        }

        public void setArr_city(List<ArrCityBean> arr_city) {
            this.arr_city = arr_city;
        }

        public List<ArrShopTypesBean> getArr_shop_types() {
            return arr_shop_types;
        }

        public void setArr_shop_types(List<ArrShopTypesBean> arr_shop_types) {
            this.arr_shop_types = arr_shop_types;
        }

        public List<ArrBrandDataBean> getArr_brand_data() {
            return arr_brand_data;
        }

        public void setArr_brand_data(List<ArrBrandDataBean> arr_brand_data) {
            this.arr_brand_data = arr_brand_data;
        }

        public List<ArrAverageSpendBean> getArr_average_spend() {
            return arr_average_spend;
        }

        public void setArr_average_spend(List<ArrAverageSpendBean> arr_average_spend) {
            this.arr_average_spend = arr_average_spend;
        }

        public List<ArrSearchShopDataBean> getArr_search_shop_data() {
            return arr_search_shop_data;
        }

        public void setArr_search_shop_data(List<ArrSearchShopDataBean> arr_search_shop_data) {
            this.arr_search_shop_data = arr_search_shop_data;
        }

        public static class ArrCityBean {
            /**
             * int_id : 1
             * string_name : 上海市
             * string_name_short : 上海
             * string_name_en : Shanghai
             * string_name_en_short : SH
             */

            private int int_id;
            private String string_name;
            private String string_name_short;
            private String string_name_en;
            private String string_name_en_short;

            public int getInt_id() {
                return int_id;
            }

            public void setInt_id(int int_id) {
                this.int_id = int_id;
            }

            public String getString_name() {
                return string_name;
            }

            public void setString_name(String string_name) {
                this.string_name = string_name;
            }

            public String getString_name_short() {
                return string_name_short;
            }

            public void setString_name_short(String string_name_short) {
                this.string_name_short = string_name_short;
            }

            public String getString_name_en() {
                return string_name_en;
            }

            public void setString_name_en(String string_name_en) {
                this.string_name_en = string_name_en;
            }

            public String getString_name_en_short() {
                return string_name_en_short;
            }

            public void setString_name_en_short(String string_name_en_short) {
                this.string_name_en_short = string_name_en_short;
            }
        }

        public static class ArrShopTypesBean {
            /**
             * int_id : 0
             * string_title_cn : 全部
             * string_title_en : All
             */

            private int int_id;
            private String string_title_cn;
            private String string_title_en;

            public int getInt_id() {
                return int_id;
            }

            public void setInt_id(int int_id) {
                this.int_id = int_id;
            }

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
        }

        public static class ArrBrandDataBean {
            /**
             * int_brand_id : 0
             * string_name : 全部
             * string_name_en : All
             */

            private int int_brand_id;
            private String string_name;
            private String string_name_en;

            public int getInt_brand_id() {
                return int_brand_id;
            }

            public void setInt_brand_id(int int_brand_id) {
                this.int_brand_id = int_brand_id;
            }

            public String getString_name() {
                return string_name;
            }

            public void setString_name(String string_name) {
                this.string_name = string_name;
            }

            public String getString_name_en() {
                return string_name_en;
            }

            public void setString_name_en(String string_name_en) {
                this.string_name_en = string_name_en;
            }
        }

        public static class ArrAverageSpendBean {
            /**
             * int_spend_id : 0
             * string_name : 全部
             * string_name_en : All
             */

            private int int_spend_id;
            private String string_name;
            private String string_name_en;

            public int getInt_spend_id() {
                return int_spend_id;
            }

            public void setInt_spend_id(int int_spend_id) {
                this.int_spend_id = int_spend_id;
            }

            public String getString_name() {
                return string_name;
            }

            public void setString_name(String string_name) {
                this.string_name = string_name;
            }

            public String getString_name_en() {
                return string_name_en;
            }

            public void setString_name_en(String string_name_en) {
                this.string_name_en = string_name_en;
            }
        }

        public static class ArrSearchShopDataBean {
            /**
             * int_sid : 121
             * int_shop_id : 45
             * string_pic_logo : /Uploads/2018-08-24/5b7f6f2b1d637.png
             * string_mt_logo : /./Application/Home/View/Public/img/default/default.gif
             * string_title : 1918 翡丽滨江
             * string_title_en : PHILIPPE MANSION 1918
             * string_city : 上海 浦东
             * string_city_en : Shanghai Pudong
             * bool_is_recommend : true
             * bool_is_new : true
             * float_money : 889
             * string_slogn : 商务宴请的最佳选择
             * string_slogn_en :
             * string_booking_status : true
             * arr_category : [{"string_title":"中餐","string_title_en":"Chinese Food"}]
             */

            private int int_sid;
            private int int_shop_id;
            private String string_pic_logo;
            private String string_mt_logo;
            private String string_title;
            private String string_title_en;
            private String string_city;
            private String string_city_en;
            private boolean bool_is_recommend;
            private boolean bool_is_new;
            private int float_money;
            private String string_slogn;
            private String string_slogn_en;
            private boolean string_booking_status;
            private List<ArrCategoryBean> arr_category;

            public int getInt_sid() {
                return int_sid;
            }

            public void setInt_sid(int int_sid) {
                this.int_sid = int_sid;
            }

            public int getInt_shop_id() {
                return int_shop_id;
            }

            public void setInt_shop_id(int int_shop_id) {
                this.int_shop_id = int_shop_id;
            }

            public String getString_pic_logo() {
                return string_pic_logo;
            }

            public void setString_pic_logo(String string_pic_logo) {
                this.string_pic_logo = string_pic_logo;
            }

            public String getString_mt_logo() {
                return string_mt_logo;
            }

            public void setString_mt_logo(String string_mt_logo) {
                this.string_mt_logo = string_mt_logo;
            }

            public String getString_title() {
                return string_title;
            }

            public void setString_title(String string_title) {
                this.string_title = string_title;
            }

            public String getString_title_en() {
                return string_title_en;
            }

            public void setString_title_en(String string_title_en) {
                this.string_title_en = string_title_en;
            }

            public String getString_city() {
                return string_city;
            }

            public void setString_city(String string_city) {
                this.string_city = string_city;
            }

            public String getString_city_en() {
                return string_city_en;
            }

            public void setString_city_en(String string_city_en) {
                this.string_city_en = string_city_en;
            }

            public boolean isBool_is_recommend() {
                return bool_is_recommend;
            }

            public void setBool_is_recommend(boolean bool_is_recommend) {
                this.bool_is_recommend = bool_is_recommend;
            }

            public boolean isBool_is_new() {
                return bool_is_new;
            }

            public void setBool_is_new(boolean bool_is_new) {
                this.bool_is_new = bool_is_new;
            }

            public int getFloat_money() {
                return float_money;
            }

            public void setFloat_money(int float_money) {
                this.float_money = float_money;
            }

            public String getString_slogn() {
                return string_slogn;
            }

            public void setString_slogn(String string_slogn) {
                this.string_slogn = string_slogn;
            }

            public String getString_slogn_en() {
                return string_slogn_en;
            }

            public void setString_slogn_en(String string_slogn_en) {
                this.string_slogn_en = string_slogn_en;
            }

            public boolean isString_booking_status() {
                return string_booking_status;
            }

            public void setString_booking_status(boolean string_booking_status) {
                this.string_booking_status = string_booking_status;
            }

            public List<ArrCategoryBean> getArr_category() {
                return arr_category;
            }

            public void setArr_category(List<ArrCategoryBean> arr_category) {
                this.arr_category = arr_category;
            }

            public static class ArrCategoryBean {
                /**
                 * string_title : 中餐
                 * string_title_en : Chinese Food
                 */

                private String string_title;
                private String string_title_en;

                public String getString_title() {
                    return string_title;
                }

                public void setString_title(String string_title) {
                    this.string_title = string_title;
                }

                public String getString_title_en() {
                    return string_title_en;
                }

                public void setString_title_en(String string_title_en) {
                    this.string_title_en = string_title_en;
                }
            }
        }
    }
}
