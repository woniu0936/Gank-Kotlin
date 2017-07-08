package com.woniu.gank.kotlin.ui.category.android

import com.woniu.gank.kotlin.di.AppComponent
import com.woniu.gank.kotlin.di.PerFragment
import dagger.Component

/**
 * @author woniu
 * @title IOSComponent
 * @description
 * @modifier
 * @date
 * @since 2017/7/8 下午4:56
 */
@PerFragment
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(IOSModule::class))
interface IOSComponent {
    fun inject(fragment: AndroidFragment)
}