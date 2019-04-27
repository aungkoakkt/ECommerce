package com.akkt.ecommerce.persistence.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import com.akkt.ecommerce.persistence.entities.History

/**
 *Created by Aung Ko Ko Thet on 4/27/19
 */
@Dao
interface HistoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addHistory(history: History)
}