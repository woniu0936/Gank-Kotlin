package com.woniu.gank.kotlin.extensoin

import java.text.SimpleDateFormat
import java.util.*


/**
 * @author woniu
 * @title Date
 * @description
 * @modifier
 * @date
 * @since 2017/7/26 下午8:57
 */
fun Date.format(): String {
    return SimpleDateFormat("yyyy-MM-dd").format(this)
}