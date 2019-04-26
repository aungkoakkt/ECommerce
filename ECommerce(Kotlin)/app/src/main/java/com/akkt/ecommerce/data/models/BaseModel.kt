package com.akkt.ecommerce.data.models

import android.content.Context
import com.akkt.ecommerce.network.ECommerceDA
import com.akkt.ecommerce.network.ECommerceDataAgent
import com.akkt.ecommerce.persistence.EcommerceDatabase

/**
 *Created by Aung Ko Ko Thet on 4/25/19
 */
abstract class BaseModel(context: Context) {

    var mDataAgent: ECommerceDataAgent = ECommerceDA.getInstance()
    var mDatabase: EcommerceDatabase = EcommerceDatabase.getDatabase(context)

}