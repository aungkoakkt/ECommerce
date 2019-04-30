package com.akkt.ecommerce.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.akkt.ecommerce.R
import com.akkt.ecommerce.data.models.UserModel
import com.akkt.ecommerce.data.models.UserModelImpl
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    private val mUserModel: UserModel

    init {
        mUserModel = UserModelImpl
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val userInfo = mUserModel.getUserInformation()

        Glide.with(this).load(userInfo.profileImage).error(R.drawable.if_reindeer).into(ivFragmentProfile)
        tvFragmentProfileName.text=userInfo.name
        tvFragmentProfileAddress.text=userInfo.address
        tvFragmentProfileWallet.text=userInfo.wallet
    }

}
