package com.woniu.gank.kotlin.ui.category.android

import com.woniu.gank.kotlin.data.DataManager
import javax.inject.Inject

/**
 * @author woniu
 * @title AndroidPresenter
 * @description
 * @modifier
 * @date
 * @since 2017/7/8 下午4:57
 */
class AndroidPresenter @Inject constructor(val mView: AndroidContract.View) : AndroidContract.Presenter {

    @Inject
    lateinit var mDataManager: DataManager



}