package com.haife.app.nobles.spirits.kotlin.mvp.ui.adapter

import android.content.Context
import android.graphics.Paint
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
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
    private val mViewType: Int by lazy { list.itemType }
    private val builder: ImageConfigImpl.Builder by lazy { ImageConfigImpl.builder() }
    private val imageLoader: ImageLoader by lazy { ArmsUtils.obtainAppComponentFromContext(context).imageLoader() }
    private val layoutInflater: LayoutInflater by lazy { LayoutInflater.from(context) }
    private val typeFaceMedium: Typeface by lazy { Typeface.createFromAsset(context?.assets, "PingFangSC-Medium-Bold.ttf") }

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
                HRecommendMultiItemEntity.NEW_RECOMMEND_RESTAURANT -> {
                    val itemView: View = layoutInflater.inflate(R.layout.recycle_item_home_new_restaurant_child, null)
                    RecommendNewRestaurantViewHolder(itemView)
                }
                HRecommendMultiItemEntity.TASTE_OF_LIFE -> {
                    val itemView: View = layoutInflater.inflate(R.layout.recycle_item_home_recommend_life_child, null)
                    EnjoyLifeViewHolder(itemView)
                }

                else -> throw NullPointerException()
            }

    /**
     * 返回Item数量
     * @return Int
     */
    override fun getItemCount(): Int = list.arr_data.size

    /**
     * onBindViewHolder
     * @param holder RecyclerView.ViewHolder
     * @param position Int
     */
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is RecommendNewRestaurantViewHolder -> bindNewRestaurantViewHolder(holder, position)

            is RecommendRestaurantViewHolder -> bindRecommendRestaurantViewHolder(holder, position)

            is FlashSaleViewHolder -> bindFlashSaleViewHolder(holder, position)

            is WeeklySpecialViewHolder -> bindWeeklySpecialHolder(holder, position)

            is GroupBuyViewHolder -> binGroupBuyHolder(holder, position)

            is EnjoyLifeViewHolder -> bindEnjoyLifeHolder(holder, position)

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
        val recommendRestaurantItemEntity: HomeRecommendData.ArrModuleDataBean.ArrDataBean = list.arr_data[position]
        holder.restaurantNameTv.text = recommendRestaurantItemEntity.string_brief_index
        loadImage(holder.restaurantRIV, R.drawable.ic_home_banner_place_holder, recommendRestaurantItemEntity.sting_pic_url, isRadius = true)
    }

    /**
     * 新入住餐厅
     * @param holder HRecommendChildAdapter.RecommendNewRestaurantViewHolder
     * @param position Int
     */
    private fun bindNewRestaurantViewHolder(holder: HRecommendChildAdapter.RecommendNewRestaurantViewHolder, position: Int) {
        val newRestaurantEntity: HomeRecommendData.ArrModuleDataBean.ArrDataBean = list.arr_data[position]
        holder.restaurantNameTv.text = newRestaurantEntity.string_title
        holder.restaurantPriceTv.text = context.getString(R.string.average_price, newRestaurantEntity.float_spend)
        holder.restaurantContentTv.text = newRestaurantEntity.string_slogn
        loadImage(holder.restaurantRIV, R.drawable.ic_home_banner_place_holder, newRestaurantEntity.string_pic_url, isRadius = true)
    }

    /**
     * bind限时秒杀
     * @param holder HRecommendChildAdapter.FlashSaleViewHolder
     * @param position Int
     */
    private fun bindFlashSaleViewHolder(holder: HRecommendChildAdapter.FlashSaleViewHolder, position: Int) {
        val flashSaleItemEntity: HomeRecommendData.ArrModuleDataBean.ArrDataBean = list.arr_data[position]
        loadImage(holder.productIv, R.drawable.ic_flash_sale_product_place_holder, flashSaleItemEntity.string_pic_url)
        holder.productName.text = flashSaleItemEntity.string_title
        holder.numberPeopleTv.text = context.getString(R.string.flash_sale_product_number, flashSaleItemEntity.int_surplus)
        holder.priceTv.text = context.getString(R.string.product_price, flashSaleItemEntity.float_price)
        holder.originalPriceTv.text = context.getString(R.string.product_price, flashSaleItemEntity.float_origin_price)
        holder.secKillBtn.text = flashSaleItemEntity.string_btn_text
        holder.countDownTimerTv.formatTimerDuring(flashSaleItemEntity.int_surplus_time.toLong(), holder.countDownTimerTv)
        holder.countDownTimerTv.setCountDownEndListener {
            list.arr_data.removeAt(position)
            notifyItemRemoved(position)
        }

    }

    /**
     * bind每周特惠
     * @param holder HRecommendChildAdapter.WeeklySpecialViewHolder
     * @param position Int
     */
    private fun bindWeeklySpecialHolder(holder: HRecommendChildAdapter.WeeklySpecialViewHolder, position: Int) {
        val weeklySpecialsEntity: HomeRecommendData.ArrModuleDataBean.ArrDataBean = list.arr_data[position]
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
        val groupBuyItemEntity: HomeRecommendData.ArrModuleDataBean.ArrDataBean = list.arr_data[position]
        loadImage(holder.productIv, R.drawable.ic_flash_sale_product_place_holder, groupBuyItemEntity.string_pic_url)
        holder.productName.text = groupBuyItemEntity.string_title
        holder.numberPeopleTv.text = context.getString(R.string.group_buy_people_number, groupBuyItemEntity.int_surplus)
        holder.priceTv.text = context.getString(R.string.product_price, groupBuyItemEntity.int_group_price)
        holder.originalPriceTv.text = context.getString(R.string.product_price, groupBuyItemEntity.int_origin_price)
        holder.groupBuyBtn.text = context.getString(R.string.go_to_group_buy)
        holder.countDownTimerTv.formatTimerDuring(groupBuyItemEntity.int_surplus_time.toLong(), holder.countDownTimerTv)
        holder.countDownTimerTv.setCountDownEndListener {
            list.arr_data.removeAt(position)
            notifyItemRemoved(position)
        }

    }

    /**
     * 品味生活
     * @param holder HRecommendChildAdapter.EnjoyLifeViewHolder
     * @param position Int
     */
    private fun bindEnjoyLifeHolder(holder: HRecommendChildAdapter.EnjoyLifeViewHolder, position: Int) {
        val enjoyLifeEntity: HomeRecommendData.ArrModuleDataBean.ArrDataBean = list.arr_data[position]
        holder.enjoyLifeTv.text = enjoyLifeEntity.string_title
        loadImage(holder.enjoyLifeRiv, R.drawable.ic_home_banner_place_holder, enjoyLifeEntity.string_pic_url, isRadius = true)
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
    open inner class RecommendRestaurantViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val restaurantRIV: RoundedImageView = itemView!!.findViewById(R.id.riv_recommend_restaurant)
        val restaurantNameTv: TextView = itemView!!.findViewById(R.id.tv_recommend_restaurant_name)
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
    inner class FlashSaleViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
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

    /**
     *  每周特惠
     * @property productIv ImageView
     * @property productNameTv TextView
     * @property productEnNameTv TextView
     * @property productPriceTv TextView
     * @constructor
     */
    inner class WeeklySpecialViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        var productIv: ImageView = itemView!!.findViewById(R.id.iv_week_special_product)
        var productNameTv: TextView = itemView!!.findViewById(R.id.tv_week_special_product_name)
        var productEnNameTv: TextView = itemView!!.findViewById(R.id.tv_week_special_product_name_en)
        var productPriceTv: TextView = itemView!!.findViewById(R.id.tv_week_special_product_price)
    }

    /**
     * 团购
     * @property productIv ImageView
     * @property productName TextView
     * @property numberPeopleTv TextView
     * @property priceTv TextView
     * @property originalPriceTv TextView
     * @property countDownTimerTv FlashSaleTimerView
     * @property groupBuyBtn Button
     * @constructor
     */
    inner class GroupBuyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
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


    /**
     * 推荐餐厅
     * @property restaurantRIV RoundedImageView
     * @property restaurantNameTv TextView
     * @constructor
     */
    inner class RecommendNewRestaurantViewHolder(itemView: View) : RecommendRestaurantViewHolder(itemView) {
        val restaurantPriceTv: TextView = itemView.findViewById(R.id.tv_recommend_new_restaurant_child_price)
        val restaurantContentTv: TextView = itemView.findViewById(R.id.tv_recommend_new_restaurant_child_content)

    }

    /**
     *
     * @constructor
     */
    inner class EnjoyLifeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val enjoyLifeRiv: RoundedImageView = itemView.findViewById(R.id.riv_recommend_enjoy_life_child)
        val enjoyLifeTv: TextView = itemView.findViewById(R.id.tv_enjoy_life_item_content)
    }
}

