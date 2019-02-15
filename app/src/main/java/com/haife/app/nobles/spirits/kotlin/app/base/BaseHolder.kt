package com.haife.app.nobles.spirits.kotlin.app.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * @author Eddie Android Developer
 * @company Q | 樽尚汇
 * @since 2019/2/15$
 * TODO: BaseHolder
 */
abstract class BaseHolder(val view: View): RecyclerView.ViewHolder(view) {

    abstract fun onRelease()
}