package com.akkt.ecommerce.persistence.typeconverters

import android.arch.persistence.room.TypeConverter
import java.util.*

/**
 *Created by Aung Ko Ko Thet on 5/7/19
 */
class DateConverter {

    @TypeConverter
    fun fromDateToLong(date: Date): Long {
        return date.time
    }

    @TypeConverter
    fun fromLongToDate(longDate: Long): Date {
        val date=Date()
        date.time=longDate
        return date
    }
}