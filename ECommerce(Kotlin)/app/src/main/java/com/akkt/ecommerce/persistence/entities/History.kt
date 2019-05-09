package com.akkt.ecommerce.persistence.entities

import android.arch.persistence.room.*
import com.akkt.ecommerce.data.vos.ProductVO
import java.util.*

/**
 *Created by Aung Ko Ko Thet on 4/27/19
 */
@Entity(
    tableName = "history",
    indices = [Index("product_id",unique = true)],
    foreignKeys = [ForeignKey(
        entity = ProductVO::class
        , parentColumns = ["product_id"], childColumns = ["product_id"]
    )]
)
data class History(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "history_id")
    val historyId: Int? = null,

    @ColumnInfo(name = "product_id")
    val productId: Int,

    @ColumnInfo(name = "updated_at")
    val date: Date = Date()
)