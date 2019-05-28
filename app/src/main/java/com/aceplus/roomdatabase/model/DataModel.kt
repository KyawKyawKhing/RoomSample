package com.aceplus.roomdatabase.model

import android.content.Context
import com.aceplus.roomdatabase.database.Contact
import com.aceplus.roomdatabase.database.MyDatabase

class DataModel(private val context: Context) {

    companion object {
        private var instance: DataModel? = null

        fun getInstance(context: Context): DataModel {
            if (instance == null) {
                instance = DataModel(context)
            }
            return instance as DataModel
        }
    }

    fun getContactList(): List<Contact> {
        val myDatabase = MyDatabase.getInstance(context)
        return myDatabase.contactDao().allData as MutableList<Contact>
    }

    fun addContactData(contact: Contact) {
        val myDatabase = MyDatabase.getInstance(context)
        myDatabase.contactDao().insertData(contact)
    }
}