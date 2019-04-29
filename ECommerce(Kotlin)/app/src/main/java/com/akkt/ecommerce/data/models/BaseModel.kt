package com.akkt.ecommerce.data.models

import android.content.Context
import com.akkt.ecommerce.network.ECommerceDA
import com.akkt.ecommerce.network.ECommerceDataAgent
import com.akkt.ecommerce.persistence.EcommerceDatabase

/**
 *Created by Aung Ko Ko Thet on 4/25/19
 */
abstract class BaseModel {

    val mDataAgent: ECommerceDataAgent = ECommerceDA.getInstance()
    lateinit var mDatabase: EcommerceDatabase

    fun initDB(context : Context) {
        mDatabase = EcommerceDatabase.getDatabase(context)
    }

}