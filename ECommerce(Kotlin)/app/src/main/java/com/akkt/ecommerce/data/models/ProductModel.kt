package com.akkt.ecommerce.data.models

import com.akkt.ecommerce.delegates.CategoryDelegate
import com.akkt.ecommerce.delegates.ProductDelegate
import com.akkt.ecommerce.delegates.ProductDetailDelegate

/**
 *Created by Aung Ko Ko Thet on 4/26/19
 */
interface ProductModel {

    fun getCategoryList(accessToken: String, page: Int, categoryDelegate: CategoryDelegate)
    fun getProductList(accessToken: String, page: Int, productDelegate: ProductDelegate)
    fun getProductListByCategoryId(categoryId: Int, productDelegate: ProductDelegate)
    fun getProductDetail(productId: Int, delegate: ProductDetailDelegate)
    fun addToHistory(productId: Int)
}