package com.editor.photo.photoeditor.view.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders

import com.editor.photo.photoeditor.databinding.FragmentStickerPageBinding
import com.editor.photo.photoeditor.viewModel.StickerPagerViewModel

class StickerPageFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val viewModel = ViewModelProviders.of(this)[StickerPagerViewModel::class.java]
        val binding = FragmentStickerPageBinding.inflate(inflater, container, false)
        binding.fragmentManager = fragmentManager
        binding.viewModel = viewModel
        val view = binding.root

        return view
    }


    companion object {
        fun newInstance(bundle: Bundle?): Fragment {
            val fragment = StickerPageFragment()
            bundle?.let { fragment.arguments = it }
            return fragment
        }
    }

}
