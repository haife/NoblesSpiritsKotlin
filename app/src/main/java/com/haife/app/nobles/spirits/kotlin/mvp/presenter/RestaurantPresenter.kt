package com.haife.app.nobles.spirits.kotlin.mvp.presenter

import android.app.Application
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import com.haife.app.nobles.spirits.kotlin.mvp.contract.RestaurantContract
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.integration.AppManager
import com.jess.arms.mvp.BasePresenter
import me.jessyan.rxerrorhandler.core.RxErrorHandler
import javax.inject.Inject


@ActivityScope
class RestaurantPresenter
@Inject
constructor(model: RestaurantContract.Model, rootView: RestaurantContract.View) : BasePresenter<RestaurantContract.Model, RestaurantContract.View>(model, rootView) {
    @Inject
    lateinit var mErrorHandler: RxErrorHandler
    @Inject
    lateinit var mApplication: Application
    @Inject
    lateinit var mAppManager: AppManager


    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        getMerchantData()
    }

    fun getMerchantData() {
    }


}
