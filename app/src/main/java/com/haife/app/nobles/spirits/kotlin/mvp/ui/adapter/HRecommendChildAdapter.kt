package com.haife.app.nobles.spirits.kotlin.mvp.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.multi.HRecommendMultiItemEntity

/**
 * @ author haife
 * @ since 2019/1/4
 * TODO：首页列表Item布局适配器
 */

class HRecommendChildAdapter<T>(list: List<T>, viewType: Int, context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val mDataList = list
    val mViewType = viewType
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {

        }
    }

    override fun getItemCount(): Int {
        when (mViewType) {
            //HRecommendMultiItemEntity.RECOMMAND_RESTAURANT->
        }
        return mDataList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    }


}