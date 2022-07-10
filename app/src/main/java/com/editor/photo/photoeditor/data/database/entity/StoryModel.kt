package com.editor.photo.photoeditor.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.editor.photo.photoeditor.data.models.TemplateModel

@Entity(tableName = "StoryModelTable")
data class StoryModel(
    @PrimaryKey(autoGenerate = true) val id: Int,
    var title: String,
    var image: String
) {

    var templateModelList: List<TemplateModel>? = null
}