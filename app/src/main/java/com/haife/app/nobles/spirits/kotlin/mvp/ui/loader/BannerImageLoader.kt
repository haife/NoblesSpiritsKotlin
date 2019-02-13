package com.haife.app.nobles.spirits.kotlin.mvp.ui.loader

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.haife.app.nobles.spirits.kotlin.BuildConfig
import com.haife.app.nobles.spirits.kotlin.mvp.ui.utlis.DiskCacheStrategyType
import com.jess.arms.http.imageloader.glide.GlideArms
import com.jess.arms.http.imageloader.glide.ImageConfigImpl
import com.jess.arms.utils.ArmsUtils
import com.youth.banner.loader.ImageLoader
import com.jess.arms.http.imageloader.ImageLoader as Load

/**
 * @ author haife
 * @ since 2019/1/7
 * TODO：
 */
class BannerImageLoader : ImageLoader() {

    override fun displayImage(context: Context?, path: Any?, imageView: ImageView?) {
        if (imageView != null) {
            GlideArms.with(context!!.applicationContext)
                    .load(path)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imageView)
        }

    }


}


private lateinit var imageLoader: Load
private val builder: ImageConfigImpl.Builder = ImageConfigImpl.builder()

/**
 * 加载图片
 * @param intoIv ImageView
 * @param imageUrl String
 */
fun ImageView.loadImageWithBaseUrl(context: Context, intoIv: ImageView, imageUrl: String, isRadius: Boolean = false) {
    imageLoader = ArmsUtils.obtainAppComponentFromContext(context).imageLoader()
    if (isRadius) {
        builder.imageRadius(5)
    }
    imageLoader.loadImage(context, builder.url(BuildConfig.API_HOST + imageUrl)
            .cacheStrategy(DiskCacheStrategyType.All).imageView(intoIv)
            .isCenterCrop(true)
            .build())
}