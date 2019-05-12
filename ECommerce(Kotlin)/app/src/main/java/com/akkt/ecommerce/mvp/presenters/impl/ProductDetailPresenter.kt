package com.akkt.ecommerce.mvp.presenters.impl

import com.akkt.ecommerce.data.vos.ProductVO
import com.akkt.ecommerce.delegates.ProductDetailDelegate
import com.akkt.ecommerce.mvp.presenters.IProductDetailPresenter
import com.akkt.ecommerce.mvp.views.ProductDetailView

/**
 *Created by Aung Ko Ko Thet on 5/9/19
 */
class ProductDetailPresenter(val mProductDetailView: ProductDetailView) : BasePresenter(), IProductDetailPresenter {

    override fun onUIReady(productId: Int) {

        mProductModel.getProductDetail(productId, object : ProductDetailDelegate {
            override fun getProductDetail(product: ProductVO) {
                mProductDetailView.displayProduct(product)
            }
        })

        mHistoryModel.addToHistory(productId)
    }

    override fun onTapBackButton() {
        mProductDetailView.finishActivity()
    }

    override fun onStart() {

    }

    override fun onStop() {

    }
}