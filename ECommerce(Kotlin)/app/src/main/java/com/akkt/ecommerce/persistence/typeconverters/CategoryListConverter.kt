package com.akkt.ecommerce.persistence.typeconverters

import android.arch.persistence.room.TypeConverter
import com.akkt.ecommerce.data.vos.CategoryVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 *Created by Aung Ko Ko Thet on 4/26/19
 */
class CategoryListConverter {

    @TypeConverter
    fun fromListToJson(category: List<CategoryVO>): String {
        return Gson().toJson(category)
    }

    @TypeConverter
    fun fromJsonToList(jsonString: String): List<CategoryVO> {

        val listType = object : TypeToken<List<CategoryVO>>() {}.type

        return Gson().fromJson(jsonString, listType)
    }

}