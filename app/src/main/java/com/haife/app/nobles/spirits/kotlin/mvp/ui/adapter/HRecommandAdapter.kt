package com.haife.app.nobles.spirits.kotlin.mvp.ui.adapter

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.haife.app.nobles.spirits.kotlin.R
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.multi.HRecommandMultiItemEntity

/**
 * @ author haife
 * @ since 2019/1/2
 * TODO：
 */
class HRecommandAdapter(data: MutableList<HRecommandMultiItemEntity>?) : BaseMultiItemQuickAdapter<HRecommandMultiItemEntity, BaseViewHolder>(data) {

    init {
        addItemType(HRecommandMultiItemEntity.BANNER_TYPE, R.layout.recycle_item_home_recommand_banner)
    }
    override fun convert(helper: BaseViewHolder?, item: HRecommandMultiItemEntity?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}