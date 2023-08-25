package com.mooji.cod.yaghoot8_viewpagerwhatsappscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.airbnb.lottie.LottieDrawable
import com.mooji.cod.wikipedia.databinding.FragmentInfoBinding


class FragmentInfo : Fragment() {
lateinit var binding:FragmentInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentInfoBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.animComment.repeatCount = LottieDrawable.INFINITE
        binding.animEmail.repeatCount = LottieDrawable.INFINITE
        binding.animComment.playAnimation()
        binding.animEmail.playAnimation()
    }
}