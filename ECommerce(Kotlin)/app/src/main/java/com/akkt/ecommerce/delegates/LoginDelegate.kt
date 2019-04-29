package com.akkt.ecommerce.delegates

import com.akkt.ecommerce.network.responses.GetLoginUserResponse

/**
 *Created by Aung Ko Ko Thet on 4/24/19
 */
interface LoginDelegate :BaseNetworkDelegate {

    fun onSuccess(loginUser :GetLoginUserResponse)
}