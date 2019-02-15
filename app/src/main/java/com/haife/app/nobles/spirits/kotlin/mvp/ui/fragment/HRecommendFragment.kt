package com.haife.app.nobles.spirits.kotlin.mvp.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.haife.app.nobles.spirits.kotlin.R
import com.haife.app.nobles.spirits.kotlin.app.base.BaseSupportFragment
import com.haife.app.nobles.spirits.kotlin.di.component.DaggerHomeComponent
import com.haife.app.nobles.spirits.kotlin.di.module.HomeModule
import com.haife.app.nobles.spirits.kotlin.mvp.contract.HomeContract
import com.haife.app.nobles.spirits.kotlin.mvp.presenter.HomePresenter
import com.haife.app.nobles.spirits.kotlin.mvp.ui.adapter.HRecommendAdapter
import com.haife.app.nobles.spirits.kotlin.mvp.ui.decoration.RecycleViewDivide
import com.irozon.sneaker.Sneaker
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils
import com.scwang.smartrefresh.layout.api.RefreshLayout
import kotlinx.android.synthetic.main.fragment_home_recommend.*
import javax.inject.Inject


class HRecommendFragment : BaseSupportFragment<HomePresenter>(), HomeContract.View {


    private val simpleName = javaClass.simpleName
    @Inject
    lateinit var mRecommendAdapter: HRecommendAdapter
    @Inject
    lateinit var layoutManager: RecyclerView.LayoutManager

    companion object {
        fun newInstance(): HRecommendFragment {
            return HRecommendFragment()
        }
    }

    override fun setupFragmentComponent(appComponent: AppComponent) {
        DaggerHomeComponent.builder().appComponent(appComponent).homeModule(HomeModule(this)).build().inject(this)
    }

    override fun setData(data: Any?) {

    }

    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return LayoutInflater.from(context).inflate(R.layout.fragment_home_recommend, container, false)
    }


    override fun initData(savedInstanceState: Bundle?) {
        mPresenter?.getHomeRecommendData(simpleName, false)
        rv_home_recommend.layoutManager = layoutManager
        rv_home_recommend.addItemDecoration(RecycleViewDivide(context!!, drawableId = null, divideHeight = 20))
        rv_home_recommend.adapter = mRecommendAdapter
        //下拉刷新
        smart_refresh_home_recommend.setOnRefreshListener(this)
    }

    override fun showLoading() {

    }

    override fun launchActivity(intent: Intent) {
    }

    override fun hideLoading() {
    }

    override fun killMyself() {
    }

    override fun initMagicIndicatorView(magicIndicatorContentList: MutableList<String>?) {

    }

    override fun showMessage(message: String) {
    }

    override fun getFragment(): Fragment {
        return this
    }

    /**
     *
     * @param refreshLayout RefreshLayout
     * @param refreshStatus Boolean 刷新状态
     */
    override fun onRefresh(refreshLayout: RefreshLayout) {
        mPresenter?.getHomeRecommendData(simpleName, true)
    }


    override fun refreshStatusListener(refreshSuccess: Boolean) {
        smart_refresh_home_recommend?.finishRefresh(refreshSuccess)
        if (!refreshSuccess) {
            Sneaker.with(activity)
                    .setMessage(ArmsUtils.getString(context, R.string.net_work_error), ContextCompat.getColor(context!!, R.color.write))
                    .setIcon(R.drawable.ic_error, ContextCompat.getColor(context!!, R.color.write), false)
                    .sneak(R.color.flash_sale_product_original_price_color)
        }
    }


    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser) {
            rv_home_recommend?.visibility = VISIBLE
        } else {
            rv_home_recommend?.visibility = GONE
        }

    }

    override fun post(runnable: Runnable?) {
    }

    override fun onDestroy() {
        super.onDestroy()
        mRecommendAdapter.onDestroy()
    }

}
