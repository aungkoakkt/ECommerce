package com.akkt.ecommerce.persistence.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.akkt.ecommerce.data.vos.ProductVO

/**
 *Created by Aung Ko Ko Thet on 4/26/19
 */
@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveProductList(productList: List<ProductVO>)

    @Query("select * from product")
    fun retrieveProductList(): List<ProductVO>

    @Query("select * from product where product_id=:productId")
    fun retrieveProductById(productId: Int): ProductVO

    @Query("select count(*) from product")
    fun getProductCount(): Int
}