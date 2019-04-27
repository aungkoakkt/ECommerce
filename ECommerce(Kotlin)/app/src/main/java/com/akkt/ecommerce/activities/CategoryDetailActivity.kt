package com.akkt.ecommerce.activities

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import android.widget.Toast
import com.akkt.ecommerce.R
import com.akkt.ecommerce.adapters.ProductRecyclerAdapter
import com.akkt.ecommerce.data.models.ProductModel
import com.akkt.ecommerce.data.models.ProductModelImpl
import com.akkt.ecommerce.data.vos.ProductVO
import com.akkt.ecommerce.delegates.ProductDelegate
import com.akkt.ecommerce.delegates.ProductItemDelegate
import kotlinx.android.synthetic.main.activity_category_detail.*

class CategoryDetailActivity : AppCompatActivity(),ProductDelegate,ProductItemDelegate {

    private val mProductModel: ProductModel
    private val mAdapter: ProductRecyclerAdapter

    init {
        mProductModel = ProductModelImpl.getInsatnce()
        mAdapter= ProductRecyclerAdapter(this)
    }

    companion object {
        fun newIntent(context: Context): Intent {
            val intent = Intent(context, CategoryDetailActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_detail)

        rvActivityCategoryDetail.layoutManager=LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        rvActivityCategoryDetail.adapter=mAdapter

        val intent = intent
        val categoryId = intent.getIntExtra("id", 0)
        val categoryName = intent.getStringExtra("name")


        tvActivityCategoryDetailName.text = categoryName
        mProductModel.getProductListByCategoryId(categoryId,this)
    }

    override fun getProductList(productlist: List<ProductVO>) {
        mAdapter.setNewData(productlist as MutableList<ProductVO>)
    }

    override fun onFail(message: String?) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }

    override fun onTapProduct(product: ProductVO) {
        val intent = ProductDetailActivity.newIntent(this)
        intent.putExtra("product_id", product.productId)
        startActivity(intent)
    }
}
