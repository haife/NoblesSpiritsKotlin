package com.haife.app.nobles.spirits.kotlin.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.haife.app.nobles.spirits.kotlin.di.module.RestaurantModule

import com.jess.arms.di.scope.ActivityScope
import com.haife.app.nobles.spirits.kotlin.mvp.ui.activity.RestaurantActivity


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
@Component(modules = arrayOf(RestaurantModule::class), dependencies = arrayOf(AppComponent::class))
interface RestaurantComponent {
    fun inject(activity: RestaurantActivity)
}
