package com.akkt.ecommerce.mvp.presenters

/**
 *Created by Aung Ko Ko Thet on 5/9/19
 */
interface IProductDetailPresenter : IBasePresenter {

    fun onUIReady(productId: Int)
    fun onTapBackButton()
}