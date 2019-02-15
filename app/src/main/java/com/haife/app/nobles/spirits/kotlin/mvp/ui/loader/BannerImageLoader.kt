package com.haife.app.nobles.spirits.kotlin.mvp.ui.loader

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.jess.arms.http.imageloader.glide.GlideArms
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

