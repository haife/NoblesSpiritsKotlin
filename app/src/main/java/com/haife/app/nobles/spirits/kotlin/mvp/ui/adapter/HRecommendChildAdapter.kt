package com.haife.app.nobles.spirits.kotlin.mvp.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.haife.app.nobles.spirits.kotlin.R
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.multi.HRecommendMultiItemEntity

/**
 * @ author haife
 * @ since 2019/1/4
 * TODO：首页列表Item布局适配器
 */

class HRecommendChildAdapter(val list: HRecommendMultiItemEntity, val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    private val mDataList = list
    private val mViewType = list.itemType

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =

            when (viewType) {
                HRecommendMultiItemEntity.RECOMMEND_RESTAURANT -> {
                    val itemView: View = LayoutInflater.from(context).inflate(R.layout.activity_main, parent,false)
                    RecommendRestaurantViewHolder(itemView)
                }


                else -> throw NullPointerException()
            }


    override fun getItemCount(): Int = when (mViewType) {

        HRecommendMultiItemEntity.RECOMMEND_RESTAURANT -> mDataList.arr_index_recommend_shop.arr_data.size

        else -> 0
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    override fun getItemViewType(position: Int): Int {
        return mViewType
    }

    inner class RecommendRestaurantViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    }


}