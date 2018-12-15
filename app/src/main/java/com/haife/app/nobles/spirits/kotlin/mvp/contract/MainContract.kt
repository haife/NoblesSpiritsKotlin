package com.haife.app.nobles.spirits.kotlin.mvp.contract

import android.app.Activity
import com.jess.arms.mvp.IModel
import com.jess.arms.mvp.IView

interface MainContract {
    interface View : IView {
        fun getActivity(): Activity
    }
    interface Model : IModel{

    }
}