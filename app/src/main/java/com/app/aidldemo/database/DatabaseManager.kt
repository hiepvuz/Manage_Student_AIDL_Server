package com.app.aidldemo.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.app.aidldemo.Student

@Database(entities = [Student::class], version = 1)
abstract class DatabaseManager : RoomDatabase() {
    abstract fun studentDao(): StudentDao

    companion object {
        @Volatile
        private var INSTANCE: DatabaseManager? = null

        fun getDatabase(context: Context): DatabaseManager {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this)
            {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DatabaseManager::class.java,
                    "user_database"
                ).build()
                INSTANCE = instance
                return instance
            }

        }
    }
}