package com.akkt.ecommerce.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.akkt.ecommerce.R
import com.akkt.ecommerce.adapters.ProductRecyclerAdapter
import com.akkt.ecommerce.data.vos.ProductVO
import com.akkt.ecommerce.mvp.presenters.ICategoryDetailPresenter
import com.akkt.ecommerce.mvp.presenters.impl.CategoryDetailPresenter
import com.akkt.ecommerce.mvp.views.CategoryDetailView
import com.akkt.ecommerce.utils.Constants
import kotlinx.android.synthetic.main.activity_category_detail.*

class CategoryDetailActivity : BaseActivity(), CategoryDetailView {

    private val mCategoryDetailPresenter: ICategoryDetailPresenter = CategoryDetailPresenter(this)
    private val mAdapter= ProductRecyclerAdapter(mCategoryDetailPresenter)

    companion object {
        fun newIntent(context: Context): Intent {
            val intent = Intent(context, CategoryDetailActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_detail)
        mCategoryDetailPresenter.onCreate()

        rvActivityCategoryDetail.layoutManager = GridLayoutManager(this, 2, RecyclerView.VERTICAL, false)
        rvActivityCategoryDetail.adapter = mAdapter

        val intent = intent
        val categoryId = intent.getIntExtra(Constants.CATEGORY_ID, 0)
        val categoryName = intent.getStringExtra(Constants.CATEGORY_NAME)
        tvActivityCategoryDetailName.text = categoryName

        mCategoryDetailPresenter.onUIReady(categoryId)
    }

    override fun onStart() {
        super.onStart()
        mCategoryDetailPresenter.onStart()
    }

    override fun onStop() {
        super.onStop()
        mCategoryDetailPresenter.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        mCategoryDetailPresenter.onDestroy()
    }

    override fun displayProduct(productList: List<ProductVO>) {
        mAdapter.setNewData(productList as MutableList<ProductVO>)
    }

    override fun displayFailToGetProductMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun navigateToProductDetailScreen(productId: Int) {
        val intent = ProductDetailActivity.newIntent(this)
        intent.putExtra(Constants.PRODUCT_ID, productId)
        startActivity(intent)
    }
}
