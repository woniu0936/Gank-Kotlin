package com.woniu.gank.kotlin.data.bean

import com.google.gson.annotations.SerializedName

/**
 * @author woniu
 * @title DayBean
 * @description
 * @modifier
 * @date
 * @since 2017/6/30 下午2:25
 */
data class DayBean(@SerializedName("Android") var android: List<GankBean>,
                   @SerializedName("iOS") var IOS: List<GankBean>,
                   @SerializedName("休息视频") var video: List<GankBean>,
                   @SerializedName("拓展资源") var resource: List<GankBean>,
                   @SerializedName("福利") var girl: List<GankBean>)