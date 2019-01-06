package com.haife.app.nobles.spirits.kotlin.mvp.ui.adapter

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.haife.app.nobles.spirits.kotlin.R
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.multi.HRecommendMultiItemEntity


/**
 * @ author haife
 * @ since 2019/1/2
 * TODO 首页推荐列表适配器
 */

class HRecommendAdapter(data: MutableList<HRecommendMultiItemEntity>?) : BaseMultiItemQuickAdapter<HRecommendMultiItemEntity, BaseViewHolder>(data) {

    private var mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(mContext)

    init {
        addItemType(HRecommendMultiItemEntity.BANNER_TYPE, R.layout.recycle_item_home_recommend_banner)
        addItemType(HRecommendMultiItemEntity.RECOMMEND_RESTAURANT, R.layout.recycle_item_home_recommend_restaurant)
    }

    override fun convert(helper: BaseViewHolder?, item: HRecommendMultiItemEntity?) {
        when (item?.TypeItem) {
            HRecommendMultiItemEntity.BANNER_TYPE -> {
                var banner = helper?.getView<View>(R.id.banner_home_recommend)

            }

            HRecommendMultiItemEntity.RECOMMEND_RESTAURANT -> {
                var bigTitleStr = item.arr_index_recommend_shop.arr_title_data.string_positive_title
                val subTittleStr = item.arr_index_recommend_shop.arr_title_data.sting_negative_title
                helper?.setText(R.id.tv_recommend_shop_name, bigTitleStr)
                helper?.setText(R.id.tv_recommend_shop_subtitle, subTittleStr)
                val recommendRestaurantRv: RecyclerView = helper!!.getView(R.id.rv_recommend_shop_container)
                val recommendRestaurantAdapter = HRecommendChildAdapter(item, mContext)
                recommendRestaurantRv.layoutManager = mLayoutManager
                recommendRestaurantRv.adapter = recommendRestaurantAdapter

            }
        }
    }


}