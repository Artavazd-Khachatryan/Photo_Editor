package com.editor.photo.photoeditor.viewModel.handler

import android.content.Intent
import android.view.View
import com.editor.photo.photoeditor.view.activity.StoryActivity

class MainHandler {

    fun openAdd(view: View) {
        val intent = Intent(view.context, StoryActivity::class.java)
        view.context.startActivity(intent)
    }
}