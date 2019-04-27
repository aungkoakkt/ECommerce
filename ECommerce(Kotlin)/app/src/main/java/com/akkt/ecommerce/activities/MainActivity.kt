package com.akkt.ecommerce.activities

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.akkt.ecommerce.R
import com.akkt.ecommerce.adapters.CategoryRecyclerAdapter
import com.akkt.ecommerce.adapters.ProductRecyclerAdapter
import com.akkt.ecommerce.data.models.ProductModel
import com.akkt.ecommerce.data.models.ProductModelImpl
import com.akkt.ecommerce.data.models.UserModel
import com.akkt.ecommerce.data.models.UserModelImpl
import com.akkt.ecommerce.data.vos.CategoryVO
import com.akkt.ecommerce.data.vos.ProductVO
import com.akkt.ecommerce.delegates.CategoryDelegate
import com.akkt.ecommerce.delegates.CategoryItemDelegate
import com.akkt.ecommerce.delegates.ProductDelegate
import com.akkt.ecommerce.delegates.ProductItemDelegate
import com.akkt.ecommerce.network.ECommerceDataAgent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ProductItemDelegate,CategoryItemDelegate {

    private val mUserModel: UserModel
    private val mProductModel: ProductModel

    private val mCategoryAdapter: CategoryRecyclerAdapter
    private val mProductAdapter: ProductRecyclerAdapter

    init {
        mUserModel = UserModelImpl.getInstance()
        mProductModel = ProductModelImpl.getInsatnce()
        mCategoryAdapter = CategoryRecyclerAdapter(this)
        mProductAdapter = ProductRecyclerAdapter(this)
    }

    companion object {
        fun newIntent(context: Context): Intent {
            val intent = Intent(context, MainActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (mUserModel.isUserLogin()) {
            rvActivityMainCategory.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
            rvActivityMainProduct.layoutManager = GridLayoutManager(this, 2, RecyclerView.VERTICAL, false)

            rvActivityMainCategory.adapter = mCategoryAdapter
            rvActivityMainProduct.adapter = mProductAdapter

            mProductModel.getCategoryList(ECommerceDataAgent.ACCESS_TOKEN, 1, object : CategoryDelegate {
                override fun getCategoryList(category: List<CategoryVO>) {
                    mCategoryAdapter.setNewData(category as MutableList<CategoryVO>)
                }

                override fun onFail(message: String?) {
                    Toast.makeText(this@MainActivity, message, Toast.LENGTH_LONG).show()
                }

            })

            mProductModel.getProductList(ECommerceDataAgent.ACCESS_TOKEN, 1, object : ProductDelegate {
                override fun onFail(message: String?) {
                    Toast.makeText(this@MainActivity, message, Toast.LENGTH_LONG).show()
                }

                override fun getProductList(productlist: List<ProductVO>) {
                    mProductAdapter.setNewData(productlist as MutableList<ProductVO>)
                }

            })
        } else {
            startActivity(LoginActivity.newIntent(this))
            finish()
        }
    }

    override fun onTapProduct(product: ProductVO) {
        val intent = ProductDetailActivity.newIntent(this)
        intent.putExtra("product_id", product.productId)
        startActivity(intent)
    }

    override fun onTapCategoryItem(category: CategoryVO) {
        val intent=CategoryDetailActivity.newIntent(this)
        intent.putExtra("id",category.categoryId)
        intent.putExtra("name",category.categoryName)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when (item!!.itemId) {
            R.id.menuProfile -> startActivity(ProfileActivity.newIntent(this))
        }
        return super.onOptionsItemSelected(item)
    }

}
