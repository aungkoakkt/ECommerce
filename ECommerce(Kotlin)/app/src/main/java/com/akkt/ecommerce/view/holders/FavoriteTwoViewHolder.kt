package com.akkt.ecommerce.view.holders

import android.view.View
import com.akkt.ecommerce.R
import com.akkt.ecommerce.data.vos.ProductVO
import com.akkt.ecommerce.delegates.ProductItemDelegate
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.view_item_favorite_two.view.*

/**
 *Created by Aung Ko Ko Thet on 4/29/19
 */
class FavoriteTwoViewHolder(itemView: View, private val delegate: ProductItemDelegate) :
    BaseViewHolder<ProductVO>(itemView) {

    override fun setData(data: ProductVO) {
        Glide.with(itemView.context).load(data.productImageUrl[0].image_url).error(R.drawable.ecommerce)
            .into(itemView.viewItemFavoriteTwo)

        itemView.setOnClickListener { delegate.onTapProduct(data) }
    }
}