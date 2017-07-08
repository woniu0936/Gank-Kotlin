package com.woniu.gank.kotlin.ui.category.android

import com.woniu.gank.kotlin.data.DataManager
import javax.inject.Inject

/**
 * @author woniu
 * @title JSPresenter
 * @description
 * @modifier
 * @date
 * @since 2017/7/8 下午4:57
 */
class JSPresenter @Inject constructor(val mView: JSContract.View) : JSContract.Presenter {

    @Inject
    lateinit var mDataManager: DataManager

}