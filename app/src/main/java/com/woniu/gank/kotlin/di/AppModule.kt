package com.woniu.gank.kotlin.di

import android.content.Context
import com.woniu.gank.kotlin.GankApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author woniu
 * @title AppModule
 * @description
 * @modifier
 * @date
 * @since 2017/6/6 下午9:33
 */
@Module
class AppModule(private val mGankApp: GankApp) {

    @Singleton
    @Provides
    fun provideContext(): Context = mGankApp

}