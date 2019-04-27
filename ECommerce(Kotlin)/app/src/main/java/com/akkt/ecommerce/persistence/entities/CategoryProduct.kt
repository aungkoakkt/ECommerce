package com.akkt.ecommerce.persistence.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import com.akkt.ecommerce.data.vos.CategoryVO
import com.akkt.ecommerce.data.vos.ProductVO

/**
 *Created by Aung Ko Ko Thet on 4/27/19
 */
@Entity(
    tableName = "category_product",
    primaryKeys = ["product_id", "category_id"],
    foreignKeys = [
        ForeignKey(
            entity = ProductVO::class,
            parentColumns = ["product_id"], childColumns = ["product_id"]
        ),
        ForeignKey(
            entity = CategoryVO::class,
            parentColumns = ["category_id"], childColumns = ["category_id"]
        )]
)
data class CategoryProduct(

    @ColumnInfo(name = "product_id")
    val productId: Int,

    @ColumnInfo(name = "category_id")
    val categoryId: Int

)