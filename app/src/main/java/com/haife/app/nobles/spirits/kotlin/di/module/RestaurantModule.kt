package com.haife.app.nobles.spirits.kotlin.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.haife.app.nobles.spirits.kotlin.mvp.contract.RestaurantContract
import com.haife.app.nobles.spirits.kotlin.mvp.model.RestaurantModel


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
@Module
//构建RestaurantModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class RestaurantModule(private val view: RestaurantContract.View) {
    @ActivityScope
    @Provides
    fun provideRestaurantView(): RestaurantContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideRestaurantModel(model: RestaurantModel): RestaurantContract.Model {
        return model
    }
}
