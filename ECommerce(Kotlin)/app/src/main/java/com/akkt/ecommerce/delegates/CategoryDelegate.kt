package com.akkt.ecommerce.delegates

import com.akkt.ecommerce.data.vos.CategoryVO

/**
 *Created by Aung Ko Ko Thet on 4/26/19
 */
interface CategoryDelegate : BaseNetworkDelegate {

    fun getCategoryList(category: List<CategoryVO>)
}