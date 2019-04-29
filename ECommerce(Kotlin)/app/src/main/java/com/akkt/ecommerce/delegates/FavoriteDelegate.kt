package com.akkt.ecommerce.delegates

import com.akkt.ecommerce.data.vos.ProductVO

/**
 *Created by Aung Ko Ko Thet on 4/28/19
 */
interface FavoriteDelegate {

    fun onSuccesGettingFavoriteProduct(productList:List<ProductVO>)
    fun onFailGettingFavoriteProduct(message:String)
}