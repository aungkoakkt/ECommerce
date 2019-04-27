package com.akkt.ecommerce.data.models

import com.akkt.ecommerce.data.vos.LoginUserVO
import com.akkt.ecommerce.delegates.LoginDelegate
import com.akkt.ecommerce.delegates.RegisterDelegate

/**
 *Created by Aung Ko Ko Thet on 4/25/19
 */
interface UserModel {

    fun login(phone: String, password: String, loginDelegate: LoginDelegate)

    fun register(
        name: String,
        password: String,
        phone: String,
        dateOfBirth: String,
        location: String,
        registerDelegate: RegisterDelegate
    )

    fun isUserLogin(): Boolean

    fun getUserInformation(): LoginUserVO
}