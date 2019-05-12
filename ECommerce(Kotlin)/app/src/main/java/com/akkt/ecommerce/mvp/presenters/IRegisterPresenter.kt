package com.akkt.ecommerce.mvp.presenters

/**
 *Created by Aung Ko Ko Thet on 5/9/19
 */
interface IRegisterPresenter: IBasePresenter {

    fun onTapRegisterButton(name: String, phone: String, password: String, birthday: String, address: String)
    fun onTapBackButton()
}