package com.akkt.ecommerce.data.vos

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 *Created by Aung Ko Ko Thet on 4/25/19
 */
@Entity(tableName = "category",indices = [Index("category_id")])
data class CategoryVO (

    @PrimaryKey
    @ColumnInfo(name = "category_id")
    @SerializedName("category_id")
    val categoryId: Int = 0,

    @ColumnInfo(name = "category_name")
    @SerializedName("category_name")
    val categoryName: String,

    @ColumnInfo(name = "category_icon")
    @SerializedName("category_icon")
    val categoryIcon: String,

    @ColumnInfo(name = "category_color")
    @SerializedName("category_color")
    val categoryColor: String

)