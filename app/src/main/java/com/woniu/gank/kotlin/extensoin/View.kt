package com.woniu.gank.kotlin.extensoin

import android.view.View

/**
 * @author woniu
 * @title View
 * @description
 * @modifier
 * @date
 * @since 2017/7/26 下午9:04
 */
fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.hide() {
    this.visibility = View.GONE
}