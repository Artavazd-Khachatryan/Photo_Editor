package com.editor.photo.photoeditor.view.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.editor.photo.photoeditor.databinding.FragmentEditTemplateBinding
import com.editor.photo.photoeditor.viewModel.EditTemplateViewModel


class EditTemplateFragment : Fragment() {

    private lateinit var viewModel: EditTemplateViewModel

    companion object {
        fun newInstance(bundle: Bundle?): EditTemplateFragment {

            val editTemplateFragment = EditTemplateFragment()
            bundle?.let { editTemplateFragment.arguments = it }
            return editTemplateFragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProviders.of(this)[EditTemplateViewModel::class.java]
        val binding = FragmentEditTemplateBinding.inflate(inflater, container, false)

        binding.viewModel = viewModel
        return binding.root
    }

    fun isBackgroundColorListVisible(visible: Int) {
        viewModel.backgroundColorListVisibility.set(visible)
    }
}
