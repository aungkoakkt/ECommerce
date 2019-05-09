package com.akkt.ecommerce.view.holders

import android.view.View
import com.akkt.ecommerce.R
import com.akkt.ecommerce.data.vos.ProductVO
import com.akkt.ecommerce.delegates.ProductItemDelegate
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.view_item_history.view.*

/**
 *Created by Aung Ko Ko Thet on 5/7/19
 */
class HistoryViewHolder(itemView : View, val delegate:ProductItemDelegate) : BaseViewHolder<ProductVO>(itemView) {

    override fun setData(data: ProductVO) {
        Glide.with(itemView.context).load(data.productImageUrl[0].image_url).error(R.drawable.if_reindeer).into(itemView.ivItemHistory)
        itemView.tvItemHistoryProductName.text=data.productName
        itemView.tvItemHistoryProductDescription.text=data.productDesc

        itemView.setOnClickListener {  delegate.onTapProduct(data)}
    }
}