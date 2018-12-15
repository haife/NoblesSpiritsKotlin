package com.haife.app.nobles.spirits.kotlin.mvp.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.haife.app.nobles.spirits.kotlin.R
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx

class MainActivity : AppCompatActivity() {
    private var mBottommNavigation: BottomNavigationViewEx? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mBottommNavigation = findViewById(R.id.bnve_main_bottom_navigation)
        mBottommNavigation!!.enableAnimation(false)
        mBottommNavigation!!.enableShiftingMode(false)
        mBottommNavigation!!.enableItemShiftingMode(false)
        mBottommNavigation!!.setOnNavigationItemSelectedListener {
            true
        }
    }
}
