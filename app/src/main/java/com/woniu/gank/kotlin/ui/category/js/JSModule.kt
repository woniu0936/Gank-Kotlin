package com.woniu.gank.kotlin.ui.category.android

import com.woniu.gank.kotlin.di.PerFragment
import dagger.Module
import dagger.Provides

/**
 * @author woniu
 * @title IOSModule
 * @description
 * @modifier
 * @date
 * @since 2017/7/8 下午4:57
 */
@Module
class JSModule(val mView: JSContract.View) {

    @PerFragment
    @Provides
    internal fun provideView(): JSContract.View = mView

}