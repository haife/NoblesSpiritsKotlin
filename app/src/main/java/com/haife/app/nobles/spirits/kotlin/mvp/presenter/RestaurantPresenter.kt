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


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 01/23/2019 16:04
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
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