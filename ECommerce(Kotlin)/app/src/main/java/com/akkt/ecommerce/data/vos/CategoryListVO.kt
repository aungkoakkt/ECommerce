package com.akkt.ecommerce.data.vos

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 *Created by Aung Ko Ko Thet on 4/25/19
 */
@Entity(tableName = "category")
class CategoryListVO {

    @PrimaryKey
    @ColumnInfo(name = "categoryId")
    @SerializedName("category_id")
    var categoryId: Int = 0

    @ColumnInfo(name = "category_name")
    @SerializedName("category_name")
    var categoryName: String? = null

    @ColumnInfo(name = "category_icon")
    @SerializedName("category_icon")
    var categoryIcon: String? = null

    @ColumnInfo(name = "category_color")
    @SerializedName("category_color")
    var categoryColor: String? = null

}