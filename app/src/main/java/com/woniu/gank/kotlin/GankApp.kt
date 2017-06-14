package com.woniu.gank.kotlin

import android.app.Application
import com.woniu.gank.kotlin.di.AppComponent
import com.woniu.gank.kotlin.di.AppModule
import com.woniu.gank.kotlin.di.DaggerAppComponent
import kotlin.properties.Delegates

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

    //使用kotlin的委托属性特性，讲GankApp做一个全局非空的单例化context
    companion object {
        //委托特性详解参见：http://www.tuicool.com/articles/AVNNNfF
        var instance: GankApp by Delegates.notNull<GankApp>()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this;
    }

}