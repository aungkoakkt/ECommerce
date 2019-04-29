package com.akkt.ecommerce.data.models

import com.akkt.ecommerce.data.vos.ProductVO
import com.akkt.ecommerce.delegates.FavoriteDelegate

/**
 *Created by Aung Ko Ko Thet on 4/28/19
 */
interface FavoriteModel {

    fun getFavoriteProduct(delegate :FavoriteDelegate)
    fun addToFavorite(product:ProductVO):Long
}