package com.haife.app.nobles.spirits.kotlin.mvp.model

import android.app.Application
import com.haife.app.nobles.spirits.kotlin.mvp.contract.MainContract
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel
import javax.inject.Inject
import com.google.gson.Gson


@ActivityScope
class MainModel @Inject constructor(repositoryManager: IRepositoryManager?) : BaseModel(repositoryManager), MainContract.Model {
    @Inject
    var mGson: Gson? = null
    @Inject
    var mApplication: Application? = null

    override fun onDestroy() {
        super.onDestroy()
        mGson = null
        mApplication = null
    }




}