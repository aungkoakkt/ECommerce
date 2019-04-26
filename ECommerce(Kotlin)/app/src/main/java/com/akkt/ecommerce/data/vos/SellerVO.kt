package com.akkt.ecommerce.data.vos

import android.arch.persistence.room.ColumnInfo
import com.google.gson.annotations.SerializedName

/**
 *Created by Aung Ko Ko Thet on 4/26/19
 */
class SellerVO {

    @ColumnInfo(name = "seller_id")
    @SerializedName("seller_id")
    var sellerId: Int = 0

    @ColumnInfo(name = "name")
    @SerializedName("name")
    var name: String? = null

    @ColumnInfo(name = "phone_no")
    @SerializedName("phone_no")
    var phone: String? = null

    @ColumnInfo(name = "address")
    @SerializedName("address")
    var address: String? = null

    @ColumnInfo(name = "profile_image")
    @SerializedName("profile_image")
    var profileImage: String? = null
}