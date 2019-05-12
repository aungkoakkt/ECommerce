package com.akkt.ecommerce.mvp.presenters.impl

import com.akkt.ecommerce.data.vos.ProductVO
import com.akkt.ecommerce.delegates.FavoriteDelegate
import com.akkt.ecommerce.mvp.presenters.IFavoritePresenter
import com.akkt.ecommerce.mvp.views.FavoriteView

/**
 *Created by Aung Ko Ko Thet on 5/9/19
 */
class FavoritePresenter(val mFavoriteView: FavoriteView) : BasePresenter(), IFavoritePresenter {

    override fun onUIReady() {

        mFavoriteModel.getFavoriteProduct(object : FavoriteDelegate {

            override fun onSuccesGettingFavoriteProduct(productList: List<ProductVO>) {
                mFavoriteView.displayFavoriteList(productList)
            }

            override fun onFailGettingFavoriteProduct(message: String) {
                mFavoriteView.displayFailMessage(message)
            }

        })
    }

    override fun onTapProduct(product: ProductVO) {
        mFavoriteView.navigateToProductDetail(product.productId)
    }

    override fun onTapFavorite(productId: Int) {

    }

    override fun onTapNotFavorite(productId: Int) {

    }

    override fun onStart() {

    }

    override fun onStop() {

    }
}