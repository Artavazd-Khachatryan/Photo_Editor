package com.editor.photo.photoeditor.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.editor.photo.photoeditor.data.database.entity.StoryModel

@Dao
interface StoryDao {

    @Insert
    fun insert(storyModel: StoryModel)

    @Update
    fun update(storyModel: StoryModel)

    @Delete
    fun delete(storyModel: StoryModel)

    @Query("DELETE FROM StoryModelTable")
    fun deleteAllStories()

    @Query("SELECT * FROM StoryModelTable")
    fun getAllStories(): LiveData<List<StoryModel>>

}