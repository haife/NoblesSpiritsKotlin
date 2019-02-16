package com.haife.app.nobles.spirits.kotlin.mvp.ui.activity

import android.content.Intent
import android.os.Bundle
import android.transition.TransitionInflater
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.haife.app.nobles.spirits.kotlin.R
import com.haife.app.nobles.spirits.kotlin.app.base.BaseSwipeBackActivity
import com.haife.app.nobles.spirits.kotlin.di.component.DaggerRestaurantComponent
import com.haife.app.nobles.spirits.kotlin.di.module.RestaurantModule
import com.haife.app.nobles.spirits.kotlin.mvp.contract.RestaurantContract
import com.haife.app.nobles.spirits.kotlin.mvp.http.router.restaurantActivityRouterUrl
import com.haife.app.nobles.spirits.kotlin.mvp.presenter.RestaurantPresenter
import com.haife.app.nobles.spirits.kotlin.mvp.ui.fragment.HUnionRestaurantFragment
import com.jess.arms.di.component.AppComponent
import me.yokeyword.fragmentation.anim.FragmentAnimator


/**
 * @author Eddie Android Developer
 * @company Q | 樽尚汇
 * @since 2019/1/24
 * Merchant Detail Screen
 */
@Route(path = restaurantActivityRouterUrl)
class RestaurantActivity : BaseSwipeBackActivity<RestaurantPresenter>(), RestaurantContract.View {


    // 门店Id
    @Autowired(name = HUnionRestaurantFragment.EXTRA_KEY_IMAGE_URL)
    @JvmField
    var merchantId: Int? = null

    override fun post(runnable: Runnable?) {
    }

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerRestaurantComponent
                .builder()
                .appComponent(appComponent)
                .restaurantModule(RestaurantModule(this))
                .build()
                .inject(this)
    }

    override fun initView(savedInstanceState: Bundle?): Int {
        ARouter.getInstance().inject(this)
        return R.layout.activity_restaurant
    }


    override fun initData(savedInstanceState: Bundle?) {
        window.enterTransition = TransitionInflater.from(this).inflateTransition(R.transition.merchant_activity_slide)
    }


    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun showMessage(message: String) {

    }

    override fun launchActivity(intent: Intent) {

    }

    override fun killMyself() {
        finish()
    }

    override fun onCreateFragmentAnimator(): FragmentAnimator {
        return super.onCreateFragmentAnimator()
    }



}
