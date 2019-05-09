package com.akkt.ecommerce.data.vos

import android.arch.persistence.room.*
import com.google.gson.annotations.SerializedName

/**
 *Created by Aung Ko Ko Thet on 4/25/19
 */
@Entity(tableName = "product",indices = [Index("product_id")])
data class ProductVO(

    @PrimaryKey
    @ColumnInfo(name = "product_id")
    @SerializedName("product_id")
    val productId: Int,

    @ColumnInfo(name = "product_name")
    @SerializedName("product_name")
    val productName: String,

    @ColumnInfo(name = "product_image_url")
    @SerializedName("product_image_url")
    val productImageUrl: List<ProductImageUrlVO>,

    @ColumnInfo(name = "product_desc")
    @SerializedName("product_desc")
    val productDesc: String,

    @ColumnInfo(name = "product_price")
    @SerializedName("product_price")
    val productPrice: String,

    @ColumnInfo(name = "category")
    @SerializedName("category")
    val category: List<CategoryVO>,

    @ColumnInfo(name = "uploaded_time")
    @SerializedName("uploaded_time")
    val uploadedTime: String?,

    @ColumnInfo(name = "uploaded_date")
    @SerializedName("uploaded_date")
    val uploadedDate: String?,

    @ColumnInfo(name = "availability")
    @SerializedName("availability")
    val availability: String,

    @Embedded(prefix = "seller")
    @SerializedName("seller")
    val seller: SellerVO,

    @ColumnInfo(name = "isFavorite")
    val isFavorite: Int=0
)