package com.haife.app.nobles.spirits.kotlin.mvp.ui.adapter

import android.content.Context
import android.graphics.Paint
import android.graphics.Typeface
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.haife.app.nobles.spirits.kotlin.BuildConfig
import com.haife.app.nobles.spirits.kotlin.R
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.multi.HRecommendMultiItemEntity
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.result.HomeRecommendData
import com.haife.app.nobles.spirits.kotlin.mvp.ui.utlis.DiskCacheStrategyType
import com.haife.app.nobles.spirits.kotlin.mvp.ui.widget.FlashSaleTimerView
import com.jess.arms.http.imageloader.ImageLoader
import com.jess.arms.http.imageloader.glide.ImageConfigImpl
import com.jess.arms.utils.ArmsUtils
import com.makeramen.roundedimageview.RoundedImageView

/**
 * @ author haife
 * @ since 2019/1/4
 * TODO：首页列表Item布局适配器
 */

/**
 * @ author haife
 * @ since 2019/1/4
 * 首页列表Item布局适配器
 */
class HRecommendChildAdapter(val list: HRecommendMultiItemEntity, val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val mViewType = list.itemType
    private var imageLoader: ImageLoader = ArmsUtils.obtainAppComponentFromContext(context).imageLoader()
    private var layoutInflater: LayoutInflater = LayoutInflater.from(context)
    var typeFaceMedium: Typeface = Typeface.createFromAsset(context.assets, "PingFangSC-Medium-Bold.ttf")
    private val builder: ImageConfigImpl.Builder = ImageConfigImpl.builder()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
            when (viewType) {
                HRecommendMultiItemEntity.RECOMMEND_RESTAURANT -> {
                    val itemView: View = layoutInflater.inflate(R.layout.recycle_item_home_recommend_restaurant_child, null)
                    RecommendRestaurantViewHolder(itemView)
                }

                HRecommendMultiItemEntity.FLASH_SAlE -> {
                    val itemView: View = layoutInflater.inflate(R.layout.recycle_item_home_flash_sale_child, null)
                    FlashSaleViewHolder(itemView)
                }

                HRecommendMultiItemEntity.WEEK_PREFERENTIAL -> {
                    val itemView: View = layoutInflater.inflate(R.layout.recycle_item_home_week_special_child, null)
                    WeeklySpecialViewHolder(itemView)
                }
                HRecommendMultiItemEntity.GROUP_BUY_ACTIVITY -> {
                    val itemView: View = layoutInflater.inflate(R.layout.recycle_item_home_group_buy_child, null)
                    GroupBuyViewHolder(itemView)
                }
                else -> throw NullPointerException()
            }

    /**
     * 返回Item数量
     * @return Int
     */
    override fun getItemCount(): Int = when (mViewType) {
        HRecommendMultiItemEntity.RECOMMEND_RESTAURANT -> list.arr_index_recommend_shop.arr_data.size
        HRecommendMultiItemEntity.FLASH_SAlE -> list.arr_index_flash_sale_list.arr_data.size
        HRecommendMultiItemEntity.WEEK_PREFERENTIAL -> list.arr_index_weekly_specials_data.arr_data.size
        HRecommendMultiItemEntity.GROUP_BUY_ACTIVITY -> list.arr_group_data.arr_data.size
        else -> 0
    }

    /**
     * onBindViewHolder
     * @param holder RecyclerView.ViewHolder
     * @param position Int
     */
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is RecommendRestaurantViewHolder -> bindRecommendRestaurantViewHolder(holder, position)

            is FlashSaleViewHolder -> bindFlashSaleViewHolder(holder, position)

            is WeeklySpecialViewHolder -> bindWeeklySpecialHolder(holder, position)

            is GroupBuyViewHolder -> binGroupBuyHolder(holder, position)

        }
    }


    /**
     * Recycle Item 类型
     * @param position Int
     * @return Int
     */
    override fun getItemViewType(position: Int): Int {
        return mViewType
    }

    /**
     * bind推荐餐厅
     * @param holder HRecommendChildAdapter.RecommendRestaurantViewHolder
     * @param position Int
     */
    private fun bindRecommendRestaurantViewHolder(holder: HRecommendChildAdapter.RecommendRestaurantViewHolder, position: Int) {
        val recommendRestaurantItemEntity: HomeRecommendData.ArrIndexRecommendShopBean.ArrRecommendShopBean = list.arr_index_recommend_shop.arr_data[position]
        holder.restaurantNameTv.text = recommendRestaurantItemEntity.string_brief_index
        loadImage(holder.restaurantRIV, R.drawable.ic_home_banner_place_holder, recommendRestaurantItemEntity.sting_pic_url, isRadius = true)
    }

    /**
     * bind限时秒杀
     * @param holder HRecommendChildAdapter.FlashSaleViewHolder
     * @param position Int
     */
    private fun bindFlashSaleViewHolder(holder: HRecommendChildAdapter.FlashSaleViewHolder, position: Int) {
        val flashSaleItemEntity: HomeRecommendData.ArrIndexFlashSaleListBean.ArrDataBeanFlash = list.arr_index_flash_sale_list.arr_data[position]
        loadImage(holder.productIv, R.drawable.ic_flash_sale_product_place_holder, flashSaleItemEntity.string_pic_url)
        holder.productName.text = flashSaleItemEntity.string_title
        holder.numberPeopleTv.text = context.getString(R.string.flash_sale_product_number, flashSaleItemEntity.int_surplus)
        holder.priceTv.text = context.getString(R.string.product_price, flashSaleItemEntity.float_price)
        holder.originalPriceTv.text = context.getString(R.string.product_price, flashSaleItemEntity.float_origin_price)
        holder.secKillBtn.text = flashSaleItemEntity.string_btn_text
        holder.countDownTimerTv.formatTimerDuring(flashSaleItemEntity.int_surplus_time.toLong(), holder.countDownTimerTv)
        holder.countDownTimerTv.setCountDownEndListener {
            list.arr_index_flash_sale_list.arr_data.removeAt(position)
            notifyItemRemoved(position)

        }
    }

    /**
     * bind每周特惠
     * @param holder HRecommendChildAdapter.WeeklySpecialViewHolder
     * @param position Int
     */
    private fun bindWeeklySpecialHolder(holder: HRecommendChildAdapter.WeeklySpecialViewHolder, position: Int) {
        val weeklySpecialsEntity: HomeRecommendData.ArrIndexWeeklySpecialsDataBean.WeeklySpecialsBean = list.arr_index_weekly_specials_data.arr_data[position]
        loadImage(holder.productIv, R.drawable.ic_flash_sale_product_place_holder, weeklySpecialsEntity.string_cover_url, isRadius = true)
        holder.productNameTv.text = weeklySpecialsEntity.string_title
        holder.productEnNameTv.text = weeklySpecialsEntity.string_title_en
        holder.productPriceTv.text = context.getString(R.string.product_price, weeklySpecialsEntity.float_price)

    }

    /**
     * bind 团购
     * @param holder HRecommendChildAdapter.GroupBuyViewHolder
     * @param position Int
     */
    private fun binGroupBuyHolder(holder: HRecommendChildAdapter.GroupBuyViewHolder, position: Int) {
        val groupBuyItemEntity: HomeRecommendData.ArrGroupDataBean.ArrGroupBuyTitleBean = list.arr_group_data.arr_data[position]
        loadImage(holder.productIv, R.drawable.ic_flash_sale_product_place_holder, groupBuyItemEntity.string_pic_url)
        holder.productName.text = groupBuyItemEntity.string_title
        holder.numberPeopleTv.text = context.getString(R.string.flash_sale_product_number, groupBuyItemEntity.int_surplus)
        holder.priceTv.text = context.getString(R.string.product_price, groupBuyItemEntity.int_group_price)
        holder.originalPriceTv.text = context.getString(R.string.product_price, groupBuyItemEntity.int_origin_price)
        holder.groupBuyBtn.text = context.getString(R.string.go_to_group_buy)
        holder.countDownTimerTv.formatTimerDuring(groupBuyItemEntity.int_surplus_time.toLong(), holder.countDownTimerTv)
        holder.countDownTimerTv.setCountDownEndListener {
            list.arr_index_flash_sale_list.arr_data.removeAt(position)
            notifyItemRemoved(position)
        }
    }


    /**
     * 加载图片
     * @param intoIv ImageView
     * @param drawableRes Int
     * @param imageUrl String
     */
    private fun loadImage(intoIv: ImageView, drawableRes: Int, imageUrl: String, isRadius: Boolean = false) {
        if (isRadius) {
            builder.imageRadius(5)
        }
        imageLoader.loadImage(context, builder.url(BuildConfig.API_HOST + imageUrl)
                .cacheStrategy(DiskCacheStrategyType.All).imageView(intoIv)
                .isCenterCrop(true)
                .placeholder(drawableRes).build())

    }

    /**
     * 推荐餐厅
     * @property restaurantRIV RoundedImageView
     * @property restaurantNameTv TextView
     * @constructor
     */
    inner class RecommendRestaurantViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        val restaurantRIV: RoundedImageView = itemView!!.findViewById(R.id.riv_recommend_restaurant_child)
        val restaurantNameTv: TextView = itemView!!.findViewById(R.id.tv_recommend_restaurant_child_name)

        init {
            restaurantNameTv.typeface = typeFaceMedium;
        }
    }

    /**
     * 限时秒杀
     * @property productIv
     * @property productName
     * @property numberPeopleTv
     * @property priceTv
     * @property originalPriceTv (原价)
     * @property countDownTimerTv (倒计时)
     * @property secKillBtn
     * @constructor
     */
    inner class FlashSaleViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        val productIv: ImageView = itemView!!.findViewById(R.id.iv_flash_sale_child_product_bg)
        val productName: TextView = itemView!!.findViewById(R.id.tv_flash_sale_child_product_name)
        val numberPeopleTv: TextView = itemView!!.findViewById(R.id.tv_flash_sale_number_of_people)
        val priceTv: TextView = itemView!!.findViewById(R.id.tv_flash_sale_child_product_price)
        val originalPriceTv: TextView = itemView!!.findViewById(R.id.tv_flash_sale_child_product_original_price)
        val countDownTimerTv: FlashSaleTimerView = itemView!!.findViewById(R.id.tv_flash_sale_count_down_time)
        val secKillBtn: Button = itemView!!.findViewById(R.id.btn_sec_kill)

        init {
            originalPriceTv.paint.flags = Paint.STRIKE_THRU_TEXT_FLAG
        }
    }


    inner class WeeklySpecialViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var productIv: ImageView = itemView!!.findViewById(R.id.iv_week_special_product)
        var productNameTv: TextView = itemView!!.findViewById(R.id.tv_week_special_product_name)
        var productEnNameTv: TextView = itemView!!.findViewById(R.id.tv_week_special_product_name_en)
        var productPriceTv: TextView = itemView!!.findViewById(R.id.tv_week_special_product_price)
    }

    inner class GroupBuyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var productIv: ImageView = itemView!!.findViewById(R.id.iv_group_buy_child_product_bg)
        val productName: TextView = itemView!!.findViewById(R.id.tv_group_buy_child_product_name)
        val numberPeopleTv: TextView = itemView!!.findViewById(R.id.tv_group_buy_number_of_people)
        val priceTv: TextView = itemView!!.findViewById(R.id.tv_group_buy_child_product_price)
        val originalPriceTv: TextView = itemView!!.findViewById(R.id.tv_group_buy_child_product_original_price)
        val countDownTimerTv: FlashSaleTimerView = itemView!!.findViewById(R.id.tv_group_buy_count_down_time)
        val groupBuyBtn: Button = itemView!!.findViewById(R.id.btn_group_buy)

        init {
            originalPriceTv.paint.flags = Paint.STRIKE_THRU_TEXT_FLAG
        }
    }

}

