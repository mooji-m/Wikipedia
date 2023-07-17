package com.mooji.cod.wikipedia.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mooji.cod.wikipedia.databinding.FragmentExploreBinding
import com.mooji.cod.wikipedia.databinding.FragmentProfileBinding

class FragmentExplore : Fragment() {
lateinit var binding:FragmentExploreBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
            binding = FragmentExploreBinding.inflate(layoutInflater,container,false)
            return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}