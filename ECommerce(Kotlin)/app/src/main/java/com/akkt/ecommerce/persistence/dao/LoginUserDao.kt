package com.akkt.ecommerce.persistence.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.akkt.ecommerce.data.vos.LoginUserVO

/**
 *Created by Aung Ko Ko Thet on 4/25/19
 */
@Dao
interface LoginUserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveLoginUser(loginUser: LoginUserVO): Long

    @Query("select count(*) from login_user")
    fun getUserCount(): Int

    @Query("select * from login_user")
    fun getUserInformation(): LoginUserVO
}