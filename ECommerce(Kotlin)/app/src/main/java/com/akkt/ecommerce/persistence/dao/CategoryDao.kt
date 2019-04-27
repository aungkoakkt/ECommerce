package com.akkt.ecommerce.persistence.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.akkt.ecommerce.data.vos.CategoryVO
import com.akkt.ecommerce.data.vos.ProductVO

/**
 *Created by Aung Ko Ko Thet on 4/26/19
 */
@Dao
interface CategoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveCategoryList(category: List<CategoryVO>)

    @Query("select * from category")
    fun retrieveCategoryList(): List<CategoryVO>

    @Query("select count(*) from category")
    fun getCategoryCount(): Int

    @Query("select c.* from category as a inner join category_product as b on a.category_id=b.category_id inner join product as c on b.product_id=c.product_id where a.category_id=:categoryId")
    fun getProductListByCategoryId(categoryId:Int):List<ProductVO>

}