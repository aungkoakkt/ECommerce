package com.akkt.ecommerce.activities

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.akkt.ecommerce.R
import com.akkt.ecommerce.data.models.UserModel
import com.akkt.ecommerce.data.models.UserModelImpl
import com.akkt.ecommerce.data.vos.LoginUserVO
import com.akkt.ecommerce.delegates.LoginDelegate
import com.akkt.ecommerce.network.responses.GetLoginUserResponse
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginDelegate {

    private val mUserModel: UserModel

    init {
        mUserModel = UserModelImpl
    }

    companion object {
        fun newIntent(context: Context): Intent {
            val intent = Intent(context, LoginActivity::class.java)
            return intent
        }
    }

    override fun onSuccess(loginUser: GetLoginUserResponse) {
        startActivity(MainActivity.newIntent(this))
        finish()
    }

    override fun onFail(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        tvActivityLoginRegister.setOnClickListener { startActivity(RegisterActivity.newIntent(this)) }

        btnActivityLogin.setOnClickListener {
            mUserModel.login(etActivityLoginPhone.toString(), etActivityLoginPassword.toString(), this)
        }
    }
}
