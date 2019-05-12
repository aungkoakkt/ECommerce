package com.akkt.ecommerce.data.models.impl

import com.akkt.ecommerce.data.models.FavoriteModel
import com.akkt.ecommerce.delegates.FavoriteDelegate

/**
 *Created by Aung Ko Ko Thet on 4/28/19
 */
object FavoriteModelImpl : BaseModel(), FavoriteModel {

    override fun getFavoriteProduct(delegate: FavoriteDelegate) {
        val favoriteProducts = mDatabase.productDao().retrieveFavoriteProducts()
        if (favoriteProducts.isEmpty()) {
            delegate.onFailGettingFavoriteProduct("There is no favorite product")
        } else {
            delegate.onSuccesGettingFavoriteProduct(favoriteProducts)
        }
    }

    override fun addToFavorite(productId: Int) {
        mDatabase.productDao().updateFavoriteForProduct(productId,1)
    }

    override fun removeFromFavorite(productId: Int) {
        mDatabase.productDao().updateFavoriteForProduct(productId,0)
    }
}