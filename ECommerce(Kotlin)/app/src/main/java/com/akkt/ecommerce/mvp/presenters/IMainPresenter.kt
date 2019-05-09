package com.akkt.ecommerce.mvp.presenters

/**
 *Created by Aung Ko Ko Thet on 5/9/19
 */
interface IMainPresenter:IBasePresenter {

    fun onUIReady()
    fun onTapHomeMenu()
    fun onTapProfileMenu()
    fun onTapFavoriteButton()
    fun onTapNavigationIcon()
}