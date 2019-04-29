package com.akkt.ecommerce.data.vos

import android.arch.persistence.room.*
import com.google.gson.annotations.SerializedName

/**
 *Created by Aung Ko Ko Thet on 4/24/19
 */
@Entity(tableName = "favorite",
    indices = [Index("product_id",unique = true)])
data class FavoriteVO(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "favorite_pk")
    var favoritePk: Int?=null,

    @ColumnInfo(name = "product_id")
    @SerializedName("product_id")
    val productId: Int,

    @ColumnInfo(name = "product_name")
    @SerializedName("product_name")
    val productName: String,

    @ColumnInfo(name = "product_image_url")
    @SerializedName("product_image_url")
    val productImageUrls: List<ProductImageUrlVO>,

    @ColumnInfo(name = "product_price")
    @SerializedName("product_price")
    val productPrice: String
)