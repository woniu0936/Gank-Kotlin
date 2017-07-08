package com.woniu.gank.kotlin.ui.category.android

import com.trello.rxlifecycle2.LifecycleProvider
import com.trello.rxlifecycle2.android.FragmentEvent
import com.woniu.gank.kotlin.R
import com.woniu.gank.kotlin.base.RxBaseFragment
import com.woniu.gank.kotlin.di.AppComponent

/**
 * @author woniu
 * @title AndroidFragment
 * @description
 * @modifier
 * @date
 * @since 2017/7/8 下午4:52
 */
class AndroidFragment : RxBaseFragment(), AndroidContract.View {

    companion object {
        fun newInstance(): AndroidFragment = AndroidFragment()
    }

    override fun bindLifecycle(): LifecycleProvider<FragmentEvent> = this

    override fun getLayoutId(): Int = R.layout.fragment_category_android

    override fun inject(appComponent: AppComponent) {

    }

}