package com.editor.photo.photoeditor.data.models

data class LayoutModel(
    override var positionX: Double,
    override var positionY: Double,
    override var withPercent: Double,
    override var heightPercent: Double,
    override var radius: Double,
    var image: String,
    var frame: Frame
) : ViewModel