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
import me.yokeyword.fragmentation.Fragmentation;
import me.yokeyword.fragmentation.helper.ExceptionHandler;
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

        Fragmentation.builder()
                // 设置 栈视图 模式为 悬浮球模式   SHAKE: 摇一摇唤出   NONE：隐藏
                .stackViewMode(Fragmentation.BUBBLE)
                .debug(BuildConfig.DEBUG)
                // 在遇到After onSaveInstanceState时，不会抛出异常，会回调到下面的ExceptionHandler
                .handleException(new ExceptionHandler() {
                    @Override
                    public void onException(Exception e) {
                        // 建议在该回调处上传至我们的Crash监测服务器
                        // 以Bugtags为例子: 手动把捕获到的 Exception 传到 Bugtags 后台。
                        // Bugtags.sendException(e);
                    }
                })
                .install();
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
