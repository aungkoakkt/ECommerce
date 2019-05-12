package com.akkt.ecommerce.mvp.presenters.impl

import com.akkt.ecommerce.data.vos.ProductVO
import com.akkt.ecommerce.delegates.ProductDelegate
import com.akkt.ecommerce.mvp.presenters.IProfilePresenter
import com.akkt.ecommerce.mvp.views.ProfileView

/**
 *Created by Aung Ko Ko Thet on 5/9/19
 */
class ProfilePresenter(val mProfileView: ProfileView) : BasePresenter(), IProfilePresenter {

    override fun onUIReady() {

        val userInfo = mUserModel.getUserInformation()
        mProfileView.displayUserInformation(userInfo)

        mHistoryModel.getHistory(object : ProductDelegate {
            override fun getProductList(productlist: List<ProductVO>) {
                mProfileView.displayHistoryList(productlist)
            }

            override fun onFail(message: String) {
                mProfileView.displayNoHistoryMessage(message)
            }

        })
    }

    override fun onTapProduct(product: ProductVO) {
        mProfileView.navigateToProductDetail(product.productId)
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