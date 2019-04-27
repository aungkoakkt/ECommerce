package com.akkt.ecommerce.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.akkt.ecommerce.R
import com.akkt.ecommerce.data.models.UserModel
import com.akkt.ecommerce.data.models.UserModelImpl
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_profile.*

/**
 *Created by Aung Ko Ko Thet on 4/27/19
 */
class ProfileActivity : AppCompatActivity() {

    private val mUserModel: UserModel

    init {
        mUserModel = UserModelImpl.getInstance()
    }

    companion object {
        fun newIntent(context: Context): Intent {
            val intent = Intent(context, ProfileActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val userInfo = mUserModel.getUserInformation()

        Glide.with(this).load(userInfo.coverImage).error(R.drawable.if_reindeer).into(ivActivityProfileCover)
        Glide.with(this).load(userInfo.profileImage).error(R.drawable.if_reindeer).into(ivActivityProfile)
        tvActivityProfileName.text="Name - "+userInfo.name
        tvActivityProfileAddress.text="Address - "+userInfo.address
        tvActivityProfileWallet.text=userInfo.wallet
    }
}