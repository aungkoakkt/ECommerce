package com.akkt.ecommerce

import android.app.Application
import com.akkt.ecommerce.data.models.impl.FavoriteModelImpl
import com.akkt.ecommerce.data.models.impl.HistoryModelImpl
import com.akkt.ecommerce.data.models.impl.ProductModelImpl
import com.akkt.ecommerce.data.models.impl.UserModelImpl

/**
 *Created by Aung Ko Ko Thet on 4/25/19
 */
class EcommerceApp : Application() {

    companion object {
        const val TAG = "EcommerceApp"
    }

    override fun onCreate() {
        super.onCreate()
        UserModelImpl.initDB(applicationContext)
        ProductModelImpl.initDB(applicationContext)
        FavoriteModelImpl.initDB(applicationContext)
        HistoryModelImpl.initDB(applicationContext)
    }
}