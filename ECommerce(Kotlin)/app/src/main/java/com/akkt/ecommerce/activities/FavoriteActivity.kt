package com.akkt.ecommerce.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.akkt.ecommerce.R
import com.akkt.ecommerce.adapters.ProductRecyclerAdapter
import com.akkt.ecommerce.data.models.FavoriteModel
import com.akkt.ecommerce.data.models.FavoriteModelImpl
import com.akkt.ecommerce.data.vos.ProductVO
import com.akkt.ecommerce.delegates.FavoriteDelegate
import com.akkt.ecommerce.delegates.ProductItemDelegate
import kotlinx.android.synthetic.main.activity_favorite.*

class FavoriteActivity : AppCompatActivity(), ProductItemDelegate {

    private val mProductAdapter: ProductRecyclerAdapter
    private val mFavoriteModel: FavoriteModel

    init {
        mFavoriteModel = FavoriteModelImpl
        mProductAdapter = ProductRecyclerAdapter(this)
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

        rvActivityFavorite.layoutManager = GridLayoutManager(this, 2, RecyclerView.VERTICAL, false)

        rvActivityFavorite.adapter = mProductAdapter

        mFavoriteModel.getFavoriteProduct(object : FavoriteDelegate {

            override fun onSuccesGettingFavoriteProduct(productList: List<ProductVO>) {
                mProductAdapter.setNewData(productList as MutableList<ProductVO>)
            }

            override fun onFailGettingFavoriteProduct(message: String) {
                Toast.makeText(this@FavoriteActivity, message, Toast.LENGTH_LONG).show()
            }

        })
    }

    override fun onTapProduct(product: ProductVO) {
        val intent = ProductDetailActivity.newIntent(this)
        intent.putExtra("product_id", product.productId)
        startActivity(intent)
    }

    override fun onTapFavorite(product: ProductVO) {

    }
}
