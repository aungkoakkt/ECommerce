package com.akkt.ecommerce.persistence.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.akkt.ecommerce.data.vos.FavoriteVO
import com.akkt.ecommerce.data.vos.ProductVO

/**
 *Created by Aung Ko Ko Thet on 4/27/19
 */
@Dao
interface FavouriteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addFavouriteList(favourite: List<FavoriteVO>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addFavoriteProduct(favorite: FavoriteVO): Long

    @Query("select b.* from favorite as a inner join product as b on a.product_id=b.product_id")
    fun retrieveFavoriteProducts(): List<ProductVO>
}