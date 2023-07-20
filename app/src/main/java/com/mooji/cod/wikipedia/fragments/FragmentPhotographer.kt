package com.mooji.cod.wikipedia.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.mooji.cod.wikipedia.R
import com.mooji.cod.wikipedia.databinding.FragmentPhotographerBinding
import jp.wasabeef.glide.transformations.RoundedCornersTransformation


class FragmentPhotographer : Fragment() {
lateinit var binding: FragmentPhotographerBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

            binding = FragmentPhotographerBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        Glide
            .with(this)
            .load(R.drawable.img_photographer)
            .transform(CenterCrop(),RoundedCornersTransformation(24,8))
            .into(binding.imgPhotographer)


    }





}