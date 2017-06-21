package com.woniu.gank.kotlin.data

import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author woniu
 * @title DataManager
 * @description
 * @modifier
 * @date
 * @since 2017/6/21 下午4:23
 */
@Singleton
class DataManager @Inject constructor(retrofit: Retrofit) {

    private val mApiService: ApiService

    init {
        mApiService = retrofit.create(ApiService::class.java)
    }

}