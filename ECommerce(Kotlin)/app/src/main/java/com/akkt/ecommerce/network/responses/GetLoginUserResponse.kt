package com.akkt.ecommerce.network.responses

import com.akkt.ecommerce.data.vos.*
import com.google.gson.annotations.SerializedName

/**
 *Created by Aung Ko Ko Thet on 4/24/19
 */
data class GetLoginUserResponse(

    @SerializedName("login_user")
    val loginUser: LoginUserVO,

    @SerializedName("favorite_list")
    val favouriteList: List<FavoriteVO>,

    @SerializedName("selling_list")
    val sellingList: List<SellingVO>,

    @SerializedName("sold_list")
    val soldList: List<SoldVO>,

    @SerializedName("bought_list")
    val boughtList: List<BoughtVO>

) : BaseResponse()