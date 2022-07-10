package com.editor.photo.photoeditor.datawrap_content

import com.editor.photo.photoeditor.R
import com.editor.photo.photoeditor.data.models.BackgroundColorModel
import com.editor.photo.photoeditor.data.models.TabListModel

object ChooseTemplateTabListData {

    val titleList: List<TabListModel> by lazy { titleList() }

    private fun titleList() = listOf(
        TabListModel(R.string.card1),
        TabListModel(R.string.card2),
        TabListModel(R.string.card3),
        TabListModel(R.string.card4),
        TabListModel(R.string.card5),
        TabListModel(R.string.card6),
        TabListModel(R.string.card7))
}