package com.haife.app.nobles.spirits.kotlin.mvp.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.haife.app.nobles.spirits.kotlin.R
import com.haife.app.nobles.spirits.kotlin.mvp.contract.HomeContract
import com.haife.app.nobles.spirits.kotlin.mvp.http.entity.multi.HRecommandMultiItemEntity
import com.haife.app.nobles.spirits.kotlin.mvp.presenter.HomePresenter
import com.haife.app.nobles.spirits.kotlin.mvp.ui.adapter.HRecommandAdapter
import com.jess.arms.base.BaseFragment
import com.jess.arms.di.component.AppComponent
import kotlinx.android.synthetic.main.fragment_home_recommand.*
import javax.inject.Inject


class HRecommandFragment : BaseFragment<HomePresenter>(), HomeContract.View {
    @Inject
    val mRecommandAdapter: HRecommandAdapter? = null

    override fun processRecommandUiData(homeRecommandData: List<HRecommandMultiItemEntity>?) {

    }

    companion object {
        fun newInstance(): HRecommandFragment {
            val bundle: Bundle = Bundle()
            val hRecommandFragment = HRecommandFragment()
            hRecommandFragment.arguments = bundle
            return hRecommandFragment
        }
    }

    override fun setupFragmentComponent(appComponent: AppComponent) {

    }

    override fun setData(data: Any?) {
        rv_home_recommand.layoutManager = LinearLayoutManager(context)
        rv_home_recommand.adapter = mRecommandAdapter
    }

    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return LayoutInflater.from(context).inflate(R.layout.fragment_home_recommand, container, false)
    }


    override fun initData(savedInstanceState: Bundle?) {

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
