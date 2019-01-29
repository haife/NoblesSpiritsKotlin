package com.haife.app.nobles.spirits.kotlin.mvp.http.entity.result;

import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.base.Data;

import java.util.List;

/**
 * @author Eddie Android Developer
 * @company Q | 樽尚汇
 * @since 2019/1/28$
 * TODO: RestaurantActivity Screen Data
 */
public class MerchantDetailData extends Data<MerchantDetailData> {
    private ArrUserInfoBean arr_user_info;
    private ArrShopDetailBean arr_shop_detail;
    private ArrPreferentialDataBean arr_preferential_data;
    private ArrShopWineDiscountConfigBean arr_shop_wine_discount_config;
    private List<ArrProductDataBean> arr_product_data;
    private List<ArrShopMenuBean> arr_shop_menu;
    private List<ArrShopCouponDataBean> arr_shop_coupon_data;

    public ArrUserInfoBean getArr_user_info() {
        return arr_user_info;
    }

    public void setArr_user_info(ArrUserInfoBean arr_user_info) {
        this.arr_user_info = arr_user_info;
    }

    public ArrShopDetailBean getArr_shop_detail() {
        return arr_shop_detail;
    }

    public void setArr_shop_detail(ArrShopDetailBean arr_shop_detail) {
        this.arr_shop_detail = arr_shop_detail;
    }

    public ArrPreferentialDataBean getArr_preferential_data() {
        return arr_preferential_data;
    }

    public void setArr_preferential_data(ArrPreferentialDataBean arr_preferential_data) {
        this.arr_preferential_data = arr_preferential_data;
    }

    public ArrShopWineDiscountConfigBean getArr_shop_wine_discount_config() {
        return arr_shop_wine_discount_config;
    }

    public void setArr_shop_wine_discount_config(ArrShopWineDiscountConfigBean arr_shop_wine_discount_config) {
        this.arr_shop_wine_discount_config = arr_shop_wine_discount_config;
    }

    public List<ArrProductDataBean> getArr_product_data() {
        return arr_product_data;
    }

    public void setArr_product_data(List<ArrProductDataBean> arr_product_data) {
        this.arr_product_data = arr_product_data;
    }

    public List<ArrShopMenuBean> getArr_shop_menu() {
        return arr_shop_menu;
    }

    public void setArr_shop_menu(List<ArrShopMenuBean> arr_shop_menu) {
        this.arr_shop_menu = arr_shop_menu;
    }

    public List<ArrShopCouponDataBean> getArr_shop_coupon_data() {
        return arr_shop_coupon_data;
    }

    public void setArr_shop_coupon_data(List<ArrShopCouponDataBean> arr_shop_coupon_data) {
        this.arr_shop_coupon_data = arr_shop_coupon_data;
    }

    public static class ArrUserInfoBean {
        /**
         * string_card_level :
         * string_card_level_name :
         */

        private String string_card_level;
        private String string_card_level_name;

        public String getString_card_level() {
            return string_card_level;
        }

        public void setString_card_level(String string_card_level) {
            this.string_card_level = string_card_level;
        }

        public String getString_card_level_name() {
            return string_card_level_name;
        }

        public void setString_card_level_name(String string_card_level_name) {
            this.string_card_level_name = string_card_level_name;
        }
    }

    public static class ArrShopDetailBean {
        /**
         * int_id : 76
         * int_shop_id : 19
         * string_title : 寻味巴黎（长宁来福士）
         * string_title_en : Bistro By Yannick Alleno
         * string_open_time : 周一至周五 14:00-21:00
         * 周六 11:00-22:00
         * 周日 11:00-21:00
         * string_open_time_en : Monday to Friday 14:00-21:00
         * Saturday 11:00-22:00
         * Sunday 11:00-21:00
         * string_address : 长宁区长宁路1195号长宁来福士4号古建6号商铺
         * string_address_en : Unit 6, H4 Building, Raffles City Changning, No. 1195 Changning Road, Changning District, Shanghai, China 200051
         * string_telphone : 021-6088-1677
         * string_introduction : 巴黎是两次获得米其林三星殊荣的大厨亚尼克·阿雷诺土生土长的城市。阿雷诺发现巴黎地区的传统农业用地在城市经济扩张和农村外流的过程中不断锐减，导致了数以百计的本地特有农业物种消失在这片土地，于是他发起了一场目的为拯救这些濒临绝种的农产品和重整农业遗产的复兴运动。
         * 而“寻味巴黎”，一家纯正的法式小餐馆就在这严谨漫长的过程中诞生了。友善、热情和自然纯粹的气氛，融合优质的当季新鲜食材和来自巴黎地道的食谱所料理出的餐点，这就是阿雷诺理想中亲切的法式小餐馆。
         * 寻味巴黎的烹饪概念很单纯：使用来自巴黎传统的食谱和优质的食材，提供简约又有内涵的菜单和新鲜美味的餐点，加上根据当地市场可寻获的特色食材所研发的季节菜色。
         * 寻味巴黎上海餐厅进驻于邻近中山公园的全新地标性商场 – 上海长宁来福士广场内的一栋古建，乘坐地铁2、3或4号线到达中山公园站即可。餐厅复刻了法国餐厅本店的空间设计，采用开放式厨房和天然材料装饰，呈现简约现代的工业风格。上海寻味巴黎更将提供消费者体验仿佛置身巴黎街头用餐的机会，选择户外的座位，享用美食同时更能将古建前绿意盎然的美景收入眼帘。上海寻味巴黎将倾心把绝妙的用餐体验带给全上海的食客们。
         * arr_power : ["1.金樽会员可享联盟餐厅用餐5%折扣优惠。","\r\n2.至樽会员可享联盟餐厅用餐8%折扣优惠","\r\n3.樽享会员及以上可享联盟餐厅指定酒单免开瓶费。","\r\n4.请在使用之前联系您的专属顾问为您安排。",""]
         * arr_power_en : ["*Gold Member- get 5% total dining bill discount ","\r\n*Platinum Member- get 8% total bill discount ","\r\n*Silver or above members can enjoy the quality wines without cockage fee from",""]
         * arr_banner_pic : ["/Uploads/2018-07-02/5b39dd8794764.jpg","/Uploads/2018-07-02/5b39dd8820053.jpg","/Uploads/2018-07-02/5b39dd8921e71.jpg","/Uploads/2018-07-02/5b39dd8928f6a.jpg","/Uploads/2018-07-02/5b39dd8a02634.jpg"]
         * bool_is_double_points : true
         * int_points : 200
         * int_spend : 504
         * int_booking_status : 2
         * arr_shop_tags : []
         * arr_shop_tags_en : []
         * int_booking_num : 63
         */

        private int int_id;
        private int int_shop_id;
        private String string_title;
        private String string_title_en;
        private String string_open_time;
        private String string_open_time_en;
        private String string_address;
        private String string_address_en;
        private String string_telphone;
        private String string_introduction;
        private boolean bool_is_double_points;
        private int int_points;
        private int int_spend;
        private int int_booking_status;
        private int int_booking_num;
        private List<String> arr_power;
        private List<String> arr_power_en;
        private List<String> arr_banner_pic;
        private List<?> arr_shop_tags;
        private List<?> arr_shop_tags_en;

        public int getInt_id() {
            return int_id;
        }

        public void setInt_id(int int_id) {
            this.int_id = int_id;
        }

        public int getInt_shop_id() {
            return int_shop_id;
        }

        public void setInt_shop_id(int int_shop_id) {
            this.int_shop_id = int_shop_id;
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

        public String getString_open_time() {
            return string_open_time;
        }

        public void setString_open_time(String string_open_time) {
            this.string_open_time = string_open_time;
        }

        public String getString_open_time_en() {
            return string_open_time_en;
        }

        public void setString_open_time_en(String string_open_time_en) {
            this.string_open_time_en = string_open_time_en;
        }

        public String getString_address() {
            return string_address;
        }

        public void setString_address(String string_address) {
            this.string_address = string_address;
        }

        public String getString_address_en() {
            return string_address_en;
        }

        public void setString_address_en(String string_address_en) {
            this.string_address_en = string_address_en;
        }

        public String getString_telphone() {
            return string_telphone;
        }

        public void setString_telphone(String string_telphone) {
            this.string_telphone = string_telphone;
        }

        public String getString_introduction() {
            return string_introduction;
        }

        public void setString_introduction(String string_introduction) {
            this.string_introduction = string_introduction;
        }

        public boolean isBool_is_double_points() {
            return bool_is_double_points;
        }

        public void setBool_is_double_points(boolean bool_is_double_points) {
            this.bool_is_double_points = bool_is_double_points;
        }

        public int getInt_points() {
            return int_points;
        }

        public void setInt_points(int int_points) {
            this.int_points = int_points;
        }

        public int getInt_spend() {
            return int_spend;
        }

        public void setInt_spend(int int_spend) {
            this.int_spend = int_spend;
        }

        public int getInt_booking_status() {
            return int_booking_status;
        }

        public void setInt_booking_status(int int_booking_status) {
            this.int_booking_status = int_booking_status;
        }

        public int getInt_booking_num() {
            return int_booking_num;
        }

        public void setInt_booking_num(int int_booking_num) {
            this.int_booking_num = int_booking_num;
        }

        public List<String> getArr_power() {
            return arr_power;
        }

        public void setArr_power(List<String> arr_power) {
            this.arr_power = arr_power;
        }

        public List<String> getArr_power_en() {
            return arr_power_en;
        }

        public void setArr_power_en(List<String> arr_power_en) {
            this.arr_power_en = arr_power_en;
        }

        public List<String> getArr_banner_pic() {
            return arr_banner_pic;
        }

        public void setArr_banner_pic(List<String> arr_banner_pic) {
            this.arr_banner_pic = arr_banner_pic;
        }

        public List<?> getArr_shop_tags() {
            return arr_shop_tags;
        }

        public void setArr_shop_tags(List<?> arr_shop_tags) {
            this.arr_shop_tags = arr_shop_tags;
        }

        public List<?> getArr_shop_tags_en() {
            return arr_shop_tags_en;
        }

        public void setArr_shop_tags_en(List<?> arr_shop_tags_en) {
            this.arr_shop_tags_en = arr_shop_tags_en;
        }
    }

    public static class ArrPreferentialDataBean {
        private List<ArrTopPreferentialDataBean> arr_top_preferential_data;
        private List<?> arr_lower_preferential_data;

        public List<ArrTopPreferentialDataBean> getArr_top_preferential_data() {
            return arr_top_preferential_data;
        }

        public void setArr_top_preferential_data(List<ArrTopPreferentialDataBean> arr_top_preferential_data) {
            this.arr_top_preferential_data = arr_top_preferential_data;
        }

        public List<?> getArr_lower_preferential_data() {
            return arr_lower_preferential_data;
        }

        public void setArr_lower_preferential_data(List<?> arr_lower_preferential_data) {
            this.arr_lower_preferential_data = arr_lower_preferential_data;
        }

        public static class ArrTopPreferentialDataBean {
            /**
             * string_image_url : /html/images/i_zhe.png
             * string_title : 新店开业优惠
             * string_explain : 全场开业5折优惠（2018年7月8-10日）
             */

            private String string_image_url;
            private String string_title;
            private String string_explain;

            public String getString_image_url() {
                return string_image_url;
            }

            public void setString_image_url(String string_image_url) {
                this.string_image_url = string_image_url;
            }

            public String getString_title() {
                return string_title;
            }

            public void setString_title(String string_title) {
                this.string_title = string_title;
            }

            public String getString_explain() {
                return string_explain;
            }

            public void setString_explain(String string_explain) {
                this.string_explain = string_explain;
            }
        }
    }

    public static class ArrShopWineDiscountConfigBean {
        /**
         * string_discount :
         * string_time :
         * bool_is_discount : false
         */

        private String string_discount;
        private String string_time;
        private boolean bool_is_discount;

        public String getString_discount() {
            return string_discount;
        }

        public void setString_discount(String string_discount) {
            this.string_discount = string_discount;
        }

        public String getString_time() {
            return string_time;
        }

        public void setString_time(String string_time) {
            this.string_time = string_time;
        }

        public boolean isBool_is_discount() {
            return bool_is_discount;
        }

        public void setBool_is_discount(boolean bool_is_discount) {
            this.bool_is_discount = bool_is_discount;
        }
    }

    public static class ArrProductDataBean {
        /**
         * int_type_id : 31
         * string_type_name : 世界名庄
         * arr_product_attr_data : [{"int_id":72,"string_image":"/Uploads/2018-05-12/5af69ad16291c.jpg","string_title_en":"Chateau Pontet-Canet","string_title":"庞特卡内古堡红葡萄酒","string_country_name":"法国","int_year":2013,"double_price":1650,"bool_product_wine":true},{"int_id":32,"string_image":"/Uploads/2018-05-12/5af695691d2bd.jpg","string_title_en":"Les Tourelles de Longueville","string_title":"碧尚男爵酒庄副牌红葡萄酒","string_country_name":"法国","int_year":2010,"double_price":850,"bool_product_wine":true},{"int_id":28,"string_image":"/Uploads/2018-05-12/5af690da0b747.jpg","string_title_en":"Les Pagodes de Cos","string_title":"爱士宝塔 (爱士图尔副牌) 红葡萄酒","string_country_name":"法国","int_year":2010,"double_price":1280,"bool_product_wine":true},{"int_id":70,"string_image":"/Uploads/2018-05-12/5af69fa931199.jpg","string_title_en":"Chateau Duhart Milon","string_title":"都夏美隆庄园红葡萄酒","string_country_name":"法国","int_year":2012,"double_price":1450,"bool_product_wine":true},{"int_id":491,"string_image":"/Uploads/2018-03-21/5ab1f9bfa57cd.jpg","string_title_en":"Le Clarence de Haut Brion","string_title":"小侯伯王干红葡萄酒","string_country_name":"法国","int_year":2011,"double_price":1650,"bool_product_wine":true},{"int_id":68,"string_image":"/Uploads/2018-05-12/5af6a2c10c58c.jpg","string_title_en":"Chateau Calon-Segur","string_title":"凯隆世家庄园红葡萄酒","string_country_name":"法国","int_year":2000,"double_price":2280,"bool_product_wine":true},{"int_id":257,"string_image":"/Uploads/2017-04-28/5902ed05d0c55.jpg","string_title_en":"Pavillon Rough du Chateau Margaux ","string_title":"玛歌红亭干红葡萄酒","string_country_name":"法国","int_year":2012,"double_price":2540,"bool_product_wine":true},{"int_id":161,"string_image":"/Uploads/2016-12-14/5850eb260fcd4.jpg","string_title_en":"Chateau Leoville Las Cases","string_title":"雄狮庄园干红葡萄酒","string_country_name":"法国","int_year":2010,"double_price":3350,"bool_product_wine":true},{"int_id":67,"string_image":"/Uploads/2018-06-08/5b1a45098ce59.jpg","string_title_en":"Les Forts de Latour Pauillac","string_title":"拉图庄园副牌（小拉图）红葡萄酒","string_country_name":"法国","int_year":2009,"double_price":3570,"bool_product_wine":true},{"int_id":246,"string_image":"/Uploads/2017-04-20/58f8c291084be.jpg","string_title_en":"Chateau Angelus","string_title":"金钟城堡干红葡萄酒","string_country_name":"法国","int_year":2010,"double_price":4546,"bool_product_wine":true},{"int_id":879,"string_image":"/Uploads/ns_1544091611234.jpg","string_title_en":"Chateau Latour 1er Grand Cru Classe, Pauillac 2011","string_title":"波尔多一级头等苑拉图古堡干红葡萄酒","string_country_name":"法国","int_year":2011,"double_price":6480,"bool_product_wine":true},{"int_id":889,"string_image":"/Uploads/ns_1544146869774.jpg","string_title_en":"Domaine de la Romanee Conti \"Romanee-St-Vivant\" Grand Cru 2007","string_title":"罗曼尼酒庄\u201c圣维望\u201d特级园红葡萄酒","string_country_name":"法国","int_year":2007,"double_price":21800,"bool_product_wine":true},{"int_id":886,"string_image":"/Uploads/ns_1544093113929.jpg","string_title_en":"Domaine de la Romanee Conti \"La Tache\" Grand Cru 2007","string_title":"罗曼尼酒庄\u201c拉塔希\u201d特级园红葡萄酒","string_country_name":"法国","int_year":2007,"double_price":39800,"bool_product_wine":true}]
         */

        private int int_type_id;
        private String string_type_name;
        private List<ArrProductAttrDataBean> arr_product_attr_data;

        public int getInt_type_id() {
            return int_type_id;
        }

        public void setInt_type_id(int int_type_id) {
            this.int_type_id = int_type_id;
        }

        public String getString_type_name() {
            return string_type_name;
        }

        public void setString_type_name(String string_type_name) {
            this.string_type_name = string_type_name;
        }

        public List<ArrProductAttrDataBean> getArr_product_attr_data() {
            return arr_product_attr_data;
        }

        public void setArr_product_attr_data(List<ArrProductAttrDataBean> arr_product_attr_data) {
            this.arr_product_attr_data = arr_product_attr_data;
        }

        public static class ArrProductAttrDataBean {
            /**
             * int_id : 72
             * string_image : /Uploads/2018-05-12/5af69ad16291c.jpg
             * string_title_en : Chateau Pontet-Canet
             * string_title : 庞特卡内古堡红葡萄酒
             * string_country_name : 法国
             * int_year : 2013
             * double_price : 1650
             * bool_product_wine : true
             */

            private int int_id;
            private String string_image;
            private String string_title_en;
            private String string_title;
            private String string_country_name;
            private int int_year;
            private int double_price;
            private boolean bool_product_wine;

            public int getInt_id() {
                return int_id;
            }

            public void setInt_id(int int_id) {
                this.int_id = int_id;
            }

            public String getString_image() {
                return string_image;
            }

            public void setString_image(String string_image) {
                this.string_image = string_image;
            }

            public String getString_title_en() {
                return string_title_en;
            }

            public void setString_title_en(String string_title_en) {
                this.string_title_en = string_title_en;
            }

            public String getString_title() {
                return string_title;
            }

            public void setString_title(String string_title) {
                this.string_title = string_title;
            }

            public String getString_country_name() {
                return string_country_name;
            }

            public void setString_country_name(String string_country_name) {
                this.string_country_name = string_country_name;
            }

            public int getInt_year() {
                return int_year;
            }

            public void setInt_year(int int_year) {
                this.int_year = int_year;
            }

            public int getDouble_price() {
                return double_price;
            }

            public void setDouble_price(int double_price) {
                this.double_price = double_price;
            }

            public boolean isBool_product_wine() {
                return bool_product_wine;
            }

            public void setBool_product_wine(boolean bool_product_wine) {
                this.bool_product_wine = bool_product_wine;
            }
        }
    }

    public static class ArrShopMenuBean {
        /**
         * int_id : 162
         * int_shop_id : 19
         * string_title_cn : Frou-Frou 水波蛋、牛肉清汤冻伴芥末蛋黄酱及新鲜香料
         * string_title_en : Poached egg cooked in “Frou-Frou” style
         * string_pic_url : /Uploads/2018-07-02/5b39ef374621d.jpg
         */

        private int int_id;
        private int int_shop_id;
        private String string_title_cn;
        private String string_title_en;
        private String string_pic_url;

        public int getInt_id() {
            return int_id;
        }

        public void setInt_id(int int_id) {
            this.int_id = int_id;
        }

        public int getInt_shop_id() {
            return int_shop_id;
        }

        public void setInt_shop_id(int int_shop_id) {
            this.int_shop_id = int_shop_id;
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

        public String getString_pic_url() {
            return string_pic_url;
        }

        public void setString_pic_url(String string_pic_url) {
            this.string_pic_url = string_pic_url;
        }
    }

    public static class ArrShopCouponDataBean {
        /**
         * int_id : 183
         * string_background : /Uploads/2018-05-03/5aea6d44353fc.png
         * int_giving_money : 398
         * string_cate_name : 兑换券
         * string_brief : 寻味巴黎（长宁来福士店）
         * string_title : 晚市套餐兑换券
         * int_need_points : 12250
         */

        private int int_id;
        private String string_background;
        private int int_giving_money;
        private String string_cate_name;
        private String string_brief;
        private String string_title;
        private int int_need_points;

        public int getInt_id() {
            return int_id;
        }

        public void setInt_id(int int_id) {
            this.int_id = int_id;
        }

        public String getString_background() {
            return string_background;
        }

        public void setString_background(String string_background) {
            this.string_background = string_background;
        }

        public int getInt_giving_money() {
            return int_giving_money;
        }

        public void setInt_giving_money(int int_giving_money) {
            this.int_giving_money = int_giving_money;
        }

        public String getString_cate_name() {
            return string_cate_name;
        }

        public void setString_cate_name(String string_cate_name) {
            this.string_cate_name = string_cate_name;
        }

        public String getString_brief() {
            return string_brief;
        }

        public void setString_brief(String string_brief) {
            this.string_brief = string_brief;
        }

        public String getString_title() {
            return string_title;
        }

        public void setString_title(String string_title) {
            this.string_title = string_title;
        }

        public int getInt_need_points() {
            return int_need_points;
        }

        public void setInt_need_points(int int_need_points) {
            this.int_need_points = int_need_points;
        }
    }
}
