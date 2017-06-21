package com.woniu.gank.kotlin.ui.day

import android.os.Bundle
import com.woniu.gank.kotlin.R
import com.woniu.gank.kotlin.base.RxBaseFragment

/**
 * @author woniu
 * @title DayFragment
 * @description 每日推荐
 * @modifier
 * @date
 * @since 2017/6/14 下午9:31
 */
class DayFragment : RxBaseFragment() {

    //Java 调用伴生对象的方法时需要加上注解 platformStatic
    companion object {
        fun newInstance(): DayFragment {
            return DayFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun getLayoutId(): Int = R.layout.fragment_day

}
