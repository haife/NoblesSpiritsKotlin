package com.haife.app.nobles.spirits.kotlin.mvp.ui.adapter

import android.view.View
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.haife.app.nobles.spirits.kotlin.R
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.multi.HRecommendMultiItemEntity

/**
 * @ author haife
 * @ since 2019/1/2
 * TODO：
 */
class HRecommendAdapter(data: MutableList<HRecommendMultiItemEntity>?) : BaseMultiItemQuickAdapter<HRecommendMultiItemEntity, BaseViewHolder>(data) {

    init {
        addItemType(HRecommendMultiItemEntity.BANNER_TYPE, R.layout.recycle_item_home_recommend_banner)
        addItemType(HRecommendMultiItemEntity.RECOMMAND_RESTAURANT, R.layout.recycle_item_home_recommend_restaurant)
    }

    override fun convert(helper: BaseViewHolder?, item: HRecommendMultiItemEntity?) {
        when (item?.TypeItem) {
            HRecommendMultiItemEntity.BANNER_TYPE -> {
                var banner = helper?.getView<View>(R.id.banner_home_recommend)
            }

            HRecommendMultiItemEntity.RECOMMAND_RESTAURANT -> {

            }
        }
    }
}