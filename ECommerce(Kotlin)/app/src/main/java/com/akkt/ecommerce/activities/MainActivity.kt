package com.akkt.ecommerce.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.akkt.ecommerce.R
import com.akkt.ecommerce.fragments.BottomNavigationDrawerFragment
import com.akkt.ecommerce.fragments.HomeFragment
import com.akkt.ecommerce.fragments.ProfileFragment
import com.akkt.ecommerce.mvp.presenters.IMainPresenter
import com.akkt.ecommerce.mvp.presenters.MainPresenter
import com.akkt.ecommerce.mvp.views.MainView
import com.akkt.ecommerce.utils.CommonLogMessage
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), MainView {

    private val mMainPresenter: IMainPresenter

    init {
        mMainPresenter = MainPresenter(this)
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
        setSupportActionBar(toolbarActivityMain)

        mMainPresenter.onCreate()
        mMainPresenter.onUIReady()

        bottomAppBar.replaceMenu(R.menu.bottom_menu)

        bottomAppBar.setNavigationOnClickListener {
            mMainPresenter.onTapNavigationIcon()
        }

        bottomAppBar.setOnMenuItemClickListener { menuItem ->

            when (menuItem.itemId) {
                R.id.menuPerson -> mMainPresenter.onTapProfileMenu()
                R.id.menuHome -> mMainPresenter.onTapHomeMenu()
                else -> CommonLogMessage.infoMessage("Click item is invalid")
            }
            true
        }

        fabActivityMain.setOnClickListener {
            mMainPresenter.onTapFavoriteButton()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            R.id.menuCart -> Toast.makeText(this, "Click on Cart", Toast.LENGTH_LONG).show()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onStart() {
        super.onStart()
        mMainPresenter.onStart()
    }

    override fun onStop() {
        super.onStop()
        mMainPresenter.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        mMainPresenter.onDestroy()
    }

    override fun navigateToLoginScreen() {
        startActivity(LoginActivity.newIntent(this))
        finish()
    }

    override fun navigateToFavoriteScreen() {
        startActivity(FavoriteActivity.newIntent(this))
    }

    override fun displayHomeFragment() {
        changeFragment(HomeFragment.newInstance())
    }

    override fun displayProfileFragment() {
        changeFragment(ProfileFragment.newInstance())
    }

    private fun changeFragment(fragment: Fragment) {

        val fragmentTrans = supportFragmentManager.beginTransaction()
        fragmentTrans.replace(frActivityMain.id, fragment)
        fragmentTrans.commit()

    }

    override fun displayNavigationMenu() {
        val bottomNavDrawerFragment = BottomNavigationDrawerFragment()
        bottomNavDrawerFragment.show(supportFragmentManager, bottomNavDrawerFragment.tag)
    }
}
