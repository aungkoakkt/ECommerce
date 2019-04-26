package com.akkt.ecommerce.persistence.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.akkt.ecommerce.data.vos.CategoryListVO

/**
 *Created by Aung Ko Ko Thet on 4/26/19
 */
@Dao
interface CategoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveCategoryList(categoryList: List<CategoryListVO>)

    @Query("select * from category")
    fun retrieveCategoryList(): List<CategoryListVO>

    @Query("select count(*) from category")
    fun getCategoryCount(): Int

}