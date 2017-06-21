package com.woniu.gank.kotlin.ui.category

import com.woniu.gank.kotlin.R
import com.woniu.gank.kotlin.base.RxBaseFragment

/**
 * @author woniu
 * @title CategoryFragment
 * @description
 * @modifier
 * @date
 * @since 2017/6/16 下午4:31
 */
class CategoryFragment : RxBaseFragment() {

    //Java 调用伴生对象的方法时需要加上注解 platformStatic
    companion object {
        fun newInstance(): CategoryFragment {
            return CategoryFragment()
        }
    }

    override fun getLayoutId(): Int = R.layout.fragment_category

}