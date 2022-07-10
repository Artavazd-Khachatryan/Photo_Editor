package com.editor.photo.photoeditor.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.editor.photo.photoeditor.R
import com.editor.photo.photoeditor.databinding.ActivityMainBinding
import com.editor.photo.photoeditor.viewModel.MainViewModel
import com.editor.photo.photoeditor.viewModel.handler.MainHandler

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = ViewModelProviders.of(this)[MainViewModel::class.java]
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel
        binding.handler = MainHandler()
    }
}
