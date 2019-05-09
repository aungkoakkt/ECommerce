package com.akkt.ecommerce.mvp.views

import com.akkt.ecommerce.data.vos.ProductVO

/**
 *Created by Aung Ko Ko Thet on 5/9/19
 */
interface FavoriteView {

    fun displayFavoriteList(productList: List<ProductVO>)
    fun displayFailMessage(message: String)
    fun navigateToProductDetail(productId: Int)
}