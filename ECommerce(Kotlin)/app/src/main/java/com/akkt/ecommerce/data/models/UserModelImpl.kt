package com.akkt.ecommerce.data.models

import android.content.Context
import android.util.Log
import com.akkt.ecommerce.EcommerceApp
import com.akkt.ecommerce.data.vos.LoginUserVO
import com.akkt.ecommerce.delegates.LoginDelegate
import com.akkt.ecommerce.delegates.RegisterDelegate

/**
 *Created by Aung Ko Ko Thet on 4/25/19
 */
class UserModelImpl private constructor(context: Context) : BaseModel(context),UserModel {

    override fun register(
        name: String,
        password: String,
        phone: String,
        dateOfBirth: String,
        location: String,
        registerDelegate: RegisterDelegate
    ) {
        mDataAgent.register(name,password,phone,dateOfBirth,location, object : RegisterDelegate {

            override fun success(message: String) {
                registerDelegate.success(message)
            }

            override fun onFail(message: String?) {
                registerDelegate.onFail(message)
            }
        })
    }

    override fun isUserLogin(): Boolean {
        return mDatabase.isUserLogin()
    }

    override fun login(phone: String, password: String, loginDelegate: LoginDelegate) {

        mDataAgent.login(phone,password,object :LoginDelegate{

            override fun onSuccess(loginUser: LoginUserVO?) {
                if (loginUser!=null){
                    mDatabase.loginUserDao().saveLoginUser(loginUser)
                    loginDelegate.onSuccess(loginUser)

                }else{
                    Log.e(EcommerceApp.TAG,"Insert fail Login User")
                }
            }

            override fun onFail(message: String?) {
                loginDelegate.onFail(message)
            }

        })
    }

    companion object {
        private var INSTANCE: UserModelImpl? = null
        fun getInstance(): UserModelImpl {
            if (INSTANCE == null) {
                throw RuntimeException("UserModel is being invoked before initializing.")
            }

            val i = INSTANCE
            return i!!
        }

        fun initUserModel(context : Context) {
            INSTANCE = UserModelImpl(context)
        }
    }

}