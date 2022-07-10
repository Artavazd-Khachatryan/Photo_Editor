package com.editor.photo.photoeditor.data

import com.editor.photo.photoeditor.R
import com.editor.photo.photoeditor.data.models.BackgroundColorModel

object BackgroundColorsData {
    val backgroundColors: List<BackgroundColorModel> by lazy { colorList() }

    private fun colorList() = listOf(
        BackgroundColorModel(R.color.coloBlue),
        BackgroundColorModel(R.color.coloOrange),
        BackgroundColorModel(R.color.coloRed),
        BackgroundColorModel(R.color.colorGreen),
        BackgroundColorModel(R.color.colorYellow),
        BackgroundColorModel(R.color.coloBlue),
        BackgroundColorModel(R.color.coloOrange),
        BackgroundColorModel(R.color.coloRed),
        BackgroundColorModel(R.color.colorGreen),
        BackgroundColorModel(R.color.colorYellow)
    )
}