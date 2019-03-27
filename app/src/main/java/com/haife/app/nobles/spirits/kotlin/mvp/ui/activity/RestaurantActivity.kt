package com.haife.app.nobles.spirits.kotlin.mvp.ui.activity

import android.content.Intent
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.google.android.material.appbar.AppBarLayout
import com.haife.app.nobles.spirits.kotlin.R
import com.haife.app.nobles.spirits.kotlin.app.base.BaseSwipeBackActivity
import com.haife.app.nobles.spirits.kotlin.di.component.DaggerRestaurantComponent
import com.haife.app.nobles.spirits.kotlin.di.module.RestaurantModule
import com.haife.app.nobles.spirits.kotlin.mvp.contract.RestaurantContract
import com.haife.app.nobles.spirits.kotlin.mvp.http.router.restaurantActivityRouterUrl
import com.haife.app.nobles.spirits.kotlin.mvp.presenter.RestaurantPresenter
import com.haife.app.nobles.spirits.kotlin.mvp.ui.fragment.HUnionRestaurantFragment
import com.jess.arms.di.component.AppComponent
import com.qmuiteam.qmui.util.QMUIStatusBarHelper
import kotlinx.android.synthetic.main.activity_restaurant.*


/**
 * @author Eddie Android Developer
 * @company Q | 樽尚汇
 * @since 2019/1/24
 * Merchant Detail Screen
 */
@Route(path = restaurantActivityRouterUrl)
class RestaurantActivity : BaseSwipeBackActivity<RestaurantPresenter>(), RestaurantContract.View {

    // 门店Id
    @Autowired(name = HUnionRestaurantFragment.EXTRA_KEY_MERCHANT_ID)
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
        QMUIStatusBarHelper.translucent(this)
        return R.layout.activity_restaurant
    }


    override fun initData(savedInstanceState: Bundle?) {
        topbar.addLeftBackImageButton().setOnClickListener { finishAfterTransition() }
        collapsing_topbar_layout.setScrimUpdateListener{
            animation ->
        }
        app_bar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            when {
                verticalOffset == 0 -> topbar.setTitle(null)
                Math.abs(verticalOffset) >= appBarLayout.totalScrollRange -> topbar.setTitle("商户详情")
                else -> topbar.setTitle(null)
            }
        })
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
        finishAfterTransition()
    }


}
