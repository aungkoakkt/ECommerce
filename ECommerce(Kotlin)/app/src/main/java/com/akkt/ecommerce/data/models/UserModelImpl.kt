package com.akkt.ecommerce.data.models

import com.akkt.ecommerce.data.vos.LoginUserVO
import com.akkt.ecommerce.delegates.LoginDelegate
import com.akkt.ecommerce.delegates.RegisterDelegate
import com.akkt.ecommerce.network.responses.GetLoginUserResponse
import com.akkt.ecommerce.utils.CommonLogMessage

/**
 *Created by Aung Ko Ko Thet on 4/25/19
 */
object UserModelImpl : BaseModel(), UserModel {

    override fun register(
        name: String,
        password: String,
        phone: String,
        dateOfBirth: String,
        location: String,
        registerDelegate: RegisterDelegate
    ) {
        mDataAgent.register(name, password, phone, dateOfBirth, location, object : RegisterDelegate {

            override fun success(message: String) {
                registerDelegate.success(message)
            }

            override fun onFail(message: String) {
                registerDelegate.onFail(message)
            }
        })
    }

    override fun isUserLogin(): Boolean {
        return mDatabase.isUserLogin()
    }

    override fun login(phone: String, password: String, loginDelegate: LoginDelegate) {

        mDataAgent.login(phone, password, object : LoginDelegate {

            override fun onSuccess(loginUser: GetLoginUserResponse) {
                mDatabase.loginUserDao().saveLoginUser(loginUser.loginUser)
                CommonLogMessage.debugMessage(loginUser.favouriteList.size.toString())
                loginDelegate.onSuccess(loginUser)

            }

            override fun onFail(message: String) {
                loginDelegate.onFail(message)
            }

        })
    }

    override fun getUserInformation(): LoginUserVO {

        val loginUser = mDatabase.loginUserDao().getUserInformation()

        return loginUser
    }

}