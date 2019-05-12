package com.akkt.ecommerce.mvp.presenters.impl

import com.akkt.ecommerce.mvp.presenters.IMainPresenter
import com.akkt.ecommerce.mvp.views.MainView

/**
 *Created by Aung Ko Ko Thet on 5/9/19
 */
class MainPresenter(private val mMainView: MainView) : BasePresenter(),
    IMainPresenter {

    override fun onUIReady() {
        val flag=mUserModel.isUserLogin()
        when{
            flag->mMainView.displayHomeFragment()
            else->mMainView.navigateToLoginScreen()
        }
    }

    override fun onTapHomeMenu() {
        mMainView.displayHomeFragment()
    }

    override fun onTapProfileMenu() {
        mMainView.displayProfileFragment()
    }

    override fun onTapFavoriteButton() {
        mMainView.navigateToFavoriteScreen()
    }

    override fun onTapNavigationIcon() {
        mMainView.displayNavigationMenu()
    }

    override fun onStart() {

    }

    override fun onStop() {

    }
}