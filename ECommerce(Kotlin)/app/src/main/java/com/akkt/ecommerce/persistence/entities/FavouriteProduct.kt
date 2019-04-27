package com.akkt.ecommerce.persistence.entities

import android.arch.persistence.room.*
import com.akkt.ecommerce.data.vos.ProductVO

/**
 *Created by Aung Ko Ko Thet on 4/27/19
 */
@Entity(
    tableName = "favourite_product",
    indices = [Index("product_id")],
    foreignKeys = [ForeignKey(
        entity = ProductVO::class
        , parentColumns = ["product_id"], childColumns = ["product_id"]
    )]
)
data class FavouriteProduct(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "favourite_pk")
    val favouritePk: Int,

    @ColumnInfo(name = "product_id")
    val productId: Int
)