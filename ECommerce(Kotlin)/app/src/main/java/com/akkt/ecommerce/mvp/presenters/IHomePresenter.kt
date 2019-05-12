package com.akkt.ecommerce.mvp.presenters

import com.akkt.ecommerce.delegates.CategoryItemDelegate
import com.akkt.ecommerce.delegates.ProductItemDelegate

/**
 *Created by Aung Ko Ko Thet on 5/8/19
 */
interface IHomePresenter: IBasePresenter, ProductItemDelegate, CategoryItemDelegate {

    fun onUIReady()
}