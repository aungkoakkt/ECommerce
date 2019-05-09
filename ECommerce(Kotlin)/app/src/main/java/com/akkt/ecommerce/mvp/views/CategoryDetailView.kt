package com.akkt.ecommerce.mvp.views

import com.akkt.ecommerce.data.vos.ProductVO

/**
 *Created by Aung Ko Ko Thet on 5/9/19
 */
interface CategoryDetailView {

    fun displayProduct(productList: List<ProductVO>)
    fun displayFailToGetProductMessage(message: String)
    fun navigateToProductDetailScreen(productId: Int)

}