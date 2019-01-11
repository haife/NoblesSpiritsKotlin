package com.haife.app.nobles.spirits.kotlin.mvp.ui.adapter

import android.content.Context
import android.graphics.Typeface
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.haife.app.nobles.spirits.kotlin.BuildConfig
import com.haife.app.nobles.spirits.kotlin.R
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.multi.HRecommendMultiItemEntity
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.result.HomeRecommendData
import com.haife.app.nobles.spirits.kotlin.mvp.ui.utlis.DiskCacheStrategyType
import com.jess.arms.http.imageloader.ImageLoader
import com.jess.arms.http.imageloader.glide.ImageConfigImpl
import com.jess.arms.utils.ArmsUtils
import com.makeramen.roundedimageview.RoundedImageView

/**
 * @ author haife
 * @ since 2019/1/4
 * TODO：首页列表Item布局适配器
 */

class HRecommendChildAdapter(val list: HRecommendMultiItemEntity, val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val mViewType = list.itemType
    private var imageLoader: ImageLoader = ArmsUtils.obtainAppComponentFromContext(context).imageLoader()
    private var layoutInflater: LayoutInflater = LayoutInflater.from(context)
    var typeFaceMedium: Typeface = Typeface.createFromAsset(context.assets, "PingFangSC-Medium-Bold.ttf")


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
            when (viewType) {
                HRecommendMultiItemEntity.RECOMMEND_RESTAURANT -> {
                    val itemView: View = layoutInflater.inflate(R.layout.recycle_item_home_recommend_restaurant_child, null)
                    RecommendRestaurantViewHolder(itemView)

                }


                else -> throw NullPointerException()
            }


    override fun getItemCount(): Int = when (mViewType) {
        HRecommendMultiItemEntity.RECOMMEND_RESTAURANT -> list.arr_index_recommend_shop.arr_data.size
        else -> 0
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is RecommendRestaurantViewHolder -> {
                bindRecommendRestaurantViewHolder(holder, position)
            }
        }
    }

    /**
     * bind推荐门店
     * @param holder HRecommendChildAdapter.RecommendRestaurantViewHolder
     * @param position Int
     */
    private fun bindRecommendRestaurantViewHolder(holder: HRecommendChildAdapter.RecommendRestaurantViewHolder, position: Int) {
        val recommendRestaurantItemEntity: HomeRecommendData.ArrIndexRecommendShopBean.ArrRecommendShopBean = list.arr_index_recommend_shop.arr_data[position]
        holder.restaurantNameTv.text = recommendRestaurantItemEntity.string_title
        imageLoader.loadImage(context, ImageConfigImpl.builder().url(BuildConfig.API_HOST + recommendRestaurantItemEntity.sting_pic_url).imageRadius(5)
                .cacheStrategy(DiskCacheStrategyType.All).imageView(holder.restaurantRIV)
                .isCenterCrop(true)
                .placeholder(R.drawable.ic_home_banner_place_holder).build())


    }


    override fun getItemViewType(position: Int): Int {
        return mViewType
    }


    inner class RecommendRestaurantViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        val restaurantRIV: RoundedImageView = itemView!!.findViewById<RoundedImageView>(R.id.riv_recommend_restaurant_child)
        val restaurantNameTv: TextView = itemView!!.findViewById<TextView>(R.id.tv_recommend_restaurant_child_name)

        init {
            restaurantNameTv.typeface = typeFaceMedium;
        }
    }

}

