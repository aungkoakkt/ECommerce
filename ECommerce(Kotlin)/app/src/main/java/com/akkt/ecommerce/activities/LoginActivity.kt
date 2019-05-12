package com.akkt.ecommerce.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.akkt.ecommerce.R
import com.akkt.ecommerce.mvp.presenters.ILoginPresenter
import com.akkt.ecommerce.mvp.presenters.impl.LoginPresenter
import com.akkt.ecommerce.mvp.views.LoginView
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : BaseActivity(), LoginView {

    private val mLoginPresenter: ILoginPresenter = LoginPresenter(this)

    companion object {
        fun newIntent(context: Context): Intent {
            val intent = Intent(context, LoginActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        mLoginPresenter.onCreate()

        tvActivityLoginRegister.setOnClickListener { mLoginPresenter.onTapRegisterText() }

        btnActivityLogin.setOnClickListener {
            mLoginPresenter.onTapLoginButton(etActivityLoginPhone.toString(), etActivityLoginPassword.toString())
        }
    }

    override fun onStart() {
        super.onStart()
        mLoginPresenter.onStart()
    }

    override fun onStop() {
        super.onStop()
        mLoginPresenter.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        mLoginPresenter.onDestroy()
    }

    override fun navigateToMain() {
        startActivity(MainActivity.newIntent(this))
        finish()
    }

    override fun navigateToRegister() {
        startActivity(RegisterActivity.newIntent(this))
    }

    override fun displayFailToLoginMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
