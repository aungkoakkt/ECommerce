package com.akkt.ecommerce.delegates

import com.akkt.ecommerce.data.vos.CategoryListVO

/**
 *Created by Aung Ko Ko Thet on 4/26/19
 */
interface CategoryDelegate : BaseNetworkDelegate {

    fun getCategoryList(categoryList: List<CategoryListVO>)
}