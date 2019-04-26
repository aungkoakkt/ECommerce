package com.akkt.ecommerce.view.holders

import android.view.View
import com.akkt.ecommerce.data.vos.CategoryListVO
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.view_item_category.view.*

/**
 *Created by Aung Ko Ko Thet on 4/25/19
 */
class CategoryViewHolder(itemView: View) : BaseViewHolder<CategoryListVO>(itemView) {

    override fun setData(data: CategoryListVO) {
        Glide.with(itemView.context).load(data.categoryIcon).into(itemView.iv_item_category_icon)
        itemView.tv_item_category_name.text = data.categoryName
        itemView.tv_item_category_name.isSelected=true

    }
}