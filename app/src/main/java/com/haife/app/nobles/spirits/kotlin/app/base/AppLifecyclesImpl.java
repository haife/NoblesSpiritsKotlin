package com.haife.app.nobles.spirits.kotlin.app.base;

import android.app.Application;
import android.content.Context;

import com.haife.app.nobles.spirits.kotlin.BuildConfig;
import com.jess.arms.base.delegate.AppLifecycles;
import com.jess.arms.utils.ArmsUtils;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import me.jessyan.autosize.AutoSizeConfig;
import me.jessyan.autosize.unit.Subunits;
import timber.log.Timber;

public class AppLifecyclesImpl implements AppLifecycles {

    private RefWatcher mRefWatcher;

    @Override
    public void attachBaseContext(Context base) {
//      MultiDex.install(base);  //这里比 onCreate 先执行,常用于 MultiDex 初始化,插件化框架的初始化
    }

    @Override
    public void onCreate(Application application) {
        initTimber();
        initLeakCanary(application);
        AutoSizeConfig.getInstance().getUnitsManager()
                .setSupportDP(true)
                .setSupportSubunits(Subunits.PT);
    }



    private void initLeakCanary(Application application) {
        //leakCanary内存泄露检查
        mRefWatcher = BuildConfig.USE_CANARY ? LeakCanary.install(application) : RefWatcher.DISABLED;
        ArmsUtils.obtainAppComponentFromContext(application)
                .extras().put(RefWatcher.class.getName(), mRefWatcher);
    }

    private void initTimber() {
        if (BuildConfig.LOG_DEBUG) {
            //Timber日志打印
            Timber.plant(new Timber.DebugTree());
        }
    }

    @Override
    public void onTerminate(Application application) {
        mRefWatcher = null;
    }
}
