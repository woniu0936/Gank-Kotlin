package com.woniu.gank.kotlin.ui.day

import com.woniu.gank.kotlin.di.PerFragment
import dagger.Module
import dagger.Provides

/**
 * @author woniu
 * @title DayModule
 * @description
 * @modifier
 * @date
 * @since 2017/7/4 下午6:59
 */
@Module
class DayModule constructor(val mView: DayContract.View) {

    @PerFragment
    @Provides
    internal fun provideView(): DayContract.View {
        return mView
    }

}