package com.haife.app.nobles.spirits.kotlin.mvp.ui.activity

import android.content.Intent
import android.os.Bundle
import com.haife.app.nobles.spirits.kotlin.R
import com.haife.app.nobles.spirits.kotlin.di.component.DaggerRestaurantComponent
import com.haife.app.nobles.spirits.kotlin.di.module.RestaurantModule
import com.haife.app.nobles.spirits.kotlin.mvp.contract.RestaurantContract
import com.haife.app.nobles.spirits.kotlin.mvp.presenter.RestaurantPresenter
import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils


/**
 * @author Eddie Android Developer
 * @company Q | 樽尚汇
 * @since 2019/1/24
 * 商户详情
 */
class RestaurantActivity : BaseActivity<RestaurantPresenter>(), RestaurantContract.View {

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerRestaurantComponent
                .builder()
                .appComponent(appComponent)
                .restaurantModule(RestaurantModule(this))
                .build()
                .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_restaurant
    }


    override fun initData(savedInstanceState: Bundle?) {

    }


    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun showMessage(message: String) {
        ArmsUtils.snackbarText(message)
    }

    override fun launchActivity(intent: Intent) {
        ArmsUtils.startActivity(intent)
    }

    override fun killMyself() {
        finish()
    }
}
