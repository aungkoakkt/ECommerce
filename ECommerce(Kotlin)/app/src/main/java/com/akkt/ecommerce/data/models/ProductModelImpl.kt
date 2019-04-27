package com.akkt.ecommerce.data.models

import android.content.Context
import com.akkt.ecommerce.data.vos.CategoryVO
import com.akkt.ecommerce.data.vos.ProductVO
import com.akkt.ecommerce.delegates.CategoryDelegate
import com.akkt.ecommerce.delegates.ProductDelegate
import com.akkt.ecommerce.delegates.ProductDetailDelegate
import com.akkt.ecommerce.persistence.entities.CategoryProduct
import com.akkt.ecommerce.persistence.entities.History
import java.lang.RuntimeException

/**
 *Created by Aung Ko Ko Thet on 4/26/19
 */
class ProductModelImpl private constructor(context: Context) : BaseModel(context), ProductModel {

    companion object {
        private var INSTANCE: ProductModelImpl? = null

        fun getInsatnce(): ProductModelImpl {
            if (INSTANCE == null) {
                throw RuntimeException("ProductModelImpl must be initialized before using it.")
            }

            return INSTANCE!!
        }

        fun initCategoryModelImpl(context: Context) {
            INSTANCE = ProductModelImpl(context)
        }

    }

    override fun getCategoryList(accessToken: String, page: Int, categoryDelegate: CategoryDelegate) {

        mDataAgent.loadCategoryList(accessToken, page, object : CategoryDelegate {
            override fun getCategoryList(category: List<CategoryVO>) {
                mDatabase.categoryDao().saveCategoryList(category)
                val categoryListDB = mDatabase.categoryDao().retrieveCategoryList()
                categoryDelegate.getCategoryList(categoryListDB)
            }

            override fun onFail(message: String?) {

                if (mDatabase.isCategoryAvailable()) {
                    val categoryListDB = mDatabase.categoryDao().retrieveCategoryList()
                    categoryDelegate.getCategoryList(categoryListDB)
                } else {
                    categoryDelegate.onFail(message)
                }
            }

        })
    }

    override fun getProductList(accessToken: String, page: Int, productDelegate: ProductDelegate) {

        mDataAgent.loadProductList(accessToken, page, object : ProductDelegate {

            override fun getProductList(productlist: List<ProductVO>) {
                mDatabase.productDao().saveProductList(productlist)
                val productListDB = mDatabase.productDao().retrieveProductList()

                val ids = mutableListOf<CategoryProduct>()

                for (product in productListDB) {

                    for (category in product.category) {
                        val categoryProduct =
                            CategoryProduct(productId = product.productId, categoryId = category.categoryId)
                        ids.add(categoryProduct)
                    }

                    mDatabase.productDao().saveCategoryAndProduct(ids)
                    ids.clear()
                }
                productDelegate.getProductList(productListDB)
            }

            override fun onFail(message: String?) {
                if (mDatabase.isProductAvailable()) {
                    val productListDB = mDatabase.productDao().retrieveProductList()
                    productDelegate.getProductList(productListDB)
                } else {
                    productDelegate.onFail(message)
                }
            }

        })
    }

    override fun getProductListByCategoryId(categoryId: Int, productDelegate: ProductDelegate) {
        val productList = mDatabase.categoryDao().getProductListByCategoryId(categoryId)

        if (productList.isEmpty()) {
            productDelegate.onFail("This is no product for that category.")
        } else {
            productDelegate.getProductList(productList)
        }

    }

    override fun getProductDetail(productId: Int, delegate: ProductDetailDelegate) {

        val product = mDatabase.productDao().retrieveProductById(productId)
        delegate.getProductDetail(product)
    }

    override fun addToHistory(productId: Int) {
        mDatabase.historyDao().addHistory(History(productId = productId))
    }
}