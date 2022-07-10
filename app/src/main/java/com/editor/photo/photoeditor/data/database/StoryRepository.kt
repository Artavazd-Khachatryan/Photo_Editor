package com.editor.photo.photoeditor.data.database

import androidx.lifecycle.LiveData
import com.editor.photo.photoeditor.data.database.dao.StoryDao
import com.editor.photo.photoeditor.data.database.entity.StoryModel

class StoryRepository(private var storyDao: StoryDao) {

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.

    private val allStories: LiveData<List<StoryModel>> = storyDao.getAllStories()


    // The suspend modifier tells the compiler that this must be called from a
    // coroutine or another suspend function.

    suspend fun insert(storyModel: StoryModel) {
        storyDao.insert(storyModel)
    }

    fun update(storyModel: StoryModel){

    }

    fun delete(storyModel: StoryModel){

    }

    fun deleteAllStories(storyModel: StoryModel){}

    fun getAllegories(): LiveData<List<StoryModel>>{
        return allStories
    }
}