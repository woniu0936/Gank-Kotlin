package com.woniu.gank.kotlin.ui.category.js

import com.trello.rxlifecycle2.LifecycleProvider
import com.trello.rxlifecycle2.android.FragmentEvent
import com.woniu.gank.kotlin.R
import com.woniu.gank.kotlin.base.RxBaseFragment
import com.woniu.gank.kotlin.di.AppComponent
import com.woniu.gank.kotlin.ui.category.android.IOSContract

/**
 * @author woniu
 * @title JSFragment
 * @description
 * @modifier
 * @date
 * @since 2017/7/8 下午4:54
 */
class JSFragment : RxBaseFragment(), IOSContract.View {

    companion object {
        fun newInstance(): JSFragment = JSFragment()
    }

    override fun bindLifecycle(): LifecycleProvider<FragmentEvent> = this

    override fun getLayoutId(): Int = R.layout.fragment_category_js

    override fun inject(appComponent: AppComponent) {

    }

}