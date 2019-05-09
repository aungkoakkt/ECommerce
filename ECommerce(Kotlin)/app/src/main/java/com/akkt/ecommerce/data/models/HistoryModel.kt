package com.akkt.ecommerce.data.models

import com.akkt.ecommerce.delegates.ProductDelegate

/**
 *Created by Aung Ko Ko Thet on 5/7/19
 */
interface HistoryModel {

    fun getHistory(productDelegate: ProductDelegate)
    fun addToHistory(productId: Int)
}