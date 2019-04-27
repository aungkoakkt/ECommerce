package com.akkt.ecommerce.view.holders

import android.view.View
import com.akkt.ecommerce.data.vos.CategoryVO
import com.akkt.ecommerce.delegates.CategoryItemDelegate
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.view_item_category.view.*

/**
 *Created by Aung Ko Ko Thet on 4/25/19
 */
class CategoryViewHolder(itemView: View, private val delegate :CategoryItemDelegate) : BaseViewHolder<CategoryVO>(itemView) {

    override fun setData(data: CategoryVO) {
        Glide.with(itemView.context).load(data.categoryIcon).into(itemView.ivItemCategoryIcon)
        itemView.tvItemCategoryName.text = data.categoryName
        itemView.tvItemCategoryName.isSelected=true

        itemView.setOnClickListener { delegate.onTapCategoryItem(data) }
    }
}