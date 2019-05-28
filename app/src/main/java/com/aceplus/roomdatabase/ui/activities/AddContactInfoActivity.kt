package com.aceplus.roomdatabase.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.aceplus.roomdatabase.R
import com.aceplus.roomdatabase.database.Contact
import com.aceplus.roomdatabase.model.DataModel
import kotlinx.android.synthetic.main.activity_add_contact_info.*

class AddContactInfoActivity : AppCompatActivity() {

    private lateinit var dataModel: DataModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_contact_info)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        dataModel = DataModel.getInstance(applicationContext)
        btnAddContact.setOnClickListener {
            if (edtName.text.isBlank()) {
                edtName.error = "Please enter name"
                return@setOnClickListener
            }
            if (edtPhone.text.isBlank()) {
                edtPhone.error = "Please enter phone number"
                return@setOnClickListener
            }
            if (edtAddress.text.isBlank()) {
                edtAddress.error = "Please enter address"
                return@setOnClickListener
            }
            val contact = Contact(null, edtName.text.toString(), edtPhone.text.toString(), edtAddress.text.toString())
            dataModel.addContactData(contact = contact)
            finish()
        }
    }
}
