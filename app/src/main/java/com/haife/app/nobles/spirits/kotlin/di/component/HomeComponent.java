package com.haife.app.nobles.spirits.kotlin.di.component;

import com.haife.app.nobles.spirits.kotlin.di.module.HomeModule;
import com.haife.app.nobles.spirits.kotlin.mvp.ui.fragment.HRecommandFragment;
import com.haife.app.nobles.spirits.kotlin.mvp.ui.fragment.HomeFragment;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.FragmentScope;

import dagger.Component;

/**
 * @ author haife
 * @ since 2018/12/18
 * TODO：
 */
@FragmentScope
@Component(modules = HomeModule.class, dependencies = AppComponent.class)
public interface HomeComponent {
    void inject(HomeFragment fragment);
    void inject(HRecommandFragment fragment);
}
