package com.akkt.ecommerce.mvp.views

import com.akkt.ecommerce.data.vos.CategoryVO
import com.akkt.ecommerce.data.vos.ProductVO

/**
 *Created by Aung Ko Ko Thet on 5/8/19
 */
interface HomeView {

    fun displayCategory(categoryList: List<CategoryVO>)
    fun displayProduct(productList: List<ProductVO>)
    fun displayFailMessageForCategory(message: String)
    fun displayFailMessageForProduct(message: String)
    fun navigateToProductDetail(productId: Int)
    fun navigateToCategoryDetail(categoryId: Int,categoryName:String)

}