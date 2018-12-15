package com.haife.app.nobles.spirits.kotlin.di.component;

import com.haife.app.nobles.spirits.kotlin.di.module.MainModule;
import com.haife.app.nobles.spirits.kotlin.mvp.ui.activity.MainActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;

import dagger.Component;

@ActivityScope
@Component(modules = MainModule.class, dependencies = AppComponent.class)
public interface MainComponent {
    void inject(MainActivity activity);
}