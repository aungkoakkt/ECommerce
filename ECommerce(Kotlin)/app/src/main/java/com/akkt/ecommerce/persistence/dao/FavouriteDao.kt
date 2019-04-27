package com.akkt.ecommerce.persistence.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import com.akkt.ecommerce.persistence.entities.FavouriteProduct

/**
 *Created by Aung Ko Ko Thet on 4/27/19
 */
@Dao
interface FavouriteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addFavourite(favourite: FavouriteProduct)
}