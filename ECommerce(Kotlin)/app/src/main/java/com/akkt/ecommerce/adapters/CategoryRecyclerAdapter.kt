package com.akkt.ecommerce.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.akkt.ecommerce.R
import com.akkt.ecommerce.data.vos.CategoryListVO
import com.akkt.ecommerce.view.holders.CategoryViewHolder

/**
 *Created by Aung Ko Ko Thet on 4/25/19
 */
class CategoryRecyclerAdapter :BaseRecyclerAdapter<CategoryViewHolder,CategoryListVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): CategoryViewHolder {

        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.view_item_category,parent,false)
        return CategoryViewHolder(itemView)
    }
}