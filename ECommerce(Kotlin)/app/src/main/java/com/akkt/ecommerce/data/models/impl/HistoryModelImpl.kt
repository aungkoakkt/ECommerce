package com.akkt.ecommerce.data.models.impl

import com.akkt.ecommerce.data.models.HistoryModel
import com.akkt.ecommerce.delegates.ProductDelegate
import com.akkt.ecommerce.persistence.entities.History

/**
 *Created by Aung Ko Ko Thet on 5/7/19
 */
object HistoryModelImpl : BaseModel(), HistoryModel {

    override fun getHistory(productDelegate: ProductDelegate) {

        val historyList=mDatabase.historyDao().retrieveHistory()

        when{
            historyList.isNotEmpty() -> productDelegate.getProductList(historyList)
            else->productDelegate.onFail("There is no History")
        }
    }

    override fun addToHistory(productId: Int) {
        mDatabase.historyDao().addHistory(History(productId = productId))
    }
}