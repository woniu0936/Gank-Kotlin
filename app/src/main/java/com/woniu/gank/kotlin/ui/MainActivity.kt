package com.woniu.gank.kotlin.ui

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import com.woniu.gank.kotlin.R
import com.woniu.gank.kotlin.base.RxBaseActivity
import com.woniu.gank.kotlin.ui.category.CategoryFragment
import com.woniu.gank.kotlin.ui.day.DayFragment
import com.woniu.gank.kotlin.ui.girl.GirlFragment
import kotlinx.android.synthetic.main.activity_main.*
import me.yokeyword.fragmentation.SupportFragment

class MainActivity : RxBaseActivity() {

    val FIRST = 0
    val SECOND = 1
    val THIRD = 2

    private val mFragments = arrayOfNulls<SupportFragment>(4)

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                showHideFragment(mFragments[FIRST])
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                showHideFragment(mFragments[SECOND])
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                showHideFragment(mFragments[THIRD])
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (null == savedInstanceState) {
            mFragments[FIRST] = DayFragment.newInstance()
            mFragments[SECOND] = CategoryFragment.newInstance()
            mFragments[THIRD] = GirlFragment.newInstance()
            loadMultipleRootFragment(R.id.content, FIRST,
                    mFragments[FIRST],
                    mFragments[SECOND],
                    mFragments[THIRD])
        } else {
            mFragments[FIRST] = findFragment(DayFragment::class.java)
            mFragments[SECOND] = findFragment(CategoryFragment::class.java)
            mFragments[THIRD] = findFragment(GirlFragment::class.java)
        }

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

    }

    override fun getLayoutId(): Int = R.layout.activity_main

}
