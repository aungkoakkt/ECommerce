package com.akkt.ecommerce.persistence

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context
import com.akkt.ecommerce.data.vos.CategoryListVO
import com.akkt.ecommerce.data.vos.LoginUserVO
import com.akkt.ecommerce.data.vos.ProductVO
import com.akkt.ecommerce.persistence.dao.CategoryDao
import com.akkt.ecommerce.persistence.dao.LoginUserDao
import com.akkt.ecommerce.persistence.dao.ProductDao
import com.akkt.ecommerce.persistence.typeconverters.CategoryListConverter
import com.akkt.ecommerce.persistence.typeconverters.ProductImageUrlListConverter

/**
 *Created by Aung Ko Ko Thet on 4/25/19
 */
@Database(
    entities = arrayOf(
        LoginUserVO::class, ProductVO::class, CategoryListVO::class
    ), version = 1, exportSchema = false
)
@TypeConverters(CategoryListConverter::class, ProductImageUrlListConverter::class)
abstract class EcommerceDatabase : RoomDatabase() {

    abstract fun loginUserDao(): LoginUserDao
    abstract fun productDao(): ProductDao
    abstract fun categoryDao(): CategoryDao

    companion object {

        private val DB_NAME = "ECommerce.DB"
        private lateinit var INSTANCE: EcommerceDatabase

        fun getDatabase(context: Context): EcommerceDatabase {

            INSTANCE = Room.databaseBuilder(context, EcommerceDatabase::class.java, DB_NAME)
                .allowMainThreadQueries() //Remove this after testing. Access to DB should always be from background thread.
                .build()

            return INSTANCE
        }
    }

    fun isUserLogin(): Boolean {

        val count = loginUserDao().getUserCount()
        if (count > 0) {
            return true
        }
        return false
    }

    fun isProductAvailable(): Boolean {

        val count = productDao().getProductCount()
        if (count > 0) {
            return true
        }
        return false
    }

    fun isCategoryAvailable(): Boolean {

        val count = categoryDao().getCategoryCount()
        if (count > 0) {
            return true
        }
        return false
    }
}