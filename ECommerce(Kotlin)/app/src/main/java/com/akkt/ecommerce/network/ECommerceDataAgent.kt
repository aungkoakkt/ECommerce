package com.akkt.ecommerce.network

import com.akkt.ecommerce.delegates.CategoryDelegate
import com.akkt.ecommerce.delegates.LoginDelegate
import com.akkt.ecommerce.delegates.ProductDelegate
import com.akkt.ecommerce.delegates.RegisterDelegate

/**
 *Created by Aung Ko Ko Thet on 4/24/19
 */
interface ECommerceDataAgent {

    companion object {
        val ACCESS_TOKEN = "b002c7e1a528b7cb460933fc2875e916"
    }

    fun login(phone: String, password: String, loginDelegate: LoginDelegate)

    fun register(
        name: String,
        password: String,
        phone: String,
        dateOfBirth: String,
        location: String,
        registerDelegate: RegisterDelegate
    )

    fun loadCategoryList(accessToken: String, page: Int, categoryDelegate: CategoryDelegate)

    fun loadProductList(accessToken: String,page:Int,productDelegate: ProductDelegate)

}