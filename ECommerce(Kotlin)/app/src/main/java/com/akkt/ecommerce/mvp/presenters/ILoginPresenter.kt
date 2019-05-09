package com.akkt.ecommerce.mvp.presenters

/**
 *Created by Aung Ko Ko Thet on 5/9/19
 */
interface ILoginPresenter:IBasePresenter {

    fun onTapLoginButton(phone: String, password: String)
    fun onTapRegisterText()
}