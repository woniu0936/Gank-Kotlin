package com.woniu.gank.kotlin.di

import com.woniu.gank.kotlin.data.DataManager
import dagger.Component
import javax.inject.Singleton

/**
 * @author woniu
 * @title AppComponent
 * @description
 * @modifier
 * @date
 * @since 2017/6/6 下午9:29
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, ClientModule::class))
interface AppComponent {

    fun getDataManager(): DataManager

}