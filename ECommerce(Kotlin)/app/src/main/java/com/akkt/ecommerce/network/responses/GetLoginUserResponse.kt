package com.akkt.ecommerce.network.responses

import com.akkt.ecommerce.data.vos.*
import com.google.gson.annotations.SerializedName

/**
 *Created by Aung Ko Ko Thet on 4/24/19
 */
class GetLoginUserResponse : BaseResponse() {

    @SerializedName("login_user")
    var loginUser: LoginUserVO? = null

    @SerializedName("favorite_list")
    var favourite: List<FavoriteVO>? = null

    @SerializedName("selling_list")
    var selling: List<SellingVO>? = null

    @SerializedName("sold_list")
    var sold: List<SoldVO>? = null

    @SerializedName("bought_list")
    var boughtLsit: List<BoughtVO>? = null
}