package com.akkt.ecommerce.delegates

import com.akkt.ecommerce.data.vos.CategoryVO

/**
 *Created by Aung Ko Ko Thet on 4/27/19
 */
interface CategoryItemDelegate {

    fun onTapCategoryItem(category: CategoryVO)
}