package com.akkt.ecommerce.data.vos

import com.google.gson.annotations.SerializedName

/**
 *Created by Aung Ko Ko Thet on 4/24/19
 */
class ProductImageUrlVO {

    @SerializedName("id")
    var id: Int = 0

    @SerializedName("image_url")
    var image_url: String? = null
}