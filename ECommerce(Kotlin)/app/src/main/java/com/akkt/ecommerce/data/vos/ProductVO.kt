package com.akkt.ecommerce.data.vos

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 *Created by Aung Ko Ko Thet on 4/25/19
 */
@Entity(tableName = "product")
class ProductVO {

    @PrimaryKey
    @ColumnInfo(name = "product_id")
    @SerializedName("product_id")
    var productId: Int = 0

    @ColumnInfo(name = "product_name")
    @SerializedName("product_name")
    var productName: String? = null

    @ColumnInfo(name = "product_image_url")
    @SerializedName("product_image_url")
    var productImageUrl: List<ProductImageUrlVO>? = null

    @ColumnInfo(name = "product_desc")
    @SerializedName("product_desc")
    var productDesc: String? = null

    @ColumnInfo(name = "product_price")
    @SerializedName("product_price")
    var productPrice: String? = null

    @ColumnInfo(name = "category")
    @SerializedName("category")
    var category: List<CategoryListVO>? = null

    @ColumnInfo(name = "uploaded_time")
    @SerializedName("uploaded_time")
    var uploadedTime: String? = null

    @ColumnInfo(name = "uploaded_date")
    @SerializedName("uploaded_date")
    var uploadedDate: String? = null

    @ColumnInfo(name = "availability")
    @SerializedName("availability")
    var availability: String? = null

    @Embedded(prefix = "seller")
    @SerializedName("seller")
    var seller: SellerVO? = null
}