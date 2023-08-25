package com.mooji.cod.yaghoot8_viewpagerwhatsappscreen

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewManager
import android.view.animation.AccelerateInterpolator
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TableLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.mooji.cod.wikipedia.R
import com.mooji.cod.wikipedia.databinding.FragmentFutureBinding
import com.mooji.cod.wikipedia.databinding.FragmentProfileBinding


class FragmentFuture() : Fragment() {
lateinit var binding: FragmentFutureBinding
lateinit var binding2:FragmentProfileBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFutureBinding.inflate(inflater,container,false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val anim = AlphaAnimation(0f,1f)

        anim.duration = 2200
        anim.fillAfter = true
        anim.startOffset = 300
        anim.interpolator = AccelerateInterpolator()

        val anim2 = AlphaAnimation(0f,1f)

        anim2.duration = 2200
        anim2.fillAfter = true
        anim2.startOffset = 1000
        anim2.interpolator = AccelerateInterpolator()

        val anim3 = AlphaAnimation(0f,1f)

        anim3.duration = 2200
        anim3.fillAfter = true
        anim3.startOffset = 1700
        anim3.interpolator = AccelerateInterpolator()

        binding.txt1.startAnimation(anim)
        binding.txt2.startAnimation(anim2)
        binding.txt3.startAnimation(anim3)



    }










}