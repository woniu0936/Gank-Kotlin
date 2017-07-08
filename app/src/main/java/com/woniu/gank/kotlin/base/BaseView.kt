package com.woniu.gank.kotlin.base

import com.trello.rxlifecycle2.LifecycleProvider
import com.trello.rxlifecycle2.android.FragmentEvent

/**
 * @author woniu
 * @title BaseView
 * @description
 * @modifier
 * @date
 * @since 2017/6/21 下午4:56
 */
interface BaseView {

    fun bindLifecycle(): LifecycleProvider<FragmentEvent>

}