package com.haife.app.nobles.spirits.kotlin.app.base;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.jess.arms.http.imageloader.BaseImageLoaderStrategy;
import com.jess.arms.http.imageloader.glide.ImageConfigImpl;

public class GlideImageLoaderStrategy implements BaseImageLoaderStrategy<ImageConfigImpl> {

    @Override
    public void loadImage(Context ctx, ImageConfigImpl config) {
        Glide.with(ctx).load(config.getUrl()).into(config.getImageView());
    }

    @Override
    public void clear(Context ctx, ImageConfigImpl config) {

    }
}
