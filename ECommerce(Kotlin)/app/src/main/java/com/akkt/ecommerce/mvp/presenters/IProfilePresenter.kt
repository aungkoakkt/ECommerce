package com.akkt.ecommerce.mvp.presenters

import com.akkt.ecommerce.delegates.ProductItemDelegate

/**
 *Created by Aung Ko Ko Thet on 5/9/19
 */
interface IProfilePresenter: IBasePresenter,ProductItemDelegate {

    fun onUIReady()
}