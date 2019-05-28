package com.aceplus.roomdatabase.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = [Contact::class], version = 1, exportSchema = true)
abstract class MyDatabase : RoomDatabase() {
    abstract fun contactDao(): ContactDao

    companion object {
        private var instance: MyDatabase? = null

        fun getInstance(context: Context): MyDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(context, MyDatabase::class.java, "MyDBName")
                    .allowMainThreadQueries()//to allow query in main thread
                    .build()
            }
            return instance as MyDatabase
        }
    }
}