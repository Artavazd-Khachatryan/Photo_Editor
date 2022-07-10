package com.editor.photo.photoeditor.view.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.editor.photo.photoeditor.R
import com.editor.photo.photoeditor.data.models.BackgroundColorModel
import com.editor.photo.photoeditor.data.models.StickerModel
import com.editor.photo.photoeditor.databinding.FragmentTemplateBinding
import com.editor.photo.photoeditor.view.customview.CustomEditTextView
import com.editor.photo.photoeditor.view.customview.StickerView


class TemplateFragment : Fragment() {

    lateinit var mainView: View
    lateinit var parentLayout: ViewGroup

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentTemplateBinding.inflate(inflater, container, false)
        mainView = binding.root
        parentLayout = mainView.findViewById(R.id.clParent)
        return mainView
    }

    fun addEditText() {
        val editTextView = CustomEditTextView(mainView.context, null, parentLayout)
        parentLayout.addView(editTextView)
    }

    fun addSticker(sticker: StickerModel) {
        val stickerView = StickerView(mainView.context, null, parentLayout)
        stickerView.setStickerImage(sticker.previewImage.toInt())
        parentLayout.addView(stickerView)
    }

    fun setBackgroundColor(backgroundColorModel: BackgroundColorModel) {
        parentLayout.setBackgroundColor(context!!.getColor(backgroundColorModel.color))
    }


    companion object {

        fun newInstance(bundle: Bundle?): Fragment {
            val templateFragment = TemplateFragment()
            templateFragment.arguments = bundle
            return templateFragment
        }
    }
}
