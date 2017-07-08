package com.woniu.gank.kotlin.ui.category.ios

import com.trello.rxlifecycle2.LifecycleProvider
import com.trello.rxlifecycle2.android.FragmentEvent
import com.woniu.gank.kotlin.R
import com.woniu.gank.kotlin.base.RxBaseFragment
import com.woniu.gank.kotlin.di.AppComponent
import com.woniu.gank.kotlin.ui.category.android.IOSContract

/**
 * @author woniu
 * @title IOSFragment
 * @description
 * @modifier
 * @date
 * @since 2017/7/8 下午4:54
 */
class IOSFragment : RxBaseFragment(), IOSContract.View {

    companion object {
        fun newInstance(): IOSFragment = IOSFragment()
    }

    override fun bindLifecycle(): LifecycleProvider<FragmentEvent> = this

    override fun getLayoutId(): Int = R.layout.fragment_category_ios

    override fun inject(appComponent: AppComponent) {

    }

}