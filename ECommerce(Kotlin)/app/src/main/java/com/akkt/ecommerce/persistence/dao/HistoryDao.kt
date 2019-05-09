package com.akkt.ecommerce.persistence.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.akkt.ecommerce.data.vos.ProductVO
import com.akkt.ecommerce.persistence.entities.History

/**
 *Created by Aung Ko Ko Thet on 4/27/19
 */
@Dao
interface HistoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addHistory(history: History)

    @Query("select b.* from history as a inner join product as b on a.product_id=b.product_id order by updated_at desc")
    fun retrieveHistory(): List<ProductVO>
}