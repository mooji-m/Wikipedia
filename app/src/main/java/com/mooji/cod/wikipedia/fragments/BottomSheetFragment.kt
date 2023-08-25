package com.mooji.cod.wikipedia.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.mooji.cod.wikipedia.R
import com.mooji.cod.wikipedia.databinding.BottomsheetdialogfragmentBinding

class BottomSheetFragment : BottomSheetDialogFragment() {

    lateinit var binding: BottomsheetdialogfragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = BottomsheetdialogfragmentBinding.inflate(layoutInflater, container, false)











        return binding.root
    }


}