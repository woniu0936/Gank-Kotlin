package com.woniu.gank.kotlin.extensoin

import android.content.Context


/**
 * @author woniu
 * @title Int
 * @description
 * @modifier
 * @date
 * @since 2017/7/26 下午9:06
 */
fun Int.dpToPx(context: Context) = (this * context.resources.displayMetrics.density + 0.5f).toInt()

fun Int.pxToDp(context: Context) = (this / context.resources.displayMetrics.density + 0.5f).toInt()
