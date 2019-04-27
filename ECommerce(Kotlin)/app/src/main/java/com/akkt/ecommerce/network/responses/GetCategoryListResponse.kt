package com.akkt.ecommerce.network.responses

import com.akkt.ecommerce.data.vos.CategoryVO
import com.google.gson.annotations.SerializedName

/**
 *Created by Aung Ko Ko Thet on 4/25/19
 */

class GetCategoryListResponse : BaseResponse() {

    @SerializedName("apiVersion")
    var apiVersion: String? = null

    @SerializedName("page")
    var page: String? = null

    @SerializedName("categoryList")
    var category: List<CategoryVO>? = null

}