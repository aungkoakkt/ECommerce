package com.akkt.ecommerce.network

import com.akkt.ecommerce.network.responses.GetCategoryListResponse
import com.akkt.ecommerce.network.responses.GetLoginUserResponse
import com.akkt.ecommerce.network.responses.GetProductListResponse
import com.akkt.ecommerce.network.responses.GetRegisterResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 *Created by Aung Ko Ko Thet on 4/24/19
 */
interface ECommerceApi {

    @FormUrlEncoded
    @POST("fun/login.php")
    fun login(
        @Field("phone") phone: String,
        @Field("password") password: String
    ): Call<GetLoginUserResponse>

    @FormUrlEncoded
    @POST("fun/register.php")
    fun register(
        @Field("phone") phone: String,
        @Field("name") name: String,
        @Field("password") password: String,
        @Field("date_of_birth") birthday: String,
        @Field("country_of_origin") country: String
    ): Call<GetRegisterResponse>

    @FormUrlEncoded
    @POST("fun/getCategory.php")
    fun loadCategoryList(
        @Field("access_token") accessToken: String,
        @Field("page") page: Int
    ): Call<GetCategoryListResponse>

    @FormUrlEncoded
    @POST("fun/getProducts.php")
    fun loadProductList(
        @Field("access_token") accessToken: String,
        @Field("page") page: Int
    ): Call<GetProductListResponse>
}