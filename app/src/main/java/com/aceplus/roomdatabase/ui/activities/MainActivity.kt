package com.aceplus.roomdatabase.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.Menu
import android.view.MenuInflater
import com.aceplus.roomdatabase.R
import com.aceplus.roomdatabase.database.Contact
import com.aceplus.roomdatabase.model.DataModel
import com.aceplus.roomdatabase.ui.adapters.ContactListAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var dataModel: DataModel
    private val mAdapter: ContactListAdapter by lazy { ContactListAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvContact.apply {
            adapter = mAdapter
            layoutManager = GridLayoutManager(applicationContext, 1)
        }

        dataModel = DataModel.getInstance(applicationContext)

        dataModel.addContactData(Contact(null, "Kyaw Kyaw", "09304293482", "Yangon"))
        dataModel.addContactData(Contact(null, "Mg Mg", "093243532", "MICT Park"))

        mAdapter.setNewList(dataModel.getContactList())
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        MenuInflater(applicationContext).inflate(R.menu.main_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }
}
