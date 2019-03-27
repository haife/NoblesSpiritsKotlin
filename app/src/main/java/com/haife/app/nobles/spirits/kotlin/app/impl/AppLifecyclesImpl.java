package com.haife.app.nobles.spirits.kotlin.app.impl;

import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;
import android.location.LocationManager;

import com.alibaba.android.arouter.launcher.ARouter;
import com.haife.app.nobles.spirits.kotlin.BuildConfig;
import com.jess.arms.base.delegate.AppLifecycles;
import com.jess.arms.utils.ArmsUtils;
import com.qmuiteam.qmui.arch.QMUISwipeBackActivityManager;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import java.lang.reflect.Field;

import me.jessyan.autosize.AutoSizeConfig;
import me.jessyan.autosize.unit.Subunits;
import me.yokeyword.fragmentation.Fragmentation;
import timber.log.Timber;

import static me.jessyan.autosize.utils.LogUtils.isDebug;

public class AppLifecyclesImpl implements AppLifecycles {
    private RefWatcher mRefWatcher;
    private LocationManager mLocationManager;

    @Override
    public void attachBaseContext(Context base) {
//      MultiDex.install(base);  //这里比 onCreate 先执行,常用于 MultiDex 初始化,插件化框架的初始化

    }

    @Override
    public void onCreate(Application application) {
        initTimber();
        initTextFaceType(application);
        initLeakCanary(application);
        //qmui arch 初始化
        QMUISwipeBackActivityManager.init(application);
        //AutoSize
        AutoSizeConfig.getInstance().getUnitsManager().setSupportDP(true).setSupportSubunits(Subunits.PT);
        /*-----ARouterSDK初始化Start-----*/
        if (isDebug()) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(application); // 尽可能早，推荐在Application中初始化
        /*---------ARouterSDK初始化End-----------*/

        Fragmentation.builder()
                // 设置 栈视图 模式为 悬浮球模式   SHAKE: 摇一摇唤出   NONE：隐藏
                .stackViewMode(Fragmentation.BUBBLE)
                .debug(BuildConfig.DEBUG)
                // 在遇到After onSaveInstanceState时，不会抛出异常，会回调到下面的ExceptionHandler
                .handleException(e -> {
                    // 建议在该回调处上传至我们的Crash监测服务器
                    // 以Bugtags为例子: 手动把捕获到的 Exception 传到 Bugtags 后台。
                    // Bugtags.sendException(e);
                })
                .install();


    }


    private void initLeakCanary(Application application) {
        //LeakCanary 内存泄露检查
        //使用 IntelligentCache.KEY_KEEP 作为 key 的前缀, 可以使储存的数据永久存储在内存中
        //否则存储在 LRU 算法的存储空间中, 前提是 extras 使用的是 IntelligentCache (框架默认使用)
        mRefWatcher = BuildConfig.USE_CANARY ? LeakCanary.install(application) : RefWatcher.DISABLED;
        ArmsUtils.obtainAppComponentFromContext(application).extras().put(RefWatcher.class.getName(), mRefWatcher);
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

    /**
     * 配置全局字体
     */
    private void initTextFaceType(Application application) {
        Typeface typeface = Typeface.createFromAsset(application.getAssets(), "PingFangSC-Regular.ttf");
        try {
            Field field = Typeface.class.getDeclaredField("MONOSPACE");
            field.setAccessible(true);
            field.set(null, typeface);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


}
