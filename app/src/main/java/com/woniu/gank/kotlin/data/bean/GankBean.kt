package com.woniu.gank.kotlin.data.bean

import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * @author woniu
 * @title GankBean
 * @description
 * @modifier
 * @date
 * @since 2017/7/3 下午9:08
 */
data class GankBean(@SerializedName("_id") var id: String,
                   @SerializedName("type") var type: String,
                   @SerializedName("url") var url: String,
                   @SerializedName("who") var who: String,
                   @SerializedName("desc") var desc: String,
                   @SerializedName("used") var userd: Boolean,
                   @SerializedName("createdAt") var createdTime: Date,
                   @SerializedName("publishedAt") var publishedTime: Date)
//{
//    "_id": "56cc6d23421aa95caa707bba",
//    "createdAt": "2015-08-06T02:05:32.826Z",
//    "desc": "\u4e00\u4e2a\u67e5\u770b\u8bbe\u5907\u89c4\u683c\u7684\u5e93\uff0c\u5e76\u4e14\u53ef\u4ee5\u8ba1\u7b97\u54ea\u4e00\u5e74\u88ab\u5b9a\u4e3a\u201c\u9ad8\u7aef\u201d\u673a",
//    "publishedAt": "2015-08-06T04:16:55.575Z",
//    "type": "Android",
//    "url": "https://github.com/facebook/device-year-class",
//    "used": true,
//    "who": "\u6709\u65f6\u653e\u7eb5"
//}