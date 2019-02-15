package com.haife.app.nobles.spirits.kotlin.mvp.ui.widget.restaurant

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.haife.app.nobles.spirits.kotlin.R

/**
 * @author Eddie Android Developer
 * @company Q | 樽尚汇
 * @since 2019/1/27
 *
 */
class MerchantContentLayout(context: Context, attrs: AttributeSet) : ConstraintLayout(context, attrs) {


    init {
        LayoutInflater.from(context).inflate(R.layout.merchanet_content_layout, this)
    }



}