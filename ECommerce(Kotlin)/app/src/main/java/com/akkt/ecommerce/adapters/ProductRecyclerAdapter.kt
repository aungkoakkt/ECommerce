package com.akkt.ecommerce.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.akkt.ecommerce.R
import com.akkt.ecommerce.data.vos.ProductVO
import com.akkt.ecommerce.delegates.ProductItemDelegate
import com.akkt.ecommerce.view.holders.ProductViewHolder

/**
 *Created by Aung Ko Ko Thet on 4/25/19
 */
class ProductRecyclerAdapter(private val delegate:ProductItemDelegate) : BaseRecyclerAdapter<ProductViewHolder,ProductVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {

        val itemView= LayoutInflater.from(parent.context).inflate(R.layout.view_item_product,parent,false)
        return ProductViewHolder(itemView,delegate)
    }
}