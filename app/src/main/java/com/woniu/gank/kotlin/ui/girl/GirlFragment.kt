package com.woniu.gank.kotlin.ui.girl

import android.os.Bundle
import com.woniu.gank.kotlin.R
import com.woniu.gank.kotlin.base.RxBaseFragment

/**
 * @author woniu
 * @title GirlFragment
 * @description 美女福利
 * @modifier
 * @date
 * @since 2017/6/16 下午3:26
 */
class GirlFragment : RxBaseFragment() {

    //Java 调用伴生对象的方法时需要加上注解 platformStatic
    companion object {
        fun newInstance(): GirlFragment {
            return GirlFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun getLayoutId(): Int = R.layout.fragment_girl

}