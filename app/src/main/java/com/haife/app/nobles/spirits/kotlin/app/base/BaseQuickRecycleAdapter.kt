package com.haife.app.nobles.spirits.kotlin.app.base

import android.content.Context
import android.graphics.Typeface
import android.widget.ImageView
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
    private val imageLoader: ImageLoader = ArmsUtils.obtainAppComponentFromContext(context).imageLoader()
    private val builder: ImageConfigImpl.Builder = ImageConfigImpl.builder()

    override fun convert(helper: BaseViewHolder, item: T) {

    }

    /**
     * 加载图片
     * @param intoIv ImageView
     * @param drawableRes Int
     * @param imageUrl String
     */
    fun loadImage(intoIv: ImageView, drawableRes: Int, imageUrl: String, isRadius: Boolean = false) {
        if (isRadius) {
            builder.imageRadius(5)
        }
        imageLoader.loadImage(context, builder.url(BuildConfig.API_HOST + imageUrl)
                .cacheStrategy(DiskCacheStrategyType.All).imageView(intoIv)
                .isCenterCrop(true)
                .placeholder(drawableRes).build())
    }


}

