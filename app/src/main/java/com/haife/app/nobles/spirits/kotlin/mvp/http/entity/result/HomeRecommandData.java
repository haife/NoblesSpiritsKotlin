package com.haife.app.nobles.spirits.kotlin.mvp.http.entity.result;

import java.util.List;

/**
 * @ author haife
 * @ since 2018/12/18
 * TODO：
 */
public class HomeRecommandData {

    public static class ResultBean {

        private Object arr_index_banner_data;
        private ArrIndexLifeDataBean arr_index_life_data;
        private ArrIndexWeeklySpecialsDataBean arr_index_weekly_specials_data;
        private ArrGroupDataBean arr_group_data;
        private ArrMoreTypeOrUrlDataBean arr_more_type_or_url_data;
        private List<ArrCityDataBean> arr_city_data;
        private List<ArrTableDataBean> arr_table_data;

        public Object getArr_index_banner_data() {
            return arr_index_banner_data;
        }

        public void setArr_index_banner_data(Object arr_index_banner_data) {
            this.arr_index_banner_data = arr_index_banner_data;
        }

        public ArrIndexLifeDataBean getArr_index_life_data() {
            return arr_index_life_data;
        }

        public void setArr_index_life_data(ArrIndexLifeDataBean arr_index_life_data) {
            this.arr_index_life_data = arr_index_life_data;
        }

        public ArrIndexWeeklySpecialsDataBean getArr_index_weekly_specials_data() {
            return arr_index_weekly_specials_data;
        }

        public void setArr_index_weekly_specials_data(ArrIndexWeeklySpecialsDataBean arr_index_weekly_specials_data) {
            this.arr_index_weekly_specials_data = arr_index_weekly_specials_data;
        }

        public ArrGroupDataBean getArr_group_data() {
            return arr_group_data;
        }

        public void setArr_group_data(ArrGroupDataBean arr_group_data) {
            this.arr_group_data = arr_group_data;
        }

        public ArrMoreTypeOrUrlDataBean getArr_more_type_or_url_data() {
            return arr_more_type_or_url_data;
        }

        public void setArr_more_type_or_url_data(ArrMoreTypeOrUrlDataBean arr_more_type_or_url_data) {
            this.arr_more_type_or_url_data = arr_more_type_or_url_data;
        }

        public List<ArrCityDataBean> getArr_city_data() {
            return arr_city_data;
        }

        public void setArr_city_data(List<ArrCityDataBean> arr_city_data) {
            this.arr_city_data = arr_city_data;
        }

        public List<ArrTableDataBean> getArr_table_data() {
            return arr_table_data;
        }

        public void setArr_table_data(List<ArrTableDataBean> arr_table_data) {
            this.arr_table_data = arr_table_data;
        }

        public static class ArrIndexLifeDataBean {


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
            }

            public static class ArrDataBean {


                private int int_id;
                private String string_pic_url;
                private String string_title;
                private String string_h5_url;

                public int getInt_id() {
                    return int_id;
                }

                public void setInt_id(int int_id) {
                    this.int_id = int_id;
                }

                public String getString_pic_url() {
                    return string_pic_url;
                }

                public void setString_pic_url(String string_pic_url) {
                    this.string_pic_url = string_pic_url;
                }

                public String getString_title() {
                    return string_title;
                }

                public void setString_title(String string_title) {
                    this.string_title = string_title;
                }

                public String getString_h5_url() {
                    return string_h5_url;
                }

                public void setString_h5_url(String string_h5_url) {
                    this.string_h5_url = string_h5_url;
                }
            }
        }

        public static class ArrIndexWeeklySpecialsDataBean {


            private ArrTitleDataBeanX arr_title_data;
            private List<ArrDataBeanX> arr_data;

            public ArrTitleDataBeanX getArr_title_data() {
                return arr_title_data;
            }

            public void setArr_title_data(ArrTitleDataBeanX arr_title_data) {
                this.arr_title_data = arr_title_data;
            }

            public List<ArrDataBeanX> getArr_data() {
                return arr_data;
            }

            public void setArr_data(List<ArrDataBeanX> arr_data) {
                this.arr_data = arr_data;
            }

            public static class ArrTitleDataBeanX {

                private String string_positive_title;
                private String sting_negative_title;

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
            }

            public static class ArrDataBeanX {

                private int int_id;
                private int int_year;
                private int float_price;
                private int float_activity_price;
                private String string_title;
                private String string_title_en;
                private String string_cover_url;
                private String string_tips_specials;

                public int getInt_id() {
                    return int_id;
                }

                public void setInt_id(int int_id) {
                    this.int_id = int_id;
                }

                public int getInt_year() {
                    return int_year;
                }

                public void setInt_year(int int_year) {
                    this.int_year = int_year;
                }

                public int getFloat_price() {
                    return float_price;
                }

                public void setFloat_price(int float_price) {
                    this.float_price = float_price;
                }

                public int getFloat_activity_price() {
                    return float_activity_price;
                }

                public void setFloat_activity_price(int float_activity_price) {
                    this.float_activity_price = float_activity_price;
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

                public String getString_cover_url() {
                    return string_cover_url;
                }

                public void setString_cover_url(String string_cover_url) {
                    this.string_cover_url = string_cover_url;
                }

                public String getString_tips_specials() {
                    return string_tips_specials;
                }

                public void setString_tips_specials(String string_tips_specials) {
                    this.string_tips_specials = string_tips_specials;
                }
            }
        }

        public static class ArrGroupDataBean {

            private ArrTitleDataBeanXX arr_title_data;
            private List<?> arr_data;

            public ArrTitleDataBeanXX getArr_title_data() {
                return arr_title_data;
            }

            public void setArr_title_data(ArrTitleDataBeanXX arr_title_data) {
                this.arr_title_data = arr_title_data;
            }

            public List<?> getArr_data() {
                return arr_data;
            }

            public void setArr_data(List<?> arr_data) {
                this.arr_data = arr_data;
            }

            public static class ArrTitleDataBeanXX {
                /**
                 * string_positive_title : 团购活动
                 * sting_negative_title : 超值精选 参团优惠
                 */

                private String string_positive_title;
                private String sting_negative_title;

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
            }
        }

        public static class ArrMoreTypeOrUrlDataBean {
            /**
             * int_arr_index_mingzhuang_more_data : 31
             * int_arr_index_weekly_specials_more_data : 41
             * string_life_list_url : /index.php?s=/home/index/news_list&home=1
             */

            private int int_arr_index_mingzhuang_more_data;
            private int int_arr_index_weekly_specials_more_data;
            private String string_life_list_url;

            public int getInt_arr_index_mingzhuang_more_data() {
                return int_arr_index_mingzhuang_more_data;
            }

            public void setInt_arr_index_mingzhuang_more_data(int int_arr_index_mingzhuang_more_data) {
                this.int_arr_index_mingzhuang_more_data = int_arr_index_mingzhuang_more_data;
            }

            public int getInt_arr_index_weekly_specials_more_data() {
                return int_arr_index_weekly_specials_more_data;
            }

            public void setInt_arr_index_weekly_specials_more_data(int int_arr_index_weekly_specials_more_data) {
                this.int_arr_index_weekly_specials_more_data = int_arr_index_weekly_specials_more_data;
            }

            public String getString_life_list_url() {
                return string_life_list_url;
            }

            public void setString_life_list_url(String string_life_list_url) {
                this.string_life_list_url = string_life_list_url;
            }
        }

        public static class ArrCityDataBean {
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

        public static class ArrTableDataBean {
            /**
             * string_title_cn : 推 荐
             * string_title_en : HOME
             * bool_is_new : true
             * string_api_url : /index/app_index
             */

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
}
