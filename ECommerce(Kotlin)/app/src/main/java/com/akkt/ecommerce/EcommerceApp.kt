package com.akkt.ecommerce

import android.app.Application
import com.akkt.ecommerce.data.models.ProductModelImpl
import com.akkt.ecommerce.data.models.UserModelImpl

/**
 *Created by Aung Ko Ko Thet on 4/25/19
 */
class EcommerceApp : Application() {

    companion object {
        const val TAG = "EcommerceApp"
    }

    override fun onCreate() {
        super.onCreate()
        UserModelImpl.initUserModel(applicationContext)
        ProductModelImpl.initCategoryModelImpl(applicationContext)
    }
}