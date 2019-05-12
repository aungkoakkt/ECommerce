package com.akkt.ecommerce.mvp.presenters.impl

import com.akkt.ecommerce.data.models.*
import com.akkt.ecommerce.data.models.impl.FavoriteModelImpl
import com.akkt.ecommerce.data.models.impl.HistoryModelImpl
import com.akkt.ecommerce.data.models.impl.ProductModelImpl
import com.akkt.ecommerce.data.models.impl.UserModelImpl
import com.akkt.ecommerce.mvp.presenters.IBasePresenter

/**
 *Created by Aung Ko Ko Thet on 5/8/19
 */
abstract class BasePresenter : IBasePresenter {

    protected lateinit var mFavoriteModel: FavoriteModel
    protected lateinit var mHistoryModel: HistoryModel
    protected lateinit var mProductModel: ProductModel
    protected lateinit var mUserModel: UserModel

    override fun onCreate() {
        mFavoriteModel = FavoriteModelImpl
        mHistoryModel = HistoryModelImpl
        mProductModel = ProductModelImpl
        mUserModel = UserModelImpl
    }

    override fun onDestroy() {

    }
}