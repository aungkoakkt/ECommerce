package com.akkt.ecommerce.activities

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import com.akkt.ecommerce.R
import com.akkt.ecommerce.data.models.ProductModel
import com.akkt.ecommerce.data.models.ProductModelImpl
import com.akkt.ecommerce.data.vos.ProductVO
import com.akkt.ecommerce.delegates.ProductDetailDelegate
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_product_detail.*

class ProductDetailActivity : AppCompatActivity(), ProductDetailDelegate {

    private val mProductModel: ProductModel

    init {
        mProductModel = ProductModelImpl
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

        tvActivityProductDetailDescription.movementMethod = ScrollingMovementMethod()
        val intent = intent
        val productId = intent.getIntExtra("product_id", 0)
        mProductModel.getProductDetail(productId, this)
        mProductModel.addToHistory(productId)

        ivActivityProductDetailBack.setOnClickListener { finish() }
    }

    override fun getProductDetail(product: ProductVO) {
        Glide.with(this).load(product.productImageUrl[0].image_url).into(ivActivityProductDetailImage)
        tvActivityProductDetailName.text = product.productName
        tvActivityProductDetailPrice.text = product.productPrice
        tvActivityProductDetailDescription.text = product.productDesc
        tvActivityProductDetailSeller.text = product.seller.name
    }
}
