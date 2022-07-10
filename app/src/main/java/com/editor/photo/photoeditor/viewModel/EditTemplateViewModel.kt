package com.editor.photo.photoeditor.viewModel

import android.app.Application
import android.view.View
import androidx.databinding.ObservableInt
import androidx.lifecycle.AndroidViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.editor.photo.photoeditor.data.BackgroundColorsData
import com.editor.photo.photoeditor.data.constants.*
import com.editor.photo.photoeditor.data.liveData.LiveDataHandler
import com.editor.photo.photoeditor.data.models.CommandModel
import com.editor.photo.photoeditor.view.adapter.BackgroundColorListAdapter

class EditTemplateViewModel(application: Application) : AndroidViewModel(application) {

    var backgroundColorListVisibility: ObservableInt = ObservableInt(View.GONE)

    var backgroundColorList = BackgroundColorsData.backgroundColors

    val backgroundColorListAdapter = BackgroundColorListAdapter(backgroundColorList)

    val layoutManager =
        LinearLayoutManager(application.applicationContext, LinearLayoutManager.HORIZONTAL, false)


    fun closeEditTemplateLayout(view: View) {
        LiveDataHandler.setCommand(CommandModel(CLOSE_COMMAND))
    }

    fun openStickerPagerFragment(view: View) {
        LiveDataHandler.setCommand(CommandModel(STICKER_COMMAND))
    }

    fun newTextClick(view: View) {
        LiveDataHandler.setCommand(CommandModel(TEXT_COMMAND))
    }

    fun openBackgroundColorList(view: View) {
        LiveDataHandler.setCommand(CommandModel(COLOR_COMMAND))
    }

    fun close() {
        closeBackground()
        LiveDataHandler.setCommand(CommandModel(BACKGROUND_COLOR_CLOSE_COMMAND))
    }

    fun back() {
        closeBackground()
        LiveDataHandler.setCommand(CommandModel(BACKGROUND_COLOR_BACK_COMMAND))
    }

    private fun closeBackground() {
        backgroundColorListVisibility.set(View.GONE)
    }
}