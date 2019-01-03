package com.haife.app.nobles.spirits.kotlin.mvp.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.haife.app.nobles.spirits.kotlin.R
import com.haife.app.nobles.spirits.kotlin.di.component.DaggerHomeComponent
import com.haife.app.nobles.spirits.kotlin.di.module.HomeModule
import com.haife.app.nobles.spirits.kotlin.mvp.contract.HomeContract
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.base.Token
import com.haife.app.nobles.spirits.kotlin.mvp.presenter.HomePresenter
import com.haife.app.nobles.spirits.kotlin.mvp.ui.adapter.HRecommendAdapter
import com.jess.arms.base.BaseFragment
import com.jess.arms.di.component.AppComponent
import kotlinx.android.synthetic.main.fragment_home_recommend.*
import javax.inject.Inject


class HRecommendFragment : BaseFragment<HomePresenter>(), HomeContract.View {

    private val simpleName = javaClass.simpleName


    @Inject
    lateinit var mRecommendAdapter: HRecommendAdapter


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
        val token = Token()
        mPresenter?.getHomeRecommendData(token, simpleName)
        rv_home_recommend.layoutManager = LinearLayoutManager(context)
        rv_home_recommend.adapter = mRecommendAdapter
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


}
