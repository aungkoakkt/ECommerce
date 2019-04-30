package com.akkt.ecommerce.fragments

import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.akkt.ecommerce.R
import kotlinx.android.synthetic.main.fragment_bottom_navigation_drawer.*

class BottomNavigationDrawerFragment : BottomSheetDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_bottom_navigation_drawer, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        navigation_view.setNavigationItemSelectedListener { menuItem ->
            // Bottom Navigation Drawer menu item clicks
            when (menuItem.itemId) {
                R.id.nav1 -> Toast.makeText(context, "Click on Item 1.", Toast.LENGTH_LONG).show()
                R.id.nav2 -> Toast.makeText(context, "Click on Item 2.", Toast.LENGTH_LONG).show()
                R.id.nav3 -> Toast.makeText(context, "Click on Item 3.", Toast.LENGTH_LONG).show()
                R.id.nav4 -> Toast.makeText(context, "Click on Item 4.", Toast.LENGTH_LONG).show()
            }
            // Add code here to update the UI based on the item selected
            // For example, swap UI fragments here
            true
        }
    }
}
