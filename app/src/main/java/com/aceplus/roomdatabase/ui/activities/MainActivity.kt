package com.aceplus.roomdatabase.ui.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.*
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

    }

    override fun onResume() {
        super.onResume()
        mAdapter.setNewList(dataModel.getContactList())
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        MenuInflater(applicationContext).inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.menuAdd) {
            startActivity(Intent(this, AddContactInfoActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
    }
}
