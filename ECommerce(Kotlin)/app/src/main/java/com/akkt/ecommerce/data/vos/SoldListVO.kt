package com.akkt.ecommerce.data.vos

import com.google.gson.annotations.SerializedName

/**
 *Created by Aung Ko Ko Thet on 4/24/19
 */
class SoldListVO {

    @SerializedName("product_id")
    private var productId: Int = 0

    @SerializedName("product_name")
    private var productName: String? = null

    @SerializedName("product_price")
    private var productPrice: String? = null

    @SerializedName("product_image_url")
    private var productImageUrl: String? = null
}