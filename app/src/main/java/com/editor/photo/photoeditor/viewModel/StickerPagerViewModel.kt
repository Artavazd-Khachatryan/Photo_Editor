package com.editor.photo.photoeditor.viewModel

import androidx.lifecycle.ViewModel
import com.editor.photo.photoeditor.data.StickerData
import com.editor.photo.photoeditor.data.constants.STICKER_BACK_COMMAND
import com.editor.photo.photoeditor.data.constants.STICKER_CLOSE_COMMAND
import com.editor.photo.photoeditor.data.liveData.LiveDataHandler
import com.editor.photo.photoeditor.data.models.CommandModel

class StickerPagerViewModel : ViewModel() {
    val stickerMap = StickerData.stickerDataMap

    fun close() {
        LiveDataHandler.setCommand(CommandModel(STICKER_CLOSE_COMMAND))
    }

    fun back() {
        LiveDataHandler.setCommand(CommandModel(STICKER_BACK_COMMAND))
    }
}