package com.haife.app.nobles.spirits.kotlin.mvp.ui.adapter

import android.content.Context
import android.graphics.Typeface
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.TextView
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.haife.app.nobles.spirits.kotlin.BuildConfig
import com.haife.app.nobles.spirits.kotlin.R
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.multi.HRecommendMultiItemEntity
import com.haife.app.nobles.spirits.kotlin.mvp.ui.decoration.SpacesItemDecoration
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

    init {
        addItemType(HRecommendMultiItemEntity.BANNER_TYPE, R.layout.recycle_item_home_recommend_banner)
        addItemType(HRecommendMultiItemEntity.RECOMMEND_RESTAURANT, R.layout.recycle_item_home_recommend_restaurant)
        addItemType(HRecommendMultiItemEntity.FLASH_SAlE, R.layout.recycle_item_home_flash_sale)
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
                val bigTitleStr = item.arr_index_recommend_shop.arr_title_data.string_positive_title
                val subTittleStr = item.arr_index_recommend_shop.arr_title_data.sting_negative_title
                setItemTitleText(helper!!.getView(R.id.tv_recommend_shop_name), bigTitleStr, helper.getView(R.id.tv_recommend_shop_subtitle), subTittleStr)
                if (recommendRestaurantAdapter == null) {
                    val recommendRestaurantRv: RecyclerView = helper.getView(R.id.rv_recommend_shop_container)
                    recommendRestaurantAdapter = HRecommendChildAdapter(item, mContext)
                    recommendRestaurantRv.layoutManager = mLayoutManager
                    recommendRestaurantRv.addItemDecoration(SpacesItemDecoration(42))
                    recommendRestaurantRv.adapter = recommendRestaurantAdapter
                }
            }

            HRecommendMultiItemEntity.FLASH_SAlE -> {
                val bigTitleStr = item.arr_index_flash_sale_list.arr_title_data.string_positive_title
                val subTittleStr = item.arr_index_flash_sale_list.arr_title_data.sting_negative_title
                setItemTitleText(helper!!.getView(R.id.tv_flash_sale_name), bigTitleStr, helper.getView(R.id.tv_flash_sale_subtitle), subTittleStr)
                if (flashSaleAdapter == null) {
                    val flashSaleRv: RecyclerView = helper.getView(R.id.rv_flash_sale_container)
                    flashSaleAdapter = HRecommendChildAdapter(item, mContext)
                    flashSaleRv.layoutManager = verticalManager
                    flashSaleRv.adapter = flashSaleAdapter
                }

            }


        }
    }

    /**
     * TODO: 设置ItemTitle和TypeFace
     * @param bigTitleTv TextView
     * @param bigTitleStr String
     * @param subTitleTv TextView
     * @param subTittleStr String
     */
    private fun setItemTitleText(bigTitleTv: TextView, bigTitleStr: String, subTitleTv: TextView, subTittleStr: String) {
        bigTitleTv.text = bigTitleStr
        subTitleTv.text = subTittleStr
        bigTitleTv.typeface = typeFaceMedium
        subTitleTv.typeface = typeFaceLight
    }

}


