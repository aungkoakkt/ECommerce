package com.akkt.ecommerce.data.models.impl

import com.akkt.ecommerce.data.models.ProductModel
import com.akkt.ecommerce.data.vos.CategoryVO
import com.akkt.ecommerce.data.vos.ProductVO
import com.akkt.ecommerce.delegates.CategoryDelegate
import com.akkt.ecommerce.delegates.ProductDelegate
import com.akkt.ecommerce.delegates.ProductDetailDelegate
import com.akkt.ecommerce.persistence.entities.CategoryProduct

/**
 *Created by Aung Ko Ko Thet on 4/26/19
 */
object ProductModelImpl : BaseModel(), ProductModel {

    override fun getCategoryList(accessToken: String, page: Int, categoryDelegate: CategoryDelegate): List<CategoryVO> {

        val categoryList = mDatabase.categoryDao().retrieveCategoryList()

        mDataAgent.loadCategoryList(accessToken, page, object : CategoryDelegate {
            override fun getCategoryList(category: List<CategoryVO>) {
                mDatabase.categoryDao().saveCategoryList(category)
                val categoryListDB = mDatabase.categoryDao().retrieveCategoryList()
                categoryDelegate.getCategoryList(categoryListDB)
            }

            override fun onFail(message: String) {

                if (mDatabase.isCategoryAvailable()) {
                    val categoryListDB = mDatabase.categoryDao().retrieveCategoryList()
                    categoryDelegate.getCategoryList(categoryListDB)
                } else {
                    categoryDelegate.onFail(message)
                }
            }

        })

        return categoryList
    }

    override fun getProductList(accessToken: String, page: Int, productDelegate: ProductDelegate): List<ProductVO> {

        val productList = mDatabase.productDao().retrieveProductList()

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

            override fun onFail(message: String) {
                if (mDatabase.isProductAvailable()) {
                    val productListDB = mDatabase.productDao().retrieveProductList()
                    productDelegate.getProductList(productListDB)
                } else {
                    productDelegate.onFail(message)
                }
            }

        })

        return productList
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

}