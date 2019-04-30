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
import com.akkt.ecommerce.data.models.FavoriteModel
import com.akkt.ecommerce.data.models.FavoriteModelImpl
import com.akkt.ecommerce.data.models.ProductModel
import com.akkt.ecommerce.data.models.ProductModelImpl
import com.akkt.ecommerce.data.vos.CategoryVO
import com.akkt.ecommerce.data.vos.ProductVO
import com.akkt.ecommerce.delegates.CategoryDelegate
import com.akkt.ecommerce.delegates.CategoryItemDelegate
import com.akkt.ecommerce.delegates.ProductDelegate
import com.akkt.ecommerce.delegates.ProductItemDelegate
import com.akkt.ecommerce.network.ECommerceDataAgent
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), ProductItemDelegate, CategoryItemDelegate {

    private val mCategoryAdapter: CategoryRecyclerAdapter = CategoryRecyclerAdapter(this)
    private val mProductAdapter: ProductRecyclerAdapter = ProductRecyclerAdapter(this)

    private val mProductModel: ProductModel
    private val mFavoriteModel: FavoriteModel

    init {
        mProductModel = ProductModelImpl
        mFavoriteModel = FavoriteModelImpl
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvFragmentHomeCategories.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        rvFragmentHomeProducts.layoutManager = GridLayoutManager(context, 2, RecyclerView.VERTICAL, false)

        rvFragmentHomeCategories.adapter = mCategoryAdapter
        rvFragmentHomeProducts.adapter = mProductAdapter

        mProductModel.getCategoryList(ECommerceDataAgent.ACCESS_TOKEN, 1, object : CategoryDelegate {
            override fun getCategoryList(category: List<CategoryVO>) {
                mCategoryAdapter.setNewData(category as MutableList<CategoryVO>)
            }

            override fun onFail(message: String) {
                Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
            }

        })

        mProductModel.getProductList(ECommerceDataAgent.ACCESS_TOKEN, 1, object : ProductDelegate {
            override fun onFail(message: String) {
                Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
            }

            override fun getProductList(productlist: List<ProductVO>) {
                mProductAdapter.setNewData(productlist as MutableList<ProductVO>)
            }

        })
    }

    override fun onTapProduct(product: ProductVO) {
        val intent = ProductDetailActivity.newIntent(context!!)
        intent.putExtra("product_id", product.productId)
        startActivity(intent)
    }

    override fun onTapFavorite(product: ProductVO) {
        val id = mFavoriteModel.addToFavorite(product)
        if (id > 0) {
            Toast.makeText(context, "Added to favorite list", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(context, "Already added.", Toast.LENGTH_LONG).show()
        }
    }

    override fun onTapCategoryItem(category: CategoryVO) {
        val intent = CategoryDetailActivity.newIntent(context!!)
        intent.putExtra("id", category.categoryId)
        intent.putExtra("name", category.categoryName)
        startActivity(intent)
    }
}
