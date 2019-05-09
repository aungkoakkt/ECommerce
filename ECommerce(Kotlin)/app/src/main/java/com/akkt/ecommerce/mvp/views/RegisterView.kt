package com.akkt.ecommerce.mvp.views

/**
 *Created by Aung Ko Ko Thet on 5/9/19
 */
interface RegisterView {

    fun displayFailMessage(message: String)
    fun displaySuccessMessage(message: String)
    fun finishActivity()

}