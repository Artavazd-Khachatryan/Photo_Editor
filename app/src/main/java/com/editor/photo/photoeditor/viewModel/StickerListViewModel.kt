package com.editor.photo.photoeditor.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.recyclerview.widget.GridLayoutManager
import com.editor.photo.photoeditor.data.models.StickerModel
import com.editor.photo.photoeditor.view.adapter.StickerListAdapter

class StickerListViewModel(application: Application) : AndroidViewModel(application) {

    val stickerListAdapter = StickerListAdapter(emptyList())
    val stickerListLayoutManager =
        GridLayoutManager(application.applicationContext, 3, GridLayoutManager.VERTICAL, false)
    var stickerList: List<StickerModel> = ArrayList()
        set(stickerList) = stickerListAdapter.setStickerList(stickerList)
}