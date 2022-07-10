package com.editor.photo.photoeditor.data.models

data class TemplateModel(val image: String, val id: Int) {
    var viewModelList: List<ViewModel>? = null
}