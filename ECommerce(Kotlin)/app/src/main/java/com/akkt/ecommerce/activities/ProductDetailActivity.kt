package com.akkt.ecommerce.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import com.akkt.ecommerce.R
import com.akkt.ecommerce.data.vos.ProductVO
import com.akkt.ecommerce.mvp.presenters.IProductDetailPresenter
import com.akkt.ecommerce.mvp.presenters.ProductDetailPresenter
import com.akkt.ecommerce.mvp.views.ProductDetailView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_product_detail.*

class ProductDetailActivity : BaseActivity(), ProductDetailView {

    private val mProductDetailPresenter: IProductDetailPresenter

    init {
        mProductDetailPresenter = ProductDetailPresenter(this)
    }

    companion object {
        fun newIntent(context: Context): Intent {
            val intent = Intent(context, ProductDetailActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)
        mProductDetailPresenter.onCreate()

        tvActivityProductDetailDescription.movementMethod = ScrollingMovementMethod()
        val intent = intent
        val productId = intent.getIntExtra("product_id", 0)

        mProductDetailPresenter.onUIReady(productId)

        ivActivityProductDetailBack.setOnClickListener { mProductDetailPresenter.onTapBackButton() }
    }

    override fun onStart() {
        super.onStart()
        mProductDetailPresenter.onStart()
    }

    override fun onStop() {
        super.onStop()
        mProductDetailPresenter.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        mProductDetailPresenter.onDestroy()
    }

    override fun displayProduct(product: ProductVO) {
        Glide.with(this).load(product.productImageUrl[0].image_url).into(ivActivityProductDetailImage)
        tvActivityProductDetailName.text = product.productName
        tvActivityProductDetailPrice.text = product.productPrice
        tvActivityProductDetailDescription.text = product.productDesc
        tvActivityProductDetailSeller.text = product.seller.name
    }

    override fun finishActivity() {
        finish()
    }
}
