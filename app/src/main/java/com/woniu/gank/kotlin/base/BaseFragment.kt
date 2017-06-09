package com.woniu.gank.kotlin.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(getLayoutId(), container, false)
    }

    abstract fun getLayoutId(): Int
}