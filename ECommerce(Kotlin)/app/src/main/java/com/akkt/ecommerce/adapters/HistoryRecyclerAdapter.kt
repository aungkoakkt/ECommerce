package com.akkt.ecommerce.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.akkt.ecommerce.R
import com.akkt.ecommerce.data.vos.ProductVO
import com.akkt.ecommerce.delegates.ProductItemDelegate
import com.akkt.ecommerce.view.holders.HistoryViewHolder

/**
 *Created by Aung Ko Ko Thet on 5/7/19
 */
class HistoryRecyclerAdapter(val delegate:ProductItemDelegate) :BaseRecyclerAdapter<HistoryViewHolder,ProductVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.view_item_history,parent,false)
        return HistoryViewHolder(itemView,delegate)
    }
}