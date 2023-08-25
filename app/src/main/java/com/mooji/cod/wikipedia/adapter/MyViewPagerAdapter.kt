package com.mooji.cod.wikipedia.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.mooji.cod.yaghoot8_viewpagerwhatsappscreen.FragmentFuture
import com.mooji.cod.yaghoot8_viewpagerwhatsappscreen.FragmentInfo

class MyViewPagerAdapter(fragment: Fragment):FragmentStateAdapter(fragment) {
    //اگر از ویوپیجر داخل یک اکتیویتی بخواهیم استفاده کنیم از فرگمنت اکتیویتی
    // و اگر ویوپیجر داخل فرگمنت داشته باشیم از فرگمنت



    override fun createFragment(position: Int): Fragment {

        when(position) {

            0-> {
                return FragmentInfo()

            }
            1 -> {
                return FragmentFuture()

            }

            else -> {
                return Fragment()

            }

        }

    }

    override fun getItemCount(): Int {
            return 2 //تعداد فرگمنت های ما را برمیکرداند که در اینجا 3 تا داریم
    }


}