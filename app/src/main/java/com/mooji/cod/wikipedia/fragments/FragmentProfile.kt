package com.mooji.cod.wikipedia.fragments

import android.app.Activity
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.view.animation.AlphaAnimation
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.mooji.cod.wikipedia.R
import com.mooji.cod.wikipedia.adapter.MyViewPagerAdapter
import com.mooji.cod.wikipedia.databinding.FragmentFutureBinding
import com.mooji.cod.wikipedia.databinding.FragmentProfileBinding
import com.mooji.cod.yaghoot8_viewpagerwhatsappscreen.FragmentFuture
import com.mooji.cod.yaghoot8_viewpagerwhatsappscreen.FragmentInfo

class FragmentProfile : Fragment() {
    lateinit var binding: FragmentProfileBinding
    lateinit var binding2:FragmentFutureBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val myAdapter = MyViewPagerAdapter(this)

        binding.viewPagerMain.adapter = myAdapter

        //binding.viewPagerMain.offscreenPageLimit = 2 // این رو برداشتم تا وقتی هنوز وارد تب اینده نشدیم فرگمنت ساخته و انیمیشنش اجرا نشه

        val mediator = TabLayoutMediator(
            binding.tabLayoutMain,
            binding.viewPagerMain,
            object : TabLayoutMediator.TabConfigurationStrategy {
                override fun onConfigureTab(tab: TabLayout.Tab, position: Int) {
                    when (position) {

                        0 -> {
                            tab.text = "Information"
                        }
                        1 -> {
                            tab.text = "In the future"
                        }


                    }
                }

            }
        )
        mediator.attach()





        binding.tabLayoutMain.setTabTextColors(
            Color.parseColor("#a5a8ba"),
            ContextCompat.getColor(view.context, R.color.black)
        )


        val startColor = "#e1e6f7"
        val endColor = "#ffffff"
        val colors =
            intArrayOf(
                Color.parseColor(startColor),
                Color.parseColor(endColor),
                Color.parseColor(endColor),
                Color.parseColor(endColor)
            )
        val gradientDrawable = GradientDrawable(
            GradientDrawable.Orientation.TOP_BOTTOM, colors
        )
        gradientDrawable.colors = colors
        // setting the corner radius on gradient drawable
        gradientDrawable.cornerRadius = 120f

        binding.cardMain.background = gradientDrawable


        binding.cardMainOuter.setBackgroundColor(
            ContextCompat.getColor(
                view.context,
                R.color.transparent
            )
        )


    }

}

