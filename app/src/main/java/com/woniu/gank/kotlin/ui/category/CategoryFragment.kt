package com.woniu.gank.kotlin.ui.category

import android.os.Bundle
import android.view.View
import com.woniu.gank.kotlin.R
import com.woniu.gank.kotlin.base.RxBaseFragment
import com.woniu.gank.kotlin.di.AppComponent
import kotlinx.android.synthetic.main.fragment_category.*

/**
 * @author woniu
 * @title CategoryFragment
 * @description
 * @modifier
 * @date
 * @since 2017/6/16 下午4:31
 */
class CategoryFragment : RxBaseFragment() {

    override fun inject(appComponent: AppComponent) {

    }

    //Java 调用伴生对象的方法时需要加上注解 platformStatic
    companion object {
        fun newInstance(): CategoryFragment {
            return CategoryFragment()
        }
    }

    override fun getLayoutId(): Int = R.layout.fragment_category

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mTab.addTab(mTab.newTab())
        mTab.addTab(mTab.newTab())
        mTab.addTab(mTab.newTab())
        mViewPager.adapter = ViewPagerAdapter(childFragmentManager)
        mTab.setupWithViewPager(mViewPager)
    }

}