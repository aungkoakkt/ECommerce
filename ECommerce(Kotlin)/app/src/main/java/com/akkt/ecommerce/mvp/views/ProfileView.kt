package com.akkt.ecommerce.mvp.views

import com.akkt.ecommerce.data.vos.LoginUserVO
import com.akkt.ecommerce.data.vos.ProductVO

/**
 *Created by Aung Ko Ko Thet on 5/9/19
 */
interface ProfileView {

    fun displayUserInformation(loginUser: LoginUserVO)
    fun displayHistoryList(productList: List<ProductVO>)
    fun displayNoHistoryMessage(message: String)
    fun navigateToProductDetail(productId: Int)

}