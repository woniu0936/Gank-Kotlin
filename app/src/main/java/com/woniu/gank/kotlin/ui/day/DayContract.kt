package com.woniu.gank.kotlin.ui.day

import com.trello.rxlifecycle2.LifecycleProvider
import com.trello.rxlifecycle2.android.FragmentEvent
import com.woniu.gank.kotlin.base.BasePresenter
import com.woniu.gank.kotlin.base.BaseView
import com.woniu.gank.kotlin.data.bean.GankBean

/**
 * @author woniu
 * @title DayContract
 * @description
 * @modifier
 * @date
 * @since 2017/6/21 下午4:55
 */
interface DayContract {

    interface View : BaseView {

//        fun bind(event: FragmentEvent): LifecycleTransformer<T>

        fun bind(): LifecycleProvider<FragmentEvent>

        fun showLoading()

        fun hideLoading()

        fun showContent(t: List<DayModel>?)

    }

    interface Presenter : BasePresenter {

        fun fetchData()

    }

}