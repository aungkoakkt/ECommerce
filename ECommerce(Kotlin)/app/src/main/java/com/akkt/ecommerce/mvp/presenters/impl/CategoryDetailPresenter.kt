package com.akkt.ecommerce.mvp.presenters.impl

import com.akkt.ecommerce.data.vos.ProductVO
import com.akkt.ecommerce.delegates.ProductDelegate
import com.akkt.ecommerce.mvp.presenters.ICategoryDetailPresenter
import com.akkt.ecommerce.mvp.views.CategoryDetailView

/**
 *Created by Aung Ko Ko Thet on 5/9/19
 */
class CategoryDetailPresenter(val mCategoryDetailView: CategoryDetailView) : BasePresenter(), ICategoryDetailPresenter {

    override fun onUIReady(categoryId: Int) {
        mProductModel.getProductListByCategoryId(categoryId, object : ProductDelegate {

            override fun getProductList(productlist: List<ProductVO>) {
                mCategoryDetailView.displayProduct(productlist)
            }

            override fun onFail(message: String) {
                mCategoryDetailView.displayFailToGetProductMessage(message)
            }
        })
    }

    override fun onTapProduct(product: ProductVO) {
        mCategoryDetailView.navigateToProductDetailScreen(product.productId)
    }

    override fun onTapFavorite(productId: Int) {
        mFavoriteModel.removeFromFavorite(productId)
    }

    override fun onTapNotFavorite(productId: Int) {
        mFavoriteModel.addToFavorite(productId)
    }

    override fun onStart() {

    }

    override fun onStop() {

    }
}