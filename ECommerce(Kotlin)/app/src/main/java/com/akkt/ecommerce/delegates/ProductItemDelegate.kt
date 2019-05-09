package com.akkt.ecommerce.delegates

import com.akkt.ecommerce.data.vos.ProductVO

/**
 *Created by Aung Ko Ko Thet on 4/26/19
 */
interface ProductItemDelegate {

    fun onTapProduct(product: ProductVO)
    fun onTapFavorite(productId: Int)
    fun onTapNotFavorite(productId: Int)
}