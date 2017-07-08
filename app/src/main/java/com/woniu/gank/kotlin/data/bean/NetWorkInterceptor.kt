package com.woniu.gank.kotlin.data.bean

import okhttp3.Interceptor
import okhttp3.Response

/**
 * @author woniu
 * @title NetWorkInterceptor
 * @description
 * @modifier
 * @date
 * @since 2017/7/4 下午8:32
 */
class NetWorkInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain?): Response {
        var request = chain?.request()
        return chain!!.proceed(request)
    }

}