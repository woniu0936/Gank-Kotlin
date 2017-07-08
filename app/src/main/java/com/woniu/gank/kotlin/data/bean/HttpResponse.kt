package com.woniu.gank.kotlin.data.bean

import com.google.gson.annotations.SerializedName

/**
 * @author woniu
 * @title HttpResponse
 * @description
 * @modifier
 * @date
 * @since 2017/6/29 下午9:30
 */
data class HttpResponse<T>(@SerializedName("results") var data: T, var error: Boolean)

//等同于上面的写法
//class HttpResponse<T> {
//
//    var data: T? = null
//
//    var error: Boolean = false
//
//}