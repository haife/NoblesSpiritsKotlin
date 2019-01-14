package com.haife.app.nobles.spirits.kotlin.mvp.ui.adapter

import android.content.Context
import android.graphics.Typeface
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.TextView
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.haife.app.nobles.spirits.kotlin.BuildConfig
import com.haife.app.nobles.spirits.kotlin.R
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.multi.HRecommendMultiItemEntity
import com.haife.app.nobles.spirits.kotlin.mvp.ui.decoration.HorizontalSpacesItemDecoration
import com.haife.app.nobles.spirits.kotlin.mvp.ui.decoration.RecycleViewDivide
import com.haife.app.nobles.spirits.kotlin.mvp.ui.loader.BannerImageLoader
import com.youth.banner.Banner


/**
 * @ author haife
 * @ since 2019/1/2
 * TODO 首页推荐列表适配器
 */

class HRecommendAdapter(data: MutableList<HRecommendMultiItemEntity>?, val context: Context) : BaseMultiItemQuickAdapter<HRecommendMultiItemEntity, BaseViewHolder>(data) {
    private val mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    private val verticalManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
    private var typeFaceMedium = Typeface.createFromAsset(context.assets, "PingFangSC-Medium-Bold.ttf")!!
    private var typeFaceLight = Typeface.createFromAsset(context.assets, "PingFangSC-Light-Face.ttf")
    private var bannerUrls: ArrayList<String>? = null
    private var recommendRestaurantAdapter: HRecommendChildAdapter? = null
    private var flashSaleAdapter: HRecommendChildAdapter? = null
    private var weeklySpecialAdapter: HRecommendChildAdapter? = null
    private var groupBuyAdapter: HRecommendChildAdapter? = null

    init {
        addItemType(HRecommendMultiItemEntity.BANNER_TYPE, R.layout.recycle_item_home_recommend_banner)
        addItemType(HRecommendMultiItemEntity.RECOMMEND_RESTAURANT, R.layout.recycle_item_home_recommend_restaurant)
        addItemType(HRecommendMultiItemEntity.FLASH_SAlE, R.layout.recycle_item_home_flash_sale)
        addItemType(HRecommendMultiItemEntity.WEEK_PREFERENTIAL, R.layout.recycle_item_home_week_special)
        addItemType(HRecommendMultiItemEntity.GROUP_BUY_ACTIVITY, R.layout.recycle_item_home_group_buy)
    }

    override fun convert(helper: BaseViewHolder?, item: HRecommendMultiItemEntity?) {
        when (item?.TypeItem) {
            HRecommendMultiItemEntity.BANNER_TYPE -> {
                item.arr_index_banner_data.forEach { bannerUrls?.add(BuildConfig.API_HOST + it.string_pic_url) }
                var banner: Banner = helper!!.getView<Banner>(R.id.banner_home_recommend)
                banner.setImages(bannerUrls)
                banner.startAutoPlay()
                banner.setImageLoader(BannerImageLoader())

            }
            HRecommendMultiItemEntity.RECOMMEND_RESTAURANT -> {
                setItemTitleText(helper, item)
                if (recommendRestaurantAdapter == null) {
                    val recommendRestaurantRv: RecyclerView = helper!!.getView(R.id.rv_recommend_shop_container)
                    recommendRestaurantAdapter = HRecommendChildAdapter(item, mContext)
                    recommendRestaurantRv.layoutManager = mLayoutManager
                    recommendRestaurantRv.addItemDecoration(HorizontalSpacesItemDecoration(42))
                    recommendRestaurantRv.adapter = recommendRestaurantAdapter
                }
            }

            HRecommendMultiItemEntity.FLASH_SAlE -> {
                setItemTitleText(helper, item)
                if (flashSaleAdapter == null) {
                    val flashSaleRv: RecyclerView = helper!!.getView(R.id.rv_flash_sale_container)
                    flashSaleAdapter = HRecommendChildAdapter(item, mContext)
                    flashSaleRv.addItemDecoration(RecycleViewDivide(mContext, drawableId = null, divideHeight = 20, divideColor = ContextCompat.getColor(mContext, R.color.write)))
                    flashSaleRv.layoutManager = verticalManager
                    flashSaleRv.adapter = flashSaleAdapter
                }
            }

            HRecommendMultiItemEntity.WEEK_PREFERENTIAL -> {
                setItemTitleText(helper, item)
                if (weeklySpecialAdapter == null) {
                    val weekSpecialRV = helper!!.getView<RecyclerView>(R.id.rv_recommend_week_special_container)
                    weekSpecialRV.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                    weekSpecialRV.addItemDecoration(HorizontalSpacesItemDecoration(42))
                    weeklySpecialAdapter = HRecommendChildAdapter(item, mContext)
                    weekSpecialRV.adapter = weeklySpecialAdapter

                }
            }
            HRecommendMultiItemEntity.GROUP_BUY_ACTIVITY -> {
                setItemTitleText(helper, item)
                if (groupBuyAdapter == null) {
                    var groupBuyRV = helper!!.getView<RecyclerView>(R.id.rv_group_buy_container)
                    groupBuyRV.layoutManager = LinearLayoutManager(context)
                    groupBuyRV.addItemDecoration(RecycleViewDivide(mContext,divideHeight = 20, divideColor = ContextCompat.getColor(mContext, R.color.write)))
                    groupBuyAdapter = HRecommendChildAdapter(item, mContext)
                    groupBuyRV.adapter = groupBuyAdapter
                }
            }
        }
    }

    /**
     * TODO: 设置ItemTitle和TypeFace
     * @param helper BaseViewHolder?
     * @param itemEntity HRecommendMultiItemEntity
     */
    private fun setItemTitleText(helper: BaseViewHolder?, itemEntity: HRecommendMultiItemEntity) {
        var bigTitleStr: String
        var subTittleStr: String
        var bigTitleTv: TextView
        var subTitleTv: TextView
        var itemSizeTv: TextView
        when (itemEntity.TypeItem) {
            HRecommendMultiItemEntity.RECOMMEND_RESTAURANT -> {
                bigTitleTv = helper!!.getView(R.id.tv_recommend_shop_name)
                subTitleTv = helper!!.getView(R.id.tv_recommend_shop_subtitle)
                itemSizeTv = helper!!.getView(R.id.tv_recommend_shop_number)
                bigTitleStr = itemEntity.arr_index_recommend_shop.arr_title_data.string_positive_title
                subTittleStr = itemEntity.arr_index_recommend_shop.arr_title_data.sting_negative_title
                bigTitleTv.text = bigTitleStr
                subTitleTv.text = subTittleStr
                itemSizeTv.text = itemEntity.arr_index_recommend_shop.arr_data.size.toString()
                bigTitleTv.typeface = typeFaceMedium
                subTitleTv.typeface = typeFaceLight
            }

            HRecommendMultiItemEntity.FLASH_SAlE -> {
                bigTitleTv = helper!!.getView(R.id.tv_flash_sale_name)
                subTitleTv = helper!!.getView(R.id.tv_flash_sale_subtitle)
                bigTitleStr = itemEntity.arr_index_flash_sale_list.arr_title_data.string_positive_title
                subTittleStr = itemEntity.arr_index_flash_sale_list.arr_title_data.sting_negative_title
                bigTitleTv.text = bigTitleStr
                subTitleTv.text = subTittleStr
                bigTitleTv.typeface = typeFaceMedium
                subTitleTv.typeface = typeFaceLight
            }

            HRecommendMultiItemEntity.WEEK_PREFERENTIAL -> {
                bigTitleTv = helper!!.getView(R.id.tv_recommend_week_special_title)
                subTitleTv = helper!!.getView(R.id.tv_recommend_week_special_subtitle)
                itemSizeTv = helper!!.getView(R.id.tv_ic_home_recommend_week_special_number)
                bigTitleStr = itemEntity.arr_index_weekly_specials_data.arr_title_data.string_positive_title
                subTittleStr = itemEntity.arr_index_weekly_specials_data.arr_title_data.sting_negative_title
                bigTitleTv.text = bigTitleStr
                subTitleTv.text = subTittleStr
                itemSizeTv.text = itemEntity.arr_index_weekly_specials_data.arr_data.size.toString()
                bigTitleTv.typeface = typeFaceMedium
                subTitleTv.typeface = typeFaceLight
            }
            HRecommendMultiItemEntity.GROUP_BUY_ACTIVITY -> {
                bigTitleTv = helper!!.getView(R.id.tv_group_buy_name)
                subTitleTv = helper!!.getView(R.id.tv_group_buy_subtitle)
                bigTitleStr = itemEntity.arr_group_data.arr_title_data.string_positive_title
                subTittleStr = itemEntity.arr_group_data.arr_title_data.sting_negative_title
                bigTitleTv.text = bigTitleStr
                subTitleTv.text = subTittleStr
                bigTitleTv.typeface = typeFaceMedium
                subTitleTv.typeface = typeFaceLight
            }


        }


    }


}


