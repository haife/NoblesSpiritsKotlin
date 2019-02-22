package com.haife.app.nobles.spirits.kotlin.mvp.ui.adapter

import android.content.Context
import android.graphics.Typeface
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.haife.app.nobles.spirits.kotlin.BuildConfig
import com.haife.app.nobles.spirits.kotlin.R
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.multi.HRecommendMultiItemEntity
import com.haife.app.nobles.spirits.kotlin.mvp.ui.decoration.HorizontalSpacesItemDecoration
import com.haife.app.nobles.spirits.kotlin.mvp.ui.decoration.RecycleViewDivide
import com.haife.app.nobles.spirits.kotlin.mvp.ui.helper.FixLinearSnapHelper
import com.haife.app.nobles.spirits.kotlin.mvp.ui.loader.BannerImageLoader
import com.youth.banner.Banner


/**
 * @ author haife
 * @ since 2019/1/2
 * TODO 首页推荐列表适配器
 */

class HRecommendAdapter(data: MutableList<HRecommendMultiItemEntity>?, val context: Context) : BaseMultiItemQuickAdapter<HRecommendMultiItemEntity, BaseViewHolder>(data) {
    private val typeFaceMedium = Typeface.createFromAsset(context.assets, "PingFangSC-Medium-Bold.ttf")
    private val typeFaceLight = Typeface.createFromAsset(context.assets, "PingFangSC-Light-Face.ttf")
    private val bannerUrls: ArrayList<String> = arrayListOf()
    private var recommendRestaurantAdapter: HRecommendChildAdapter? = null
    private var newRecommendRestaurantAdapter: HRecommendChildAdapter? = null
    private var enjoyLifeAdapter: HRecommendChildAdapter? = null
    private var flashSaleAdapter: HRecommendChildAdapter? = null
    private var weeklySpecialAdapter: HRecommendChildAdapter? = null
    private var groupBuyAdapter: HRecommendChildAdapter? = null
    //RecycleView线程池
    private val shareRecycledViewPool: RecyclerView.RecycledViewPool = RecyclerView.RecycledViewPool()

    init {
        addItemType(HRecommendMultiItemEntity.BANNER_TYPE, R.layout.recycle_item_home_recommend_banner)
        addItemType(HRecommendMultiItemEntity.RECOMMEND_RESTAURANT, R.layout.recycle_item_home_recommend_restaurant)
        addItemType(HRecommendMultiItemEntity.FLASH_SAlE, R.layout.recycle_item_home_flash_sale)
        addItemType(HRecommendMultiItemEntity.WEEK_PREFERENTIAL, R.layout.recycle_item_home_recommend_restaurant)
        addItemType(HRecommendMultiItemEntity.GROUP_BUY_ACTIVITY, R.layout.recycle_item_home_group_buy)
        addItemType(HRecommendMultiItemEntity.NEW_RECOMMEND_RESTAURANT, R.layout.recycle_item_home_recommend_restaurant)
        addItemType(HRecommendMultiItemEntity.TASTE_OF_LIFE, R.layout.recycle_item_home_recommend_restaurant)
        addItemType(HRecommendMultiItemEntity.NUll_TYPE, R.layout.recycle_item_home_no_type)
    }


    override fun convert(helper: BaseViewHolder, item: HRecommendMultiItemEntity) {
        when (item.itemType) {
            HRecommendMultiItemEntity.BANNER_TYPE -> {
                item.bannerData.forEach { if (bannerUrls.size == 0) bannerUrls.add(BuildConfig.API_HOST + it.string_pic_url) else return@forEach }
                var banner: Banner = helper.getView(R.id.banner_home_recommend)
                banner.setImages(bannerUrls)
                banner.startAutoPlay()
                banner.setImageLoader(BannerImageLoader())
                banner.start()
            }
            HRecommendMultiItemEntity.RECOMMEND_RESTAURANT -> {
                setItemTitleText(helper, item)
                if (recommendRestaurantAdapter == null) {
                    recommendRestaurantAdapter = HRecommendChildAdapter(item, mContext)
                    setItemAdapter(helper, recommendRestaurantAdapter, HRecommendMultiItemEntity.RECOMMEND_RESTAURANT)
                }
            }
            HRecommendMultiItemEntity.NEW_RECOMMEND_RESTAURANT -> {
                setItemTitleText(helper, item)
                if (newRecommendRestaurantAdapter == null) {
                    newRecommendRestaurantAdapter = HRecommendChildAdapter(item, mContext)
                    setItemAdapter(helper, newRecommendRestaurantAdapter, HRecommendMultiItemEntity.NEW_RECOMMEND_RESTAURANT)
                }
            }
            HRecommendMultiItemEntity.TASTE_OF_LIFE -> {
                setItemTitleText(helper, item)
                if (enjoyLifeAdapter == null) {
                    enjoyLifeAdapter = HRecommendChildAdapter(item, mContext)
                    setItemAdapter(helper, enjoyLifeAdapter, HRecommendMultiItemEntity.TASTE_OF_LIFE)
                }
            }

            HRecommendMultiItemEntity.WEEK_PREFERENTIAL -> {
                setItemTitleText(helper, item)
                if (weeklySpecialAdapter == null) {
                    weeklySpecialAdapter = HRecommendChildAdapter(item, mContext)
                    setItemAdapter(helper, weeklySpecialAdapter, HRecommendMultiItemEntity.WEEK_PREFERENTIAL)
                }
            }
            HRecommendMultiItemEntity.GROUP_BUY_ACTIVITY -> {
                setItemTitleText(helper, item)
                if (groupBuyAdapter == null) {
                    groupBuyAdapter = HRecommendChildAdapter(item, mContext)
                    setGroupFlashItemAdapter(helper, groupBuyAdapter)
                }
            }

            HRecommendMultiItemEntity.FLASH_SAlE -> {
                setItemTitleText(helper, item)
                if (flashSaleAdapter == null) {
                    flashSaleAdapter = HRecommendChildAdapter(item, mContext)
                    setGroupFlashItemAdapter(helper, flashSaleAdapter)
                }
            }
        }
    }

    /**
     * 添加横向滚动适配器方法
     * @param helper BaseViewHolder
     * @param adapter HRecommendChildAdapter?
     * @param itemType Int
     */
    private fun setItemAdapter(helper: BaseViewHolder, adapter: HRecommendChildAdapter?, itemType: Int) {
        val recommendRestaurantRv: RecyclerView = helper.getView(R.id.rv_recommend_parent_container)
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        //TODO 横向嵌套RecyclerView滑动数据预加载 注意只适合横向嵌套
        linearLayoutManager.initialPrefetchItemCount = 5
        //TODO:Item的高度是固定的，设置这个选项可以提高性能.总得来说就是就是避免整个布局绘制。就是避免requestLayout.
        recommendRestaurantRv.setHasFixedSize(true)
        //TODO: 复用RecycledViewPool
        recommendRestaurantRv.setRecycledViewPool(shareRecycledViewPool)

        recommendRestaurantRv.layoutManager = linearLayoutManager
        recommendRestaurantRv.adapter = adapter

        recommendRestaurantRv.addItemDecoration(HorizontalSpacesItemDecoration(42))
        //横向滚动滑动定位
        when (itemType) {
            HRecommendMultiItemEntity.TASTE_OF_LIFE -> PagerSnapHelper().attachToRecyclerView(recommendRestaurantRv)
            else -> FixLinearSnapHelper().attachToRecyclerView(recommendRestaurantRv)
        }
    }

    /**
     *  配置团购和限时抢购的适配器
     * @param helper BaseViewHolder
     * @param adapter HRecommendChildAdapter?
     */
    private fun setGroupFlashItemAdapter(helper: BaseViewHolder, adapter: HRecommendChildAdapter?) {
        var groupBuyRV = helper.getView<RecyclerView>(R.id.rv_group_buy_container)
        //TODO:Item的高度是固定的，设置这个选项可以提高性能.总得来说就是就是避免整个布局绘制。就是避免requestLayout.
        groupBuyRV.setHasFixedSize(true)
        //TODO: 复用RecycledViewPool
        groupBuyRV.setRecycledViewPool(shareRecycledViewPool)
        groupBuyRV.layoutManager = LinearLayoutManager(context)
        groupBuyRV.adapter = adapter
        groupBuyRV.addItemDecoration(RecycleViewDivide(mContext, divideColor = ContextCompat.getColor(mContext, R.color.write)))
    }


    /**
     * TODO: 设置ItemTitle和TypeFace
     * @param helper BaseViewHolder
     * @param itemEntity HRecommendMultiItemEntity
     */
    private fun setItemTitleText(helper: BaseViewHolder, itemEntity: HRecommendMultiItemEntity) {
        lateinit var bigTitleTv: TextView
        lateinit var subTitleTv: TextView
        lateinit var itemSizeTv: TextView
        when (itemEntity.itemType) {
            HRecommendMultiItemEntity.GROUP_BUY_ACTIVITY -> {
                bigTitleTv = helper.getView(R.id.tv_group_buy_name)
                subTitleTv = helper.getView(R.id.tv_group_buy_subtitle)
            }
            else -> {
                bigTitleTv = helper.getView(R.id.tv_recommend_big_title_name)
                subTitleTv = helper.getView(R.id.tv_recommend_subtitle)
                itemSizeTv = helper.getView(R.id.tv_recommend_shop_number)
                itemSizeTv.text = itemEntity.arr_data.size.toString()
            }

        }
        bigTitleTv.text = itemEntity.arr_title_data.string_positive_title
        subTitleTv.text = itemEntity.arr_title_data.sting_negative_title
        bigTitleTv.typeface = typeFaceMedium
        subTitleTv.typeface = typeFaceLight
    }

    /**
     * 释放资源 防止内存泄露
     */
    fun onDestroy() {
        recommendRestaurantAdapter?.onRelease()
        recommendRestaurantAdapter = null
        newRecommendRestaurantAdapter = null
        enjoyLifeAdapter = null
        groupBuyAdapter = null
        flashSaleAdapter = null
        shareRecycledViewPool.clear()
    }




}


