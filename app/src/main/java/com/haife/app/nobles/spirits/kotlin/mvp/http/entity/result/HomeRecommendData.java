package com.haife.app.nobles.spirits.kotlin.mvp.http.entity.result;

import java.util.List;

/**
 * @ author haife
 * @ since 2018/12/18
 * TODO：首页推荐数据
 */
public class HomeRecommendData {
    private List<ArrIndexBannerDataBean> arr_index_banner_data;
    private ArrIndexLifeDataBean arr_index_life_data;
    private ArrIndexWeeklySpecialsDataBean arr_index_weekly_specials_data;
    private ArrGroupDataBean arr_group_data;
    private ArrMoreTypeOrUrlDataBean arr_more_type_or_url_data;
    private List<ArrCityDataBean> arr_city_data;
    private List<ArrTableDataBean> arr_table_data;
    private ArrIndexRecommendShopBean arr_index_recommend_shop;
    private ArrIndexNewShopBean arr_index_new_shop;

    public List<ArrIndexBannerDataBean> getArr_index_banner_data() {
        return arr_index_banner_data;
    }

    public void setArr_index_banner_data(List<ArrIndexBannerDataBean> arr_index_banner_data) {
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

    public ArrIndexRecommendShopBean getArr_index_recommend_shop() {
        return arr_index_recommend_shop;
    }

    public void setArr_index_recommend_shop(ArrIndexRecommendShopBean arr_index_recommend_shop) {
        this.arr_index_recommend_shop = arr_index_recommend_shop;
    }

    public ArrIndexNewShopBean getArr_index_new_shop() {
        return arr_index_new_shop;
    }

    public void setArr_index_new_shop(ArrIndexNewShopBean arr_index_new_shop) {
        this.arr_index_new_shop = arr_index_new_shop;
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

    public static class ArrIndexBannerDataBean {

        private int int_id;
        private int int_jump_type;
        private String string_title;
        private int int_prodect_id;
        private String string_pic_url;
        private String string_jump_type_name;

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
    }

    public static class ArrIndexNewShopBean {


        private NewEnterRestaurantTitle arr_title_data;
        private List<NewEnterRestaurantBean> arr_data;

        public NewEnterRestaurantTitle getArr_title_data() {
            return arr_title_data;
        }

        public void setArr_title_data(NewEnterRestaurantTitle arr_title_data) {
            this.arr_title_data = arr_title_data;
        }

        public List<NewEnterRestaurantBean> getArr_data() {
            return arr_data;
        }

        public void setArr_data(List<NewEnterRestaurantBean> arr_data) {
            this.arr_data = arr_data;
        }

        public static class NewEnterRestaurantTitle {

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

        public static class NewEnterRestaurantBean {

            private int int_id;
            private String string_title;
            private String string_title_en;
            private String string_slogn;
            private String string_slogn_en;
            private String string_pic_url;
            private String string_city;
            private String string_city_en;
            private int float_spend;

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

            public String getString_title_en() {
                return string_title_en;
            }

            public void setString_title_en(String string_title_en) {
                this.string_title_en = string_title_en;
            }

            public String getString_pic_url() {
                return string_pic_url;
            }

            public void setString_pic_url(String string_pic_url) {
                this.string_pic_url = string_pic_url;
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

            public int getFloat_spend() {
                return float_spend;
            }

            public void setFloat_spend(int float_spend) {
                this.float_spend = float_spend;
            }
        }
    }

    public static class ArrIndexRecommendShopBean {

        private RecommendShopTitle arr_title_data;
        private List<ArrRecommendShopBean> arr_data;

        public RecommendShopTitle getArr_title_data() {
            return arr_title_data;
        }

        public void setArr_title_data(RecommendShopTitle arr_title_data) {
            this.arr_title_data = arr_title_data;
        }

        public List<ArrRecommendShopBean> getArr_data() {
            return arr_data;
        }

        public void setArr_data(List<ArrRecommendShopBean> arr_data) {
            this.arr_data = arr_data;
        }

        public static class RecommendShopTitle {


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

        public static class ArrRecommendShopBean {

            private int int_id;
            private String string_title;
            private String string_brief_index_en;
            private String string_brief_index;
            private String string_tag_index;
            private String sting_pic_url;

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

            public String getString_brief_index_en() {
                return string_brief_index_en;
            }

            public void setString_brief_index_en(String string_brief_index_en) {
                this.string_brief_index_en = string_brief_index_en;
            }

            public String getString_brief_index() {
                return string_brief_index;
            }

            public void setString_brief_index(String string_brief_index) {
                this.string_brief_index = string_brief_index;
            }

            public String getString_tag_index() {
                return string_tag_index;
            }

            public void setString_tag_index(String string_tag_index) {
                this.string_tag_index = string_tag_index;
            }

            public String getSting_pic_url() {
                return sting_pic_url;
            }

            public void setSting_pic_url(String sting_pic_url) {
                this.sting_pic_url = sting_pic_url;
            }
        }
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


        private WeeklySpecialsTitle arr_title_data;
        private List<WeeklySpecialsBean> arr_data;

        public WeeklySpecialsTitle getArr_title_data() {
            return arr_title_data;
        }

        public void setArr_title_data(WeeklySpecialsTitle arr_title_data) {
            this.arr_title_data = arr_title_data;
        }

        public List<WeeklySpecialsBean> getArr_data() {
            return arr_data;
        }

        public void setArr_data(List<WeeklySpecialsBean> arr_data) {
            this.arr_data = arr_data;
        }

        public static class WeeklySpecialsTitle {


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

        public static class WeeklySpecialsBean {


            private int int_id;
            private int int_year;
            private int float_price;
            private int float_activity_price;
            private String string_title;
            private String string_title_en;
            private String string_cover_url;
            private String string_tips_specials;

            public int getFloat_activity_price() {
                return float_activity_price;
            }

            public void setFloat_activity_price(int float_activity_price) {
                this.float_activity_price = float_activity_price;
            }

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


        private GroupBuyTitle arr_title_data;
        private List<ArrGroupBuyTitleBean> arr_data;

        public GroupBuyTitle getArr_title_data() {
            return arr_title_data;
        }

        public void setArr_title_data(GroupBuyTitle arr_title_data) {
            this.arr_title_data = arr_title_data;
        }

        public List<ArrGroupBuyTitleBean> getArr_data() {
            return arr_data;
        }

        public void setArr_data(List<ArrGroupBuyTitleBean> arr_data) {
            this.arr_data = arr_data;
        }

        public static class GroupBuyTitle {


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

        public static class ArrGroupBuyTitleBean {

            private int int_id;
            private String string_title;
            private String string_url;
            private String string_create_time;
            private int int_group;
            private String string_total_people;
            private int int_bought;
            private int int_surplus;
            private int int_end_time;
            private int int_surplus_time;
            private int int_group_price;
            private int int_origin_price;
            private int int_status;
            private String string_status_name;
            private String string_pic_url;

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

            public String getString_url() {
                return string_url;
            }

            public void setString_url(String string_url) {
                this.string_url = string_url;
            }

            public String getString_create_time() {
                return string_create_time;
            }

            public void setString_create_time(String string_create_time) {
                this.string_create_time = string_create_time;
            }

            public int getInt_group() {
                return int_group;
            }

            public void setInt_group(int int_group) {
                this.int_group = int_group;
            }

            public String getString_total_people() {
                return string_total_people;
            }

            public void setString_total_people(String string_total_people) {
                this.string_total_people = string_total_people;
            }

            public int getInt_bought() {
                return int_bought;
            }

            public void setInt_bought(int int_bought) {
                this.int_bought = int_bought;
            }

            public int getInt_surplus() {
                return int_surplus;
            }

            public void setInt_surplus(int int_surplus) {
                this.int_surplus = int_surplus;
            }

            public int getInt_end_time() {
                return int_end_time;
            }

            public void setInt_end_time(int int_end_time) {
                this.int_end_time = int_end_time;
            }

            public int getInt_surplus_time() {
                return int_surplus_time;
            }

            public void setInt_surplus_time(int int_surplus_time) {
                this.int_surplus_time = int_surplus_time;
            }

            public int getInt_group_price() {
                return int_group_price;
            }

            public void setInt_group_price(int int_group_price) {
                this.int_group_price = int_group_price;
            }

            public int getInt_origin_price() {
                return int_origin_price;
            }

            public void setInt_origin_price(int int_origin_price) {
                this.int_origin_price = int_origin_price;
            }

            public int getInt_status() {
                return int_status;
            }

            public void setInt_status(int int_status) {
                this.int_status = int_status;
            }

            public String getString_status_name() {
                return string_status_name;
            }

            public void setString_status_name(String string_status_name) {
                this.string_status_name = string_status_name;
            }

            public String getString_pic_url() {
                return string_pic_url;
            }

            public void setString_pic_url(String string_pic_url) {
                this.string_pic_url = string_pic_url;
            }
        }
    }

    public static class ArrMoreTypeOrUrlDataBean {

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
