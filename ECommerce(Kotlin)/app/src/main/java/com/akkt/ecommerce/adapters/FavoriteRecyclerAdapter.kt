package com.akkt.ecommerce.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.akkt.ecommerce.R
import com.akkt.ecommerce.data.vos.ProductVO
import com.akkt.ecommerce.delegates.ProductItemDelegate
import com.akkt.ecommerce.view.holders.BaseViewHolder
import com.akkt.ecommerce.view.holders.FavoriteOneViewHolder
import com.akkt.ecommerce.view.holders.FavoriteTwoViewHolder

/**
 *Created by Aung Ko Ko Thet on 4/29/19
 */
class FavoriteRecyclerAdapter(private val delegate: ProductItemDelegate) :
    BaseRecyclerAdapter<BaseViewHolder<ProductVO>, ProductVO>() {

    val SMALL_TYPE = 0
    val LARGE_TYPE = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<ProductVO> {

        return when (viewType) {
            SMALL_TYPE -> {

                val itemView =
                    LayoutInflater.from(parent.context).inflate(R.layout.view_item_favorite_two, parent, false)

                return FavoriteTwoViewHolder(itemView,delegate)
            }

            LARGE_TYPE -> {

                val itemView =
                    LayoutInflater.from(parent.context).inflate(R.layout.view_item_favorite_one, parent, false)

                return FavoriteOneViewHolder(itemView,delegate)

            }

            else -> throw IllegalArgumentException("Invalid view type")
        }

    }

    override fun getItemViewType(position: Int): Int {

        return when (position % 2) {
            0 -> LARGE_TYPE
            1 -> SMALL_TYPE
            else -> throw IllegalArgumentException("Invalid view type")
        }

    }
}