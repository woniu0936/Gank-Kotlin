package com.woniu.gank.kotlin.ui.day.viewBinder

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.woniu.gank.kotlin.R
import com.woniu.gank.kotlin.ui.day.DayModel
import kotlinx.android.synthetic.main.item_day_view_android.view.*
import me.drakeet.multitype.ItemViewBinder

/**
 * @author woniu
 * @title AndroidViewBinder
 * @description
 * @modifier
 * @date
 * @since 2017/7/5 上午12:30
 */
class AndroidViewBinder : ItemViewBinder<DayModel, AndroidViewBinder.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, item: DayModel) {
        holder.bindView(item)
        holder.bindEvent(item)
    }

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): ViewHolder {
        val root = inflater.inflate(R.layout.item_day_view_android, parent, false)
        return ViewHolder(root)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(item: DayModel) {
            itemView.tvTitle.text = item.desc
            itemView.tvAuthor.text = "by: ${item.who}"
            itemView.tvDate.text = item.publishedTime.toString()
        }

        fun bindEvent(item: DayModel) {
            itemView.tvTitle.setOnClickListener {
                Toast.makeText(itemView.context, itemView.tvTitle.text, Toast.LENGTH_SHORT).show()
            }
        }
    }

}