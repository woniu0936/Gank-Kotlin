package com.woniu.gank.kotlin.ui.day.viewBinder

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.woniu.gank.kotlin.R
import com.woniu.gank.kotlin.extension.formatToDay
import com.woniu.gank.kotlin.ui.day.DayModel
import kotlinx.android.synthetic.main.item_day_view_ios.view.*
import me.drakeet.multitype.ItemViewBinder

/**
 * @author woniu
 * @title IOSViewBinder
 * @description
 * @modifier
 * @date
 * @since 2017/7/5 上午12:30
 */
class IOSViewBinder : ItemViewBinder<DayModel, IOSViewBinder.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, item: DayModel) {
        holder.bindView(item)
    }

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): ViewHolder {
        val root = inflater.inflate(R.layout.item_day_view_ios, parent, false)
        return ViewHolder(root)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(item: DayModel) {
            itemView.tvTitle.text = item.desc
            itemView.tvAuthor.text = "by: ${item.who}"
            itemView.tvTime.text = item.createdTime?.formatToDay()
        }
    }

}