package com.akkt.ecommerce.adapters

import android.support.v7.widget.RecyclerView
import com.akkt.ecommerce.view.holders.BaseViewHolder

/**
 *Created by Aung Ko Ko Thet on 4/25/19
 */
abstract class BaseRecyclerAdapter<R : BaseViewHolder<D>, D> : RecyclerView.Adapter<R>() {

    private var mDataList: MutableList<D> = ArrayList()

    override fun onBindViewHolder(viewHolder: R, position: Int) {
        viewHolder.setData(mDataList[position])
    }

    override fun getItemCount(): Int {
        return mDataList.size
    }

    fun setNewData(newData: MutableList<D>) {
        mDataList = newData
        notifyDataSetChanged()
    }

    fun appendNewData(newData: List<D>) {
        mDataList.addAll(newData)
        notifyDataSetChanged()
    }

    fun getItemAt(position: Int): D? {
        return if (position < mDataList.size - 1) mDataList[position] else null

    }

    fun removeData(data: D) {
        mDataList.remove(data)
        notifyDataSetChanged()
    }

    fun addNewData(data: D) {
        mDataList.add(data)
        notifyDataSetChanged()
    }

    fun clearData() {
        mDataList = ArrayList()
        notifyDataSetChanged()
    }

}