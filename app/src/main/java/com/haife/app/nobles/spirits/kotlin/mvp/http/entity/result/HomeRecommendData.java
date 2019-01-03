package com.haife.app.nobles.spirits.kotlin.mvp.http.entity.result;

import java.util.List;

/**
 * @ author haife
 * @ since 2018/12/18
 * TODO：
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
        /**
         * int_id : 42
         * string_title : 积分商城首页banner
         * string_pic_url : /Uploads/2018-06-22/5b2ca614732b6.png
         */

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
        /**
         * arr_title_data : {"string_positive_title":"新入驻餐厅","sting_negative_title":"赶紧来打卡"}
         * arr_data : [{"int_id":131,"string_title":"大公鸡小酒馆 Le Coq Wine & Meat Shop（威海路)","string_title_en":" Le Coq Wine & Meat Shop（Weihai Road)","string_slogn":"朋友轻松聚餐的最佳场所","string_slogn_en":"","string_city":"上海 静安","string_city_en":"Shanghai Jingan","float_spend":475},{"int_id":130,"string_title":"大公鸡小酒馆 Le Coq Wine &Bistro(黄陂南路)","string_title_en":"Le Coq Wine &Bistro （South Huangpi Road）","string_slogn":"朋友轻松聚餐的最佳场所","string_slogn_en":"","string_city":"上海 黄浦","string_city_en":"Shanghai Huangpu","float_spend":475},{"int_id":132,"string_title":"大公鸡小酒馆 Le Coq wine &Oyster Bar（黄金城道）","string_title_en":"Le Coq wine &Oyster Bar（Golden Hill Road）","string_slogn":"朋友轻松聚餐的最佳场所","string_slogn_en":"","string_city":"上海 长宁","string_city_en":"Shanghai Changning","float_spend":417},{"int_id":189,"string_title":"双立人餐厅","string_title_en":"The Twins","string_slogn":"全球首家落户上海","string_slogn_en":"","string_city":"","string_city_en":"","float_spend":396},{"int_id":174,"string_title":"堡爵仕PRIME概念店(港汇店)","string_title_en":"THE BUTCHERS CLUB PRIME (Ground Gateway)","string_slogn":"干式熟成牛肉专家","string_slogn_en":"Dry-aged Beef Expert","string_city":"上海 徐汇","string_city_en":"Shanghai","float_spend":189},{"int_id":205,"string_title":"囍蔻港式点心火锅","string_title_en":"囍蔻港式点心火锅","string_slogn":"港式火锅里的爱马仕","string_slogn_en":"","string_city":"","string_city_en":"","float_spend":439}]
         */

        private ArrTitleDataBeanXXXX arr_title_data;
        private List<ArrDataBeanXXXX> arr_data;

        public ArrTitleDataBeanXXXX getArr_title_data() {
            return arr_title_data;
        }

        public void setArr_title_data(ArrTitleDataBeanXXXX arr_title_data) {
            this.arr_title_data = arr_title_data;
        }

        public List<ArrDataBeanXXXX> getArr_data() {
            return arr_data;
        }

        public void setArr_data(List<ArrDataBeanXXXX> arr_data) {
            this.arr_data = arr_data;
        }

        public static class ArrTitleDataBeanXXXX {
            /**
             * string_positive_title : 新入驻餐厅
             * sting_negative_title : 赶紧来打卡
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

        public static class ArrDataBeanXXXX {
            /**
             * int_id : 131
             * string_title : 大公鸡小酒馆 Le Coq Wine & Meat Shop（威海路)
             * string_title_en :  Le Coq Wine & Meat Shop（Weihai Road)
             * string_slogn : 朋友轻松聚餐的最佳场所
             * string_slogn_en :
             * string_city : 上海 静安
             * string_city_en : Shanghai Jingan
             * float_spend : 475
             */

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
        /**
         * arr_title_data : {"string_positive_title":"推荐餐厅","sting_negative_title":"福利不停 优惠多多"}
         * arr_data : [{"int_id":76,"string_title":"寻味巴黎（长宁来福士）","string_brief_index_en":"北京莫尔顿圣诞套餐火热抢购中 en","string_brief_index":"北京莫尔顿圣诞套餐火热抢购中","string_tag_index":"砍价","sting_pic_url":"/Uploads/2018-08-04/5b647dfe11ebd.png"},{"int_id":174,"string_title":"堡爵仕PRIME概念店(港汇店)","string_brief_index_en":"堡爵仕PRIME概念店 圣诞套餐限时抢购 en","string_brief_index":"堡爵仕PRIME概念店 圣诞套餐限时抢购","string_tag_index":"","sting_pic_url":"/Uploads/2018-10-07/5bba06053436d.jpg"}]
         */

        private ArrTitleDataBeanXXX arr_title_data;
        private List<ArrDataBeanXXX> arr_data;

        public ArrTitleDataBeanXXX getArr_title_data() {
            return arr_title_data;
        }

        public void setArr_title_data(ArrTitleDataBeanXXX arr_title_data) {
            this.arr_title_data = arr_title_data;
        }

        public List<ArrDataBeanXXX> getArr_data() {
            return arr_data;
        }

        public void setArr_data(List<ArrDataBeanXXX> arr_data) {
            this.arr_data = arr_data;
        }

        public static class ArrTitleDataBeanXXX {
            /**
             * string_positive_title : 推荐餐厅
             * sting_negative_title : 福利不停 优惠多多
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

        public static class ArrDataBeanXXX {
            /**
             * int_id : 76
             * string_title : 寻味巴黎（长宁来福士）
             * string_brief_index_en : 北京莫尔顿圣诞套餐火热抢购中 en
             * string_brief_index : 北京莫尔顿圣诞套餐火热抢购中
             * string_tag_index : 砍价
             * sting_pic_url : /Uploads/2018-08-04/5b647dfe11ebd.png
             */

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
        /**
         * arr_title_data : {"string_positive_title":"最新资讯","sting_negative_title":"樽享生活 品味不同"}
         * arr_data : [{"int_id":126,"string_pic_url":"/Uploads/2018-08-27/5b8390268ca8b.jpg","string_title":"\u201c干式熟成专家\u201d堡爵仕推出钜惠套餐，还有机会同享小樽双倍积分！","string_h5_url":"/home/index/detail/id/126.html&home=1&slide=1"},{"int_id":112,"string_pic_url":"/Uploads/2018-08-16/5b74ef465c87b.png","string_title":"以莫尔顿为代表的入驻餐厅们推出钜惠套餐，小樽粉们有福啦！","string_h5_url":"/home/index/detail/id/112.html&home=1&slide=1"},{"int_id":111,"string_pic_url":"/Uploads/2018-08-16/5b750b2c7654e.jpg","string_title":"【团购】橡果为食、草场健身，100%伊比利亚黑猪猪的精致生活太羡慕！","string_h5_url":"/home/index/detail/id/111.html&home=1&slide=1"},{"int_id":107,"string_pic_url":"/Uploads/2018-08-16/5b750ba6aa4e2.jpg","string_title":"【夏日钜惠】莫尔顿品牌40周年庆回馈！错过你真的会后悔！","string_h5_url":"/home/index/detail/id/107.html&home=1&slide=1"},{"int_id":105,"string_pic_url":"/Uploads/2018-08-16/5b750c81c610b.jpg","string_title":"【新店】碳烤食尚VS洋房法餐，欧陆菜系PK堪比世界杯决赛？","string_h5_url":"/home/index/detail/id/105.html&home=1&slide=1"},{"int_id":102,"string_pic_url":"/Uploads/2018-08-16/5b750bbb850c5.jpg","string_title":"【新店】外滩5号，东海大黄鱼限时特惠！黄鱼馆强势加盟樽尚汇！","string_h5_url":"/home/index/detail/id/102.html&home=1&slide=1"},{"int_id":101,"string_pic_url":"/Uploads/2018-08-16/5b750bdeeb34e.jpg","string_title":"【竞猜】百万积分助阵世界杯！大声说出你心目中的冠军！","string_h5_url":"/home/index/detail/id/101.html&home=1&slide=1"},{"int_id":100,"string_pic_url":"/Uploads/2018-08-16/5b750bf74d0c0.jpg","string_title":"【福利】618惊喜倒计时！堡爵仕会员买一送一","string_h5_url":"/home/index/detail/id/100.html&home=1&slide=1"},{"int_id":99,"string_pic_url":"/Uploads/2018-06-29/5b35de1899068.png","string_title":"激情助战世界杯，一起看球，争当预言帝，赢大礼！","string_h5_url":"/home/index/detail/id/99.html&home=1&slide=1"},{"int_id":98,"string_pic_url":"/Uploads/2018-06-29/5b35db66040d9.png","string_title":"儿童节推荐菜品指南，不容错过！","string_h5_url":"/home/index/detail/id/98.html&home=1&slide=1"}]
         */

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
            /**
             * string_positive_title : 最新资讯
             * sting_negative_title : 樽享生活 品味不同
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

        public static class ArrDataBean {
            /**
             * int_id : 126
             * string_pic_url : /Uploads/2018-08-27/5b8390268ca8b.jpg
             * string_title : “干式熟成专家”堡爵仕推出钜惠套餐，还有机会同享小樽双倍积分！
             * string_h5_url : /home/index/detail/id/126.html&home=1&slide=1
             */

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
        /**
         * arr_title_data : {"string_positive_title":"侍酒师推荐","sting_negative_title":"买就送平台现金红包"}
         * arr_data : [{"int_id":103,"int_year":2015,"float_price":148,"string_title":"班费酒庄柯莎红葡萄酒","string_title_en":"Banfi Col di Sasso, Italy","string_cover_url":"/Uploads/2016-11-30/583e59b928139.jpg","string_tips_specials":"下单送50"},{"int_id":597,"int_year":0,"float_price":398,"string_title":"御鹿VSOP干邑白兰地 ","string_title_en":"HINE H by Hine VSOP","string_cover_url":"/Uploads/2018-07-25/5b583f18b6448.jpg","string_tips_specials":""},{"int_id":643,"int_year":2004,"float_price":588,"string_title":"洛佩斯埃雷蒂亚酒庄唐园珍藏干红葡萄酒（750ml）","string_title_en":"R.Lopez de Heredia Vina Tondonia Tinto Reserva（750ml）","string_cover_url":"/Uploads/2018-08-22/5b7cdfd3e84ec.jpg","string_tips_specials":"NEW"},{"int_id":489,"int_year":2014,"float_price":1678,"string_title":"蒲昌葡萄酒套装（6瓶）","string_title_en":"Puchang- Wine Package (6 bottles)","string_cover_url":"/Uploads/2018-08-01/5b6105e701fd4.jpg","string_tips_specials":""},{"int_id":625,"int_year":0,"float_price":2080,"string_title":"贵州茅台飞天53度500mL单瓶装酱香型白酒","string_title_en":"Guizhou Maotai Feitian 53°","string_cover_url":"/Uploads/2018-08-10/5b6d586babc6a.jpg","string_tips_specials":""},{"int_id":604,"int_year":0,"float_price":428,"string_title":"5J橡果饲养100%伊比利亚黑猪肩颈肉（≥600g/包）","string_title_en":"5J Cinco Jotas Presa(Shoulder Cut) ≥600g/pack","string_cover_url":"/Uploads/2018-07-27/5b5ac3a7c681b.jpg","string_tips_specials":""},{"int_id":639,"int_year":0,"float_price":298,"string_title":"精品特级阳澄湖大闸蟹礼券","string_title_en":"Yangcheng Lake Crab Coupons","string_cover_url":"/Uploads/2018-08-17/5b766ecd784a5.png","string_tips_specials":"HOT"},{"int_id":636,"int_year":0,"float_price":298,"string_title":"传忆云南普洱茶龙珠熟茶礼盒装(7g*28粒）","string_title_en":"Chuanyi Yunnan Dragon Pu-er Ripe Tea Set（7g*28grain）","string_cover_url":"/Uploads/2018-08-16/5b74d635634c6.jpg","string_tips_specials":"NEW"},{"int_id":275,"int_year":0,"float_price":540,"string_title":"奥地利 扎尔图格莱维特-欧米茄杯 （1支装）","string_title_en":"ZALTO Gravitas Omega Glass per ONE","string_cover_url":"/Uploads/2017-05-03/590943cabfce5.jpg","string_tips_specials":""}]
         */

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
            /**
             * string_positive_title : 侍酒师推荐
             * sting_negative_title : 买就送平台现金红包
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

        public static class ArrDataBeanX {
            /**
             * int_id : 103
             * int_year : 2015
             * float_price : 148
             * string_title : 班费酒庄柯莎红葡萄酒
             * string_title_en : Banfi Col di Sasso, Italy
             * string_cover_url : /Uploads/2016-11-30/583e59b928139.jpg
             * string_tips_specials : 下单送50
             */

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
        /**
         * arr_title_data : {"string_positive_title":"团购活动","sting_negative_title":"超值精选 参团优惠"}
         * arr_data : [{"int_id":67,"string_title":"团购微信送礼测试","string_url":"/index.php?s=/shoppingmall/groupbuy/detail/id/67.html","string_create_time":"2018年10月18日","int_group":48,"string_total_people":"3人团","int_bought":0,"int_surplus":3,"int_end_time":1540189083,"int_surplus_time":358269,"int_group_price":305,"int_origin_price":380,"int_status":2,"string_status_name":"去参团","string_pic_url":"/Uploads/2018-08-24/5b7fb86045016.png"}]
         */

        private ArrTitleDataBeanXX arr_title_data;
        private List<ArrDataBeanXX> arr_data;

        public ArrTitleDataBeanXX getArr_title_data() {
            return arr_title_data;
        }

        public void setArr_title_data(ArrTitleDataBeanXX arr_title_data) {
            this.arr_title_data = arr_title_data;
        }

        public List<ArrDataBeanXX> getArr_data() {
            return arr_data;
        }

        public void setArr_data(List<ArrDataBeanXX> arr_data) {
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

        public static class ArrDataBeanXX {
            /**
             * int_id : 67
             * string_title : 团购微信送礼测试
             * string_url : /index.php?s=/shoppingmall/groupbuy/detail/id/67.html
             * string_create_time : 2018年10月18日
             * int_group : 48
             * string_total_people : 3人团
             * int_bought : 0
             * int_surplus : 3
             * int_end_time : 1540189083
             * int_surplus_time : 358269
             * int_group_price : 305
             * int_origin_price : 380
             * int_status : 2
             * string_status_name : 去参团
             * string_pic_url : /Uploads/2018-08-24/5b7fb86045016.png
             */

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
