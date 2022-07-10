package com.editor.photo.photoeditor.view.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.editor.photo.photoeditor.exceptions.StickerListNotFoundException

import com.editor.photo.photoeditor.data.StickerData
import com.editor.photo.photoeditor.data.constants.STICKER_KEY
import com.editor.photo.photoeditor.data.models.StickerModel
import com.editor.photo.photoeditor.databinding.FragmentListStickerBinding
import com.editor.photo.photoeditor.viewModel.StickerListViewModel


class StickerListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val viewModel = ViewModelProviders.of(this).get(StickerListViewModel::class.java)
        val binding = FragmentListStickerBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel

        val view = binding.root


        val kay = arguments?.getString(STICKER_KEY)
            ?: throw StickerListNotFoundException("StickerPageFragment arguments getString(STICKER_KEY) is a null")
        viewModel.stickerList = getStickerListFromData(kay)

        return view
    }

    private fun getStickerListFromData(key: String): List<StickerModel> {
        return StickerData.stickerDataMap[key]
            ?: throw StickerListNotFoundException("kay is not found in stickerDataMap")
    }


    companion object {
        fun newInstance(bundle: Bundle?): Fragment {
            val fragment = StickerListFragment()
            bundle?.let { fragment.arguments = it }
            return fragment
        }
    }
}
