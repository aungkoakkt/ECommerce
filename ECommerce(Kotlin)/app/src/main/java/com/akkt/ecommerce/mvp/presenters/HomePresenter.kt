package com.akkt.ecommerce.mvp.presenters

import com.akkt.ecommerce.data.vos.CategoryVO
import com.akkt.ecommerce.data.vos.ProductVO
import com.akkt.ecommerce.delegates.CategoryDelegate
import com.akkt.ecommerce.delegates.ProductDelegate
import com.akkt.ecommerce.mvp.views.HomeView
import com.akkt.ecommerce.network.ECommerceDataAgent

/**
 *Created by Aung Ko Ko Thet on 5/8/19
 */
class HomePresenter (val mHomeView:HomeView):BasePresenter(),IHomePresenter {

    override fun onUIReady() {

        mProductModel.getCategoryList(ECommerceDataAgent.ACCESS_TOKEN, 1, object : CategoryDelegate {
            override fun getCategoryList(category: List<CategoryVO>) {
                mHomeView.displayCategory(category)
            }

            override fun onFail(message: String) {
                mHomeView.displayFailMessageForCategory(message)
            }

        })

        mProductModel.getProductList(ECommerceDataAgent.ACCESS_TOKEN, 1, object : ProductDelegate {
            override fun onFail(message: String) {
                mHomeView.displayFailMessageForProduct(message)
            }

            override fun getProductList(productlist: List<ProductVO>) {
                mHomeView.displayProduct(productlist)
            }
        })
    }

    override fun onTapCategoryItem(category: CategoryVO) {
        mHomeView.navigateToCategoryDetail(category.categoryId,category.categoryName)
    }

    override fun onTapProduct(product: ProductVO) {
        mHomeView.navigateToProductDetail(product.productId)
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