package com.woniu.gank.kotlin.ui.day.viewBinder

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.woniu.gank.kotlin.R
import com.woniu.gank.kotlin.ui.day.DayModel
import me.drakeet.multitype.ItemViewBinder

/**
 * @author woniu
 * @title VideoViewBinder
 * @description
 * @modifier
 * @date
 * @since 2017/7/5 上午12:30
 */
class VideoViewBinder : ItemViewBinder<DayModel, VideoViewBinder.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, item: DayModel) {

    }

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): ViewHolder {
        val root = inflater.inflate(R.layout.item_day_view_video, parent, false)
        return ViewHolder(root)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var ivImage: ImageView

        init {
            ivImage = itemView.findViewById(R.id.iv_image) as ImageView
        }
    }

}