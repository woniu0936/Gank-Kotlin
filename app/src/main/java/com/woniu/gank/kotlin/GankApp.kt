package com.woniu.gank.kotlin

import android.app.Application
import com.woniu.gank.kotlin.di.AppComponent
import com.woniu.gank.kotlin.di.AppModule
import com.woniu.gank.kotlin.di.DaggerAppComponent

/**
 * @author woniu
 * @title GankApp
 * @description
 * @modifier
 * @date
 * @since 2017/6/6 下午9:23
 */
class GankApp : Application() {

    //常量延迟加载（线程安全）
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
    }

}