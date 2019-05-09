package com.akkt.ecommerce.mvp.presenters

import com.akkt.ecommerce.delegates.LoginDelegate
import com.akkt.ecommerce.mvp.views.LoginView
import com.akkt.ecommerce.network.responses.GetLoginUserResponse

/**
 *Created by Aung Ko Ko Thet on 5/9/19
 */
class LoginPresenter(val mLoginView: LoginView) : BasePresenter(), ILoginPresenter {

    override fun onTapLoginButton(phone: String, password: String) {

        mUserModel.login(phone,password, object : LoginDelegate {
            override fun onSuccess(loginUser: GetLoginUserResponse) {
                mLoginView.navigateToMain()
            }

            override fun onFail(message: String) {
                mLoginView.displayFailToLoginMessage(message)
            }
        })
    }

    override fun onTapRegisterText() {
        mLoginView.navigateToRegister()
    }

    override fun onStart() {

    }

    override fun onStop() {

    }
}