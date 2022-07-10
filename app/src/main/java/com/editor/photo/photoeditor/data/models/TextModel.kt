package com.editor.photo.photoeditor.data.models

data class TextModel(
    override var positionX: Double,
    override var positionY: Double,
    override var withPercent: Double,
    override var heightPercent: Double,
    override var radius: Double,
    var textFont: String,
    var textSizes: Int) : ViewModel