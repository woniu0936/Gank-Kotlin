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

/**
 * @author woniu
 * @title DayAdapter
 * @description
 * @modifier
 * @date
 * @since 2017/7/8 上午11:50
 */
class DayAdapter : RecyclerView.Adapter<DayAdapter.ViewHolder>() {

    private var list: ArrayList<DayModel>

    init {
        list = ArrayList()
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        Log.d("DayAdapter", list[position].toString())
        holder?.bindView(list[position])
    }

    override fun getItemCount(): Int = list.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val root = LayoutInflater.from(parent?.context).inflate(R.layout.item_day_view, parent, false);
        return ViewHolder(root)
    }

    fun setList(list: List<DayModel>) {
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemVIew: View) : RecyclerView.ViewHolder(itemVIew) {
        fun bindView(item: DayModel) {
            var url = "https://github.com/zhihu/Matisse/blob/master/image/screenshot_preview.png"
            Glide.with(itemView.context)
                    .load(url)
                    .placeholder(R.mipmap.ic_launcher_round)
                    .centerCrop()
                    .into(itemView.ivImage)
        }
    }
}