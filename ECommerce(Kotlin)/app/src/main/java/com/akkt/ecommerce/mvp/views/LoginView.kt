package com.akkt.ecommerce.mvp.views

/**
 *Created by Aung Ko Ko Thet on 5/9/19
 */
interface LoginView {

    fun displayFailToLoginMessage(message:String)
    fun navigateToMain()
    fun navigateToRegister()
}