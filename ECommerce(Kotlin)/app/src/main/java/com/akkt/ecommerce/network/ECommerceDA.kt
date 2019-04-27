package com.akkt.ecommerce.network

import android.util.Log
import com.akkt.ecommerce.EcommerceApp
import com.akkt.ecommerce.delegates.CategoryDelegate
import com.akkt.ecommerce.delegates.LoginDelegate
import com.akkt.ecommerce.delegates.ProductDelegate
import com.akkt.ecommerce.delegates.RegisterDelegate
import com.akkt.ecommerce.network.responses.GetCategoryListResponse
import com.akkt.ecommerce.network.responses.GetLoginUserResponse
import com.akkt.ecommerce.network.responses.GetProductListResponse
import com.akkt.ecommerce.network.responses.GetRegisterResponse
import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 *Created by Aung Ko Ko Thet on 4/24/19
 */
class ECommerceDA private constructor() : ECommerceDataAgent {

    private val netApi: ECommerceApi

    init {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl("http://padcmyanmar.com/padc-3/final-projects/e-commerce/")
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .client(okHttpClient)
            .build()
        netApi = retrofit.create(ECommerceApi::class.java)
    }

    companion object {
        private var INSTANCE: ECommerceDA? = null

        fun getInstance(): ECommerceDA {
            if (INSTANCE == null) {
                INSTANCE = ECommerceDA()
            }

            val i = INSTANCE
            return i!!
        }
    }

    override fun login(phone: String, password: String, loginDelegate: LoginDelegate) {

        netApi.login(phone, password).enqueue(object : Callback<GetLoginUserResponse> {

            override fun onFailure(call: Call<GetLoginUserResponse>, t: Throwable) {
                loginDelegate.onFail(t.message)
                Log.e(EcommerceApp.TAG, t.message)
            }

            override fun onResponse(call: Call<GetLoginUserResponse>, response: Response<GetLoginUserResponse>) {
                val loginUserResponse = response.body()

                if (loginUserResponse!!.isResponseSuccess()) {
                    loginDelegate.onSuccess(loginUserResponse.loginUser)
                } else {
                    loginDelegate.onFail("Login Response is fail")
                }
            }

        })
    }

    override fun register(
        name: String,
        password: String,
        phone: String,
        dateOfBirth: String,
        location: String,
        registerDelegate: RegisterDelegate
    ) {
        netApi.register(phone, name, password, dateOfBirth, location).enqueue(object : Callback<GetRegisterResponse> {

            override fun onFailure(call: Call<GetRegisterResponse>, t: Throwable) {
                registerDelegate.onFail(t.message)
            }

            override fun onResponse(call: Call<GetRegisterResponse>, response: Response<GetRegisterResponse>) {
                val registerResponse = response.body()

                if (registerResponse!!.isResponseSuccess()) {
                    registerDelegate.success(registerResponse.message!!)
                } else {
                    registerDelegate.onFail("Can't register")
                }
            }

        })
    }

    override fun loadCategoryList(accessToken: String, page: Int, categoryDelegate: CategoryDelegate) {
        netApi.loadCategoryList(accessToken, page).enqueue(object : Callback<GetCategoryListResponse> {
            override fun onFailure(call: Call<GetCategoryListResponse>, t: Throwable) {
                categoryDelegate.onFail(t.message)
            }

            override fun onResponse(call: Call<GetCategoryListResponse>, response: Response<GetCategoryListResponse>) {

                val categoryListResponse = response.body()

                if (categoryListResponse!!.isResponseSuccess()) {
                    categoryDelegate.getCategoryList(categoryListResponse.category!!)
                } else {
                    categoryDelegate.onFail("Can't get category list")
                }
            }

        })
    }

    override fun loadProductList(accessToken: String, page: Int, productDelegate: ProductDelegate) {
        netApi.loadProductList(accessToken, page).enqueue(object : Callback<GetProductListResponse> {
            override fun onFailure(call: Call<GetProductListResponse>, t: Throwable) {
                productDelegate.onFail(t.message)
            }

            override fun onResponse(call: Call<GetProductListResponse>, response: Response<GetProductListResponse>) {
                val productListResponse = response.body()

                if (productListResponse!!.isResponseSuccess()) {
                    productDelegate.getProductList(productlist = productListResponse.productList!!)
                } else {
                    productDelegate.onFail("Can't get product list")
                }
            }

        })
    }
}