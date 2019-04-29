package com.akkt.ecommerce.data.models

import com.akkt.ecommerce.data.vos.FavoriteVO
import com.akkt.ecommerce.data.vos.ProductVO
import com.akkt.ecommerce.delegates.FavoriteDelegate

/**
 *Created by Aung Ko Ko Thet on 4/28/19
 */
object FavoriteModelImpl : BaseModel(), FavoriteModel {

    override fun addToFavorite(product: ProductVO): Long {

        val favoriteProduct = FavoriteVO(
            productId = product.productId,
            productName = product.productName,
            productPrice = product.productPrice,
            productImageUrls = product.productImageUrl
        )

        val id=mDatabase.favouriteDao().addFavoriteProduct(favoriteProduct)

        return id
    }

    override fun getFavoriteProduct(delegate: FavoriteDelegate) {
        val favoriteProducts = mDatabase.favouriteDao().retrieveFavoriteProducts()
        if (favoriteProducts.isEmpty()) {
            delegate.onFailGettingFavoriteProduct("There is no favorite product")
        } else {
            delegate.onSuccesGettingFavoriteProduct(favoriteProducts)
        }
    }

}