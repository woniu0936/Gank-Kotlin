package com.woniu.gank.kotlin.ui.day

import com.woniu.gank.kotlin.di.AppComponent
import com.woniu.gank.kotlin.di.PerFragment
import dagger.Component

/**
 * @author woniu
 * @title DayComponent
 * @description
 * @modifier
 * @date
 * @since 2017/7/4 下午6:57
 */
@PerFragment
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(DayModule::class))
interface DayComponent {
    fun inject(fragment: DayFragment)
}