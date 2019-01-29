package com.haife.app.nobles.spirits.kotlin.mvp.ui.fragment


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.launcher.ARouter
import com.haife.app.nobles.spirits.kotlin.R
import com.haife.app.nobles.spirits.kotlin.app.base.BaseSupportFragment
import com.haife.app.nobles.spirits.kotlin.di.component.DaggerHomeComponent
import com.haife.app.nobles.spirits.kotlin.di.module.HomeModule
import com.haife.app.nobles.spirits.kotlin.mvp.contract.HomeContract
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.request.CityIdRequest
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.result.RestaurantUnionBean
import com.haife.app.nobles.spirits.kotlin.mvp.http.router.restaurantActivityRouterUrl
import com.haife.app.nobles.spirits.kotlin.mvp.presenter.HomePresenter
import com.haife.app.nobles.spirits.kotlin.mvp.ui.adapter.HUnionRestaurantAdapter
import com.haife.app.nobles.spirits.kotlin.mvp.ui.decoration.RecycleViewDivide
import com.jess.arms.di.component.AppComponent
import com.scwang.smartrefresh.layout.api.RefreshLayout
import kotlinx.android.synthetic.main.fragment_home_union_restaurant.*
import javax.inject.Inject
import javax.inject.Named


/**
 * @author Eddie Android Developer
 * @company Q | 樽尚汇
 * @since 2019/1/22
 * TODO: 联盟餐厅
 */
class HUnionRestaurantFragment : BaseSupportFragment<HomePresenter>(), HomeContract.View {


    @Inject
    lateinit var layoutManager: RecyclerView.LayoutManager
    @Inject
    lateinit var mRestaurantUnionResponse: RestaurantUnionBean
    @Inject
    lateinit var mUnionRestaurantAdapter: HUnionRestaurantAdapter

    //联盟餐厅头布局
    @Inject
    @JvmField
    @field:[Named("UnionRestaurantFilterView")]
    var unionRestaurantFilterView: View? = null

    private val requestBody: CityIdRequest = CityIdRequest()
    override fun post(runnable: Runnable?) {

    }

    companion object {
        fun newInstance(): HUnionRestaurantFragment {
            return HUnionRestaurantFragment()
        }
    }

    override fun setupFragmentComponent(appComponent: AppComponent) {
        DaggerHomeComponent.builder().appComponent(appComponent).homeModule(HomeModule(this)).build().inject(this)
    }

    override fun setData(data: Any?) {

    }

    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_home_union_restaurant, container, false)
    }


    override fun initData(savedInstanceState: Bundle?) {
        mPresenter?.getHomeUnionRestaurant(requestBody)
        rv_home_union_restaurant.addItemDecoration(RecycleViewDivide(context!!, drawableId = null, divideHeight = 20))
        rv_home_union_restaurant.hasFixedSize()
        rv_home_union_restaurant.layoutManager = layoutManager
        mUnionRestaurantAdapter.setOnItemClickListener { adapter, view, position ->
            ARouter.getInstance().build(restaurantActivityRouterUrl).navigation()
        }

    }


    override fun showLoading() {
    }

    override fun launchActivity(intent: Intent) {

    }

    override fun refreshStatusListener(refeshSuccess: Boolean) {
    }

    override fun hideLoading() {

    }

    override fun killMyself() {

    }

    override fun initMagicIndicatorView(magicIndicatorContentList: MutableList<String>?) {
    }

    override fun showMessage(message: String) {
    }

    override fun getFragment(): Fragment = this

    override fun onRefresh(refreshLayout: RefreshLayout) {

    }

    /**
     * fragment 切换回调函数
     * @param isVisibleToUser Boolean
     */
    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser) {
            rv_home_union_restaurant.adapter = mUnionRestaurantAdapter
            rv_home_union_restaurant?.visibility = VISIBLE
        } else {
            rv_home_union_restaurant?.visibility = GONE
        }

    }
}
