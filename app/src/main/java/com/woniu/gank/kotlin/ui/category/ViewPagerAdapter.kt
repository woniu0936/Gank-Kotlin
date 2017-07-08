package com.woniu.gank.kotlin.ui.category

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.woniu.gank.kotlin.ui.category.android.AndroidFragment
import com.woniu.gank.kotlin.ui.category.ios.IOSFragment
import com.woniu.gank.kotlin.ui.category.js.JSFragment

/**
 * @author woniu
 * @title ViewPagerAdapter
 * @description
 * @modifier
 * @date
 * @since 2017/7/8 下午5:33
 */
class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    val tabs = arrayOf("android", "ios", "javaScript")

    override fun getItem(position: Int): Fragment {
        when (position) {
            1 -> return IOSFragment.newInstance()
            2 -> return JSFragment.newInstance()
            else -> return AndroidFragment.newInstance()
        }
    }

    override fun getCount(): Int = tabs.size

    override fun getPageTitle(position: Int): CharSequence = tabs[position]

}