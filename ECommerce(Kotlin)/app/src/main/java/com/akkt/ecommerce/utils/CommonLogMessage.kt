package com.akkt.ecommerce.utils

import android.util.Log
import com.akkt.ecommerce.EcommerceApp

/**
 *Created by Aung Ko Ko Thet on 4/25/19
 */
object CommonLogMessage {

    fun errorMessage(message: String) {
        Log.e(EcommerceApp.TAG, message)
    }

    fun debugMessage(message: String) {
        Log.d(EcommerceApp.TAG, message)
    }

    fun infoMessage(message: String) {
        Log.i(EcommerceApp.TAG, message)
    }

}