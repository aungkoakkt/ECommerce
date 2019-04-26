package com.akkt.ecommerce.view.holders

import android.view.View
import com.akkt.ecommerce.data.vos.ProductVO
import com.akkt.ecommerce.delegates.ProductItemDelegate
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.view_item_product.view.*

/**
 *Created by Aung Ko Ko Thet on 4/25/19
 */
class ProductViewHolder(itemView: View, private val delegate: ProductItemDelegate) :BaseViewHolder<ProductVO>(itemView) {

    override fun setData(data: ProductVO) {
        Glide.with(itemView.context).load(data.productImageUrl?.get(0)?.image_url).into(itemView.iv_item_product_icon)
        itemView.tv_item_product_name.text=data.productName
        itemView.tv_item_product_price.text=data.productPrice

        itemView.setOnClickListener {  delegate.onTapProduct(data)}
    }
}