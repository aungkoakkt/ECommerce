package com.akkt.ecommerce.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.akkt.ecommerce.R
import com.akkt.ecommerce.activities.ProductDetailActivity
import com.akkt.ecommerce.adapters.HistoryRecyclerAdapter
import com.akkt.ecommerce.data.vos.LoginUserVO
import com.akkt.ecommerce.data.vos.ProductVO
import com.akkt.ecommerce.mvp.presenters.IProfilePresenter
import com.akkt.ecommerce.mvp.presenters.ProfilePresenter
import com.akkt.ecommerce.mvp.views.ProfileView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment(),ProfileView {

    private val mHistoryAdapter: HistoryRecyclerAdapter
    private val mProfilePresenter:IProfilePresenter

    init {
        mProfilePresenter=ProfilePresenter(this)
        mHistoryAdapter = HistoryRecyclerAdapter(mProfilePresenter)
    }

    companion object {
        fun newInstance() = ProfileFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mProfilePresenter.onCreate()

        rvFragmentProfileHistory.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        rvFragmentProfileHistory.adapter=mHistoryAdapter

        mProfilePresenter.onUIReady()
    }

    override fun onStart() {
        super.onStart()
        mProfilePresenter.onStart()
    }

    override fun onStop() {
        super.onStop()
        mProfilePresenter.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        mProfilePresenter.onDestroy()
    }

    override fun displayUserInformation(loginUser: LoginUserVO) {
        Glide.with(this).load(loginUser.profileImage).error(R.drawable.if_reindeer).into(ivFragmentProfile)
        tvFragmentProfileName.text = loginUser.name
        tvFragmentProfileAddress.text = loginUser.address
        tvFragmentProfileWallet.text = loginUser.wallet
    }

    override fun displayHistoryList(productList: List<ProductVO>) {
        val count=productList.size
        tvFragmentProfileHistory.text="$count History"
        mHistoryAdapter.setNewData(productList as MutableList<ProductVO>)
    }

    override fun displayNoHistoryMessage(message: String) {
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show()
    }

    override fun navigateToProductDetail(productId: Int) {
        val intent = ProductDetailActivity.newIntent(context!!)
        intent.putExtra("product_id", productId)
        startActivity(intent)
    }
}