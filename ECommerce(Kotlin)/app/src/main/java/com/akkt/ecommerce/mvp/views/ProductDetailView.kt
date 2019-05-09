package com.akkt.ecommerce.mvp.views

import com.akkt.ecommerce.data.vos.ProductVO

/**
 *Created by Aung Ko Ko Thet on 5/9/19
 */
interface ProductDetailView {

    fun displayProduct(product: ProductVO)
    fun finishActivity()
}