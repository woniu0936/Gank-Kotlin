package com.woniu.gank.kotlin.ui.day.viewBinder

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.woniu.gank.kotlin.R
import com.woniu.gank.kotlin.ui.day.DayModel
import kotlinx.android.synthetic.main.item_day_view.view.*
import me.drakeet.multitype.ItemViewBinder

/**
 * @author woniu
 * @title GirlViewBinder
 * @description
 * @modifier
 * @date
 * @since 2017/7/5 上午12:30
 */
class GirlViewBinder : ItemViewBinder<DayModel, GirlViewBinder.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, item: DayModel) {
        holder.itemView.ivImage?.let {
            Log.d("GirlViewBinder", item.toString())
        }
        holder.bindView(item)
    }

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): ViewHolder {
        val root = inflater.inflate(R.layout.item_day_view_girl, parent, false)
        return ViewHolder(root)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(item: DayModel) {
            Glide.with(itemView.context)
                    .load(item.url)
                    .placeholder(R.mipmap.ic_launcher_round)
                    .fitCenter()
                    .into(itemView.ivImage)

        }
    }

}