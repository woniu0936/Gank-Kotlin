package com.woniu.gank.kotlin.base

import android.os.Bundle
import me.yokeyword.fragmentation.SupportActivity

/**
 * @author woniu
 * @title BaseActivity
 * @description
 * @modifier
 * @date
 * @since 2017/6/7 上午10:45
 */
abstract class BaseActivity : SupportActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
    }

    abstract fun getLayoutId(): Int

}