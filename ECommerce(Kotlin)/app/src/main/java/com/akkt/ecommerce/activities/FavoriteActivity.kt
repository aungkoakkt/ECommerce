package com.akkt.ecommerce.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.widget.Toast
import com.akkt.ecommerce.R
import com.akkt.ecommerce.adapters.FavoriteRecyclerAdapter
import com.akkt.ecommerce.data.vos.ProductVO
import com.akkt.ecommerce.mvp.presenters.FavoritePresenter
import com.akkt.ecommerce.mvp.presenters.IFavoritePresenter
import com.akkt.ecommerce.mvp.views.FavoriteView
import kotlinx.android.synthetic.main.activity_favorite.*

class FavoriteActivity : BaseActivity(), FavoriteView {

    private val mFavoriteAdapter: FavoriteRecyclerAdapter
    private val mFavoritePresenter: IFavoritePresenter

    init {
        mFavoritePresenter = FavoritePresenter(this)
        mFavoriteAdapter = FavoriteRecyclerAdapter(mFavoritePresenter)
    }

    companion object {
        fun newIntent(context: Context): Intent {
            val intent = Intent(context, FavoriteActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)
        mFavoritePresenter.onCreate()

        rvActivityFavorite.layoutManager = StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)

        rvActivityFavorite.adapter = mFavoriteAdapter

        mFavoritePresenter.onUIReady()

    }

    override fun onStart() {
        super.onStart()
        mFavoritePresenter.onStart()
    }

    override fun onStop() {
        super.onStop()
        mFavoritePresenter.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        mFavoritePresenter.onDestroy()
    }

    override fun displayFavoriteList(productList: List<ProductVO>) {
        mFavoriteAdapter.setNewData(productList as MutableList<ProductVO>)
    }

    override fun displayFailMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun navigateToProductDetail(productId: Int) {
        val intent = ProductDetailActivity.newIntent(this)
        intent.putExtra("product_id", productId)
        startActivity(intent)
    }
}
