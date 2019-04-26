package com.akkt.ecommerce.view.holders

import android.support.v7.widget.RecyclerView
import android.view.View

/**
 *Created by Aung Ko Ko Thet on 4/25/19
 */
abstract class BaseViewHolder<V>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    protected var mData: V? = null

    abstract fun setData(data: V)
}