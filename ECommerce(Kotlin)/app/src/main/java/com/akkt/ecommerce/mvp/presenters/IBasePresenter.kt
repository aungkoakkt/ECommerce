package com.akkt.ecommerce.mvp.presenters

/**
 *Created by Aung Ko Ko Thet on 5/8/19
 */
interface IBasePresenter {

    fun onCreate()
    fun onStart()
    fun onStop()
    fun onDestroy()
}