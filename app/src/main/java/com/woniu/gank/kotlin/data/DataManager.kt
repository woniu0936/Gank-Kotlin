package com.woniu.gank.kotlin.data

import com.woniu.gank.kotlin.data.bean.DayBean
import com.woniu.gank.kotlin.tool.RxHelper
import io.reactivex.Flowable
import retrofit2.Retrofit
import java.util.*
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

    /**
     * 获取每日推荐
     */
    fun getDay(): Flowable<DayBean> {
        val year = Calendar.getInstance().get(Calendar.YEAR)
        val month = Calendar.getInstance().get(Calendar.MONTH)
        val day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        return mApiService.getDay(year, month, day)
                .compose(RxHelper.transerformResult())
    }

}