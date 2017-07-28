package com.woniu.gank.kotlin.extension

import android.content.Context
import com.woniu.gank.kotlin.GankApp


/**
 * @author woniu
 * @title Int
 * @description
 * @modifier
 * @date
 * @since 2017/7/26 下午9:06
 */
fun Int.dpToPx(context: Context = GankApp.instance) = (this * context.resources.displayMetrics.density + 0.5f).toInt()

fun Int.pxToDp(context: Context = GankApp.instance) = (this / context.resources.displayMetrics.density + 0.5f).toInt()
