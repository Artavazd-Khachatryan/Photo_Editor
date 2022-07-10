package com.editor.photo.photoeditor.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.editor.photo.photoeditor.data.database.dao.StoryDao
import com.editor.photo.photoeditor.data.database.entity.StoryModel

@Database(entities = [StoryModel::class], version = 1)
abstract class StoryDatabase : RoomDatabase() {

    abstract fun storyDao(): StoryDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: StoryDatabase? = null

        fun getDatabase(context: Context): StoryDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    StoryDatabase::class.java,
                    "StoryDataBase"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}