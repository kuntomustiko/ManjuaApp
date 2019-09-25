package com.minara.kirana.manjuaapp.utama

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.minara.kirana.manjuaapp.R
import com.minara.kirana.manjuaapp.utama.fragment.HistoryFragment
import com.minara.kirana.manjuaapp.utama.fragment.home.HomeFragment
import com.minara.kirana.manjuaapp.utama.fragment.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_tab.view.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.minara.kirana.manjuaapp.R.layout.activity_main)

        // hari ke 3
        val adapter =
            HomeTabAdapter(supportFragmentManager)
        pager.adapter = adapter

        tabs.setupWithViewPager(pager)

        val viewHomeTab = LayoutInflater.from(this).inflate(com.minara.kirana.manjuaapp.R.layout.item_tab, null)
        viewHomeTab.tabImage.setImageResource(com.minara.kirana.manjuaapp.R.drawable.home)
        viewHomeTab.tabTitle.text = "HOME"
        tabs.getTabAt(0)?.customView = viewHomeTab

        tabs.setSelectedTabIndicatorColor(Color.parseColor("#fffa63"))
//        tabs.getTabAt(0)?.
//        tabs.tabTextColors =
//        tabs.setBackgroundColor(Color.parseColor("#fffa63"))
//        tabs.setTabIconTintResource(R.color.colorWhite)

        val viewHistoryTab = LayoutInflater.from(this).inflate(com.minara.kirana.manjuaapp.R.layout.item_tab, null)
        viewHistoryTab.tabImage.setImageResource(com.minara.kirana.manjuaapp.R.drawable.history)
        viewHistoryTab.tabTitle.text = "HISTORY"
        tabs.getTabAt(1)?.customView = viewHistoryTab

        val viewProfileTab = LayoutInflater.from(this).inflate(com.minara.kirana.manjuaapp.R.layout.item_tab, null)
        viewProfileTab.tabImage.setImageResource(com.minara.kirana.manjuaapp.R.drawable.profile)
        viewProfileTab.tabTitle.text = "PROFILE"
        tabs.getTabAt(2)?.customView = viewProfileTab

//        tabs.getTabAt(0)?.getIcon()?.setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_IN)
//        tabs.getTabAt(0)?.icon?.colorFilter?:(Color.RED)


    }


    // hari ke3
    class HomeTabAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {

            var fragment = Fragment()
            when (position) {
                0 -> fragment = HomeFragment()
                1 -> fragment = HistoryFragment()
                2 -> fragment = ProfileFragment()
            }

            return fragment
        }

        // 3 fragment
        override fun getCount() = 3


        override fun getPageTitle(position: Int): CharSequence? {
            var nameTabs = ""

            when (position) {
                0 -> nameTabs = "Home"
                1 -> nameTabs = "History"
                2 -> nameTabs = "Profile"
            }
            return nameTabs
        }

    }
}
