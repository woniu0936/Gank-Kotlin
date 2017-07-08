package com.woniu.gank.kotlin.data

import com.woniu.gank.kotlin.data.bean.DayBean
import com.woniu.gank.kotlin.data.bean.HttpResponse
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author woniu
 * @title ApiService
 * @description
 * @modifier
 * @date
 * @since 2017/6/21 下午3:15
 */
interface ApiService {

    /**
     * 分类数据: http://gank.io/api/data/数据类型/请求个数/第几页
     * •数据类型： 福利 | Android | iOS | 休息视频 | 拓展资源 | 前端 | all
     * •请求个数： 数字，大于0
     * •第几页：数字，大于0
     *
     *
     * 例：•http://gank.io/api/data/Android/10/1
     * •http://gank.io/api/data/福利/10/1
     * •http://gank.io/api/data/iOS/20/2
     * •http://gank.io/api/data/all/20/2
     *
     *
     * 每日数据： http://gank.io/api/day/年/月/日
     *
     *
     * 例：
     * •http://gank.io/api/day/2015/08/06
     *
     *
     * 随机数据：http://gank.io/api/random/data/分类/个数
     * •数据类型：福利 | Android | iOS | 休息视频 | 拓展资源 | 前端
     * •个数： 数字，大于0
     *
     *
     * 例：•http://gank.io/api/random/data/Android/20
     */

    companion object {
        val baseUrl = "http://gank.io/api/"
    }

    //每日数据
    @GET("day/{year}/{month}/{day}")
    fun getDay(@Path("year") year: Int, @Path("month") month: Int, @Path("day") day: Int): Flowable<HttpResponse<DayBean>>

    //android数据
    @GET("data/Android/{pageSize}/{pageNo}")
    fun getAndroid(@Path("pageSize") pageSize: Int, @Path("pageNo") pageNo: Int): Flowable<HttpResponse<DayBean>>

}