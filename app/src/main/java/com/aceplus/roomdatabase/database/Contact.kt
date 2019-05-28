package com.aceplus.roomdatabase.database

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "contact")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    var id: Int?,
    @ColumnInfo(name = "userName")
    var name: String,
    @ColumnInfo(name = "phoneNumber")
    var phone: String,
    @ColumnInfo(name = "address")
    var address: String
)