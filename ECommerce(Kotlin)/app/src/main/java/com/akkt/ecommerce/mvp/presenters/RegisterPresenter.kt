package com.akkt.ecommerce.mvp.presenters

import com.akkt.ecommerce.delegates.RegisterDelegate
import com.akkt.ecommerce.mvp.views.RegisterView

/**
 *Created by Aung Ko Ko Thet on 5/9/19
 */
class RegisterPresenter(val mRegisterView: RegisterView) : BasePresenter(), IRegisterPresenter {

    override fun onTapRegisterButton(name: String, phone: String, password: String, birthday: String, address: String) {

        mUserModel.register(name, password, phone, birthday, address, object : RegisterDelegate {
            override fun success(message: String) {
                mRegisterView.displaySuccessMessage(message)
            }

            override fun onFail(message: String) {
                mRegisterView.displayFailMessage(message)
            }
        })

    }

    override fun onTapBackButton() {
        mRegisterView.finishActivity()
    }

    override fun onStart() {

    }

    override fun onStop() {

    }
}