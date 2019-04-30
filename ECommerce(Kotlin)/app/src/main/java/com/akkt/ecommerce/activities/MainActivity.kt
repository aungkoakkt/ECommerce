package com.akkt.ecommerce.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.akkt.ecommerce.R
import com.akkt.ecommerce.data.models.UserModel
import com.akkt.ecommerce.data.models.UserModelImpl
import com.akkt.ecommerce.fragments.BottomNavigationDrawerFragment
import com.akkt.ecommerce.fragments.HomeFragment
import com.akkt.ecommerce.fragments.ProfileFragment
import com.akkt.ecommerce.utils.CommonLogMessage
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mUserModel: UserModel

    init {
        mUserModel = UserModelImpl
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

        if (mUserModel.isUserLogin()) {

            changeFragment(HomeFragment())

            bottomAppBar.replaceMenu(R.menu.bottom_menu)

            bottomAppBar.setNavigationOnClickListener {
                val bottomNavDrawerFragment = BottomNavigationDrawerFragment()
                bottomNavDrawerFragment.show(supportFragmentManager, bottomNavDrawerFragment.tag)
            }

            bottomAppBar.setOnMenuItemClickListener { menuItem ->

                when (menuItem.itemId) {
                    R.id.menuPerson -> changeFragment(ProfileFragment())
                    R.id.menuHome -> changeFragment(HomeFragment())
                    else -> CommonLogMessage.infoMessage("Click item is invalid")
                }

                true
            }

            fabActivityMain.setOnClickListener {
                startActivity(FavoriteActivity.newIntent(this))
            }

        } else {
            startActivity(LoginActivity.newIntent(this))
            finish()
        }
    }

    fun changeFragment(fragment: Fragment) {

        val fragmentrans = supportFragmentManager.beginTransaction()
        fragmentrans.replace(frActivityMain.id, fragment)
        fragmentrans.commit()

    }

      override fun onCreateOptionsMenu(menu: Menu?): Boolean {
          menuInflater.inflate(R.menu.main_menu, menu)
          return true
      }

      override fun onOptionsItemSelected(item: MenuItem?): Boolean {

          when (item!!.itemId) {
              R.id.menuCart-> Toast.makeText(this,"Click on Cart",Toast.LENGTH_LONG).show()
          }
          return super.onOptionsItemSelected(item)
      }

}
