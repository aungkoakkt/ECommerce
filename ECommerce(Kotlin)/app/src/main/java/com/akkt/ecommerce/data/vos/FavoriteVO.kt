package com.akkt.ecommerce.data.vos

import com.google.gson.annotations.SerializedName

/**
 *Created by Aung Ko Ko Thet on 4/24/19
 */
data class FavoriteVO(

    @SerializedName("product_id")
    val productId: Int,

    @SerializedName("product_name")
    val productName: String,

    @SerializedName("product_image_url")
    val productImageUrls: List<ProductImageUrlVO>,

    @SerializedName("product_price")
    val productPrice: String
)