package com.woniu.gank.kotlin.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.woniu.gank.kotlin.GankApp
import com.woniu.gank.kotlin.di.AppComponent
import me.yokeyword.fragmentation.SupportFragment

/**
 * @author woniu
 * @title BaseFragment
 * @description
 * @modifier
 * @date
 * @since 2017/6/7 上午10:48
 */
abstract class BaseFragment : SupportFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject(GankApp.instance.appComponent)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(getLayoutId(), container, false)
    }

    abstract fun getLayoutId(): Int

    abstract fun inject(appComponent: AppComponent)
}