package com.akkt.ecommerce.network.responses

import com.google.gson.annotations.SerializedName

/**
 *Created by Aung Ko Ko Thet on 4/24/19
 */

abstract class BaseResponse {
    @SerializedName("code")
    private val code: Int = 0

    @SerializedName("message")
    var message: String? = null

    fun isResponseSuccess():Boolean{
        return this.code ==200
    }
}