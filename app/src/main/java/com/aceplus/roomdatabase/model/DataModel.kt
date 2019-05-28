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

    //CRUD

    //C - Create Data
    fun addContactData(contact: Contact) {
        val myDatabase = MyDatabase.getInstance(context)
        myDatabase.contactDao().insertData(contact)
    }

    //R - Read Data
    fun getContactList(): List<Contact> {
        val myDatabase = MyDatabase.getInstance(context)
        return myDatabase.contactDao().allData as MutableList<Contact>
    }

    //U - Update Data
    fun updateContactData(contact: Contact) {
        val myDatabase = MyDatabase.getInstance(context)
        return myDatabase.contactDao().updateData(contact)
    }

    //D - Delete Data
    fun deleteContactData(contact: Contact) {
        val myDatabase = MyDatabase.getInstance(context)
//        myDatabase.contactDao().deleteData(contactId = contact.id!!)
        myDatabase.contactDao().deleteData(contact = contact)
    }

}