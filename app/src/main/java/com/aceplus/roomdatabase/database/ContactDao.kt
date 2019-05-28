package com.aceplus.roomdatabase.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query


@Dao
interface ContactDao {

    @get:Query("select * from contact")
    val allData: List<Contact>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(contact: Contact)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<Contact>)

    @Query("Delete from contact")
    fun deleteAll()
}