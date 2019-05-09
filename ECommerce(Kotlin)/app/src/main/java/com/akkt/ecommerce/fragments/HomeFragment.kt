package com.akkt.ecommerce.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.akkt.ecommerce.R
import com.akkt.ecommerce.activities.CategoryDetailActivity
import com.akkt.ecommerce.activities.ProductDetailActivity
import com.akkt.ecommerce.adapters.CategoryRecyclerAdapter
import com.akkt.ecommerce.adapters.ProductRecyclerAdapter
import com.akkt.ecommerce.data.vos.CategoryVO
import com.akkt.ecommerce.data.vos.ProductVO
import com.akkt.ecommerce.mvp.presenters.HomePresenter
import com.akkt.ecommerce.mvp.presenters.IHomePresenter
import com.akkt.ecommerce.mvp.views.HomeView
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), HomeView {

    private val mCategoryAdapter: CategoryRecyclerAdapter
    private val mProductAdapter: ProductRecyclerAdapter

    private val mHomePresenter: IHomePresenter

    init {
        mHomePresenter = HomePresenter(this)
        mProductAdapter = ProductRecyclerAdapter(mHomePresenter)
        mCategoryAdapter = CategoryRecyclerAdapter(mHomePresenter)
    }

    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mHomePresenter.onCreate()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvFragmentHomeCategories.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        rvFragmentHomeProducts.layoutManager = GridLayoutManager(context, 2, RecyclerView.VERTICAL, false)

        rvFragmentHomeCategories.adapter = mCategoryAdapter
        rvFragmentHomeProducts.adapter = mProductAdapter

        mHomePresenter.onUIReady()
    }

    override fun onStart() {
        super.onStart()
        mHomePresenter.onStart()
    }

    override fun onStop() {
        super.onStop()
        mHomePresenter.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        mHomePresenter.onDestroy()
    }

    override fun displayCategory(categoryList: List<CategoryVO>) {
        mCategoryAdapter.setNewData(categoryList as MutableList<CategoryVO>)
    }

    override fun displayProduct(productList: List<ProductVO>) {
        mProductAdapter.setNewData(productList as MutableList<ProductVO>)
    }

    override fun displayFailMessageForCategory(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
    }

    override fun displayFailMessageForProduct(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
    }

    override fun navigateToProductDetail(productId: Int) {
        val intent = ProductDetailActivity.newIntent(context!!)
        intent.putExtra("product_id", productId)
        startActivity(intent)
    }

    override fun navigateToCategoryDetail(categoryId: Int, categoryName: String) {
        val intent = CategoryDetailActivity.newIntent(context!!)
        intent.putExtra("id", categoryId)
        intent.putExtra("name", categoryName)
        startActivity(intent)
    }

}
