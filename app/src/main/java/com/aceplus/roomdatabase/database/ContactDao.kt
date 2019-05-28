package com.aceplus.roomdatabase.database

import android.arch.persistence.db.SimpleSQLiteQuery
import android.arch.persistence.db.SupportSQLiteQuery
import android.arch.persistence.room.*


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

    @Delete
    fun deleteData(contact: Contact)

    @Update
    fun updateData(contact: Contact)


    //you can use Query to delete data
    @Query("Delete from contact where id=:contactId")
    fun deleteData(contactId: Int)


    //you can use RawQuery too
    @RawQuery
    fun deleteData(rawSQLiteQuery: SupportSQLiteQuery):Boolean

    @RawQuery
    fun updateData(rawSQLiteQuery: SupportSQLiteQuery):Boolean

    @RawQuery
    fun allData(rawSQLiteQuery: SupportSQLiteQuery): List<Contact>

}