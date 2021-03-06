package com.akkt.ecommerce.delegates

import com.akkt.ecommerce.data.vos.ProductVO

/**
 *Created by Aung Ko Ko Thet on 4/26/19
 */
interface ProductDelegate : BaseNetworkDelegate {

    fun getProductList(productlist: List<ProductVO>)
}