package com.haife.app.nobles.spirits.kotlin.app.base

import android.content.Context
import android.graphics.Typeface
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.haife.app.nobles.spirits.kotlin.BuildConfig
import com.haife.app.nobles.spirits.kotlin.mvp.ui.utlis.DiskCacheStrategyType
import com.jess.arms.http.imageloader.ImageLoader
import com.jess.arms.http.imageloader.glide.ImageConfigImpl
import com.jess.arms.utils.ArmsUtils


/**
 * @author Eddie Android Developer
 * @company Q | 樽尚汇
 * @since 2019/1/22
 * 联盟餐厅列表适配器
 */
open class BaseQuickRecycleAdapter<T>(layoutId: Int, data: List<T>, val context: Context) : BaseQuickAdapter<T, BaseViewHolder>(layoutId, data) {

    val typeFaceBold: Typeface = Typeface.createFromAsset(context.assets, "PingFangSC-Medium-Bold.ttf")
    val typeFaceTint: Typeface = Typeface.createFromAsset(context.assets, "PingFangSC-Light-Face-Medium-Tint.ttf")
    private var imageLoader: ImageLoader? = ArmsUtils.obtainAppComponentFromContext(context).imageLoader()

    override fun convert(helper: BaseViewHolder, item: T) {

    }

    /**
     * 加载图片
     * @param intoIv ImageView
     * @param drawableRes Int
     * @param imageUrl String
     */
    fun loadImage(intoIv: ImageView, drawableRes: Int, imageUrl: String, isRadius: Boolean = false) {
        imageLoader?.loadImage(context, ImageConfigImpl.builder().url(BuildConfig.API_HOST + imageUrl)
                .imageRadius(if (isRadius) 4 else 0)
                .cacheStrategy(DiskCacheStrategyType.All).imageView(intoIv)
                .isCenterCrop(true)
                .placeholder(drawableRes).build())
    }

    fun releaseAllHolder(recyclerView: RecyclerView?) {
        recyclerView?.let {
            for (count: Int in it.childCount..0 step -1) {
                val view: View = it.getChildAt(count)
                val viewHolder: RecyclerView.ViewHolder = recyclerView.getChildViewHolder(view)
                if (view != null && viewHolder is RecyclerView.ViewHolder) {
                    (viewHolder as BaseHolder).onRelease()
                }
            }
        }
    }




}

