package com.akkt.ecommerce.persistence.typeconverters

import android.arch.persistence.room.TypeConverter
import com.akkt.ecommerce.data.vos.CategoryListVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 *Created by Aung Ko Ko Thet on 4/26/19
 */
class CategoryListConverter {

    @TypeConverter
    fun fromListToJson(categoryList: List<CategoryListVO>): String {
        return Gson().toJson(categoryList)
    }

    @TypeConverter
    fun fromJsonToList(jsonString: String): List<CategoryListVO> {

        val listType = object : TypeToken<List<CategoryListVO>>() {}.type

        return Gson().fromJson(jsonString, listType)
    }

}