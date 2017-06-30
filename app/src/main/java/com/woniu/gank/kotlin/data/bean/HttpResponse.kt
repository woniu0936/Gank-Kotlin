package com.woniu.gank.kotlin.data.bean

/**
 * @author woniu
 * @title HttpResponse
 * @description
 * @modifier
 * @date
 * @since 2017/6/29 下午9:30
 */
data class HttpResponse<T>(var data: T, var error: Boolean)

//等同于上面的写法
//class HttpResponse<T> {
//
//    var data: T? = null
//
//    var error: Boolean = false
//
//}