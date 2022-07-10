package com.editor.photo.photoeditor.data.models

class StickerModel(
    val previewImage: String,
    var image: String,
    override var positionX: Double = 0.0,
    override var positionY: Double = 0.0,
    override var withPercent: Double = 0.0,
    override var heightPercent: Double = 0.0,
    override var radius: Double = 0.0
): ViewModel