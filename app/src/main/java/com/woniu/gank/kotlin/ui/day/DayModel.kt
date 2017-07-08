package com.woniu.gank.kotlin.ui.day

import com.woniu.gank.kotlin.data.bean.GankBean
import io.reactivex.rxkotlin.toObservable
import java.util.*

/**
 * @author woniu
 * @title DayModel
 * @description
 * @modifier
 * @date
 * @since 2017/7/5 上午12:08
 */
class DayModel(var id: String,
               var type: String,
               var url: String,
               var who: String,
               var desc: String,
               var userd: Boolean,
               var createdTime: Date,
               var publishedTime: Date) {

    companion object {
        val TYPE_ANDROID = "Android"
        val TYPE_IOS = "iOS"
        val TYPE_RESOURCE = "拓展资源"
        val TYPE_VIDEO = "休息视频"
        val TYPE_GIRL = "福利"

        fun transform(bean: GankBean): DayModel {
            return DayModel(bean.id, bean.type, bean.url, bean.who, bean.desc, bean.userd, bean.createdTime, bean.publishedTime)
        }

        fun transform(list: List<GankBean>): List<DayModel> {
            var result = arrayListOf<DayModel>()
            list?.toObservable()
                    .map { transform(it) }
                    .subscribe{
                        result.add(it)
                    }
            return result
        }
    }

    override fun toString(): String {
        return "DayModel(id='$id', type='$type', url='$url', who='$who', desc='$desc', userd=$userd, createdTime=$createdTime, publishedTime=$publishedTime)"
    }


}