package com.editor.photo.photoeditor.data

import com.editor.photo.photoeditor.R
import com.editor.photo.photoeditor.data.constants.GRAPHICS
import com.editor.photo.photoeditor.data.constants.OBJECTS
import com.editor.photo.photoeditor.data.constants.STAMP
import com.editor.photo.photoeditor.data.models.StickerModel
import java.util.ArrayList

object StickerData {

    val stickerDataMap: Map<String, List<StickerModel>> = createStickerList()

    private fun createStickerList(): Map<String, List<StickerModel>> {

        val map = HashMap<String, List<StickerModel>>()

        map[GRAPHICS] = getStickerList(GRAPHICS)
        map[STAMP] = getStickerList(STAMP)
        map[OBJECTS] = getStickerList(OBJECTS)


        return map
    }

    private fun getStickerList(key: String): List<StickerModel> {

        val stickerModel = StickerModel("${R.drawable.sticker}", "${R.drawable.sticker}")
        val list = ArrayList<StickerModel>()
        list += stickerModel
        list += stickerModel
        list += stickerModel
        list += stickerModel
        list += stickerModel
        list += stickerModel
        list += stickerModel
        list += stickerModel
        list += stickerModel
        list += stickerModel
        list += stickerModel
        list += stickerModel
        list += stickerModel
        list += stickerModel
        list += stickerModel
        list += stickerModel
        list += stickerModel
        list += stickerModel
        list += stickerModel
        list += stickerModel
        list += stickerModel
        list += stickerModel
        list += stickerModel
        list += stickerModel
        return list
    }
}