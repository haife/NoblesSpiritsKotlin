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
/**
 * 如果没presenter
 * 你可以这样写
 *
 * @ActivityScope(請注意命名空間) class NullObjectPresenterByActivity
 * @Inject constructor() : IPresenter {
 * override fun onStart() {
 * }
 *
 * override fun onDestroy() {
 * }
 * }
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
