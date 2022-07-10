package com.editor.photo.photoeditor.view.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders

import com.editor.photo.photoeditor.databinding.FragmentTemplateListBinding
import com.editor.photo.photoeditor.viewModel.TemplateListViewModel


class TemplateListFragment : Fragment() {

    private lateinit var viewModel: TemplateListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProviders.of(this)[TemplateListViewModel::class.java]
        val binding = FragmentTemplateListBinding.inflate(inflater, container, false)


        binding.viewModel = viewModel
        return binding.root
    }

    companion object {
        fun newInstance(bundle: Bundle?): Fragment {
            val fragment = TemplateListFragment()
            bundle?.let { fragment.arguments = it }
            return fragment
        }
    }

}
