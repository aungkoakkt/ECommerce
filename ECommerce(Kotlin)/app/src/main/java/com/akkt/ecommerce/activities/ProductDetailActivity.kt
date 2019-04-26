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
        mProductModel = ProductModelImpl.getInsatnce()
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

        tv_activity_product_detail_description.movementMethod = ScrollingMovementMethod()
        val intent = intent
        val productId = intent.getIntExtra("product_id", 0)
        mProductModel.getProductDetail(productId, this)

        iv_activity_product_detail_back.setOnClickListener { finish() }
    }

    override fun getProductDetail(product: ProductVO) {
        Glide.with(this).load(product.productImageUrl!!.get(0).image_url).into(iv_activity_product_detail_image)
        tv_activity_product_detail_name.text = product.productName
        tv_activity_product_detail_price.text = product.productPrice
        tv_activity_product_detail_description.text = product.productDesc
        tv_activity_product_detail_seller.text = product.seller!!.name
    }
}
