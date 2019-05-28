package com.aceplus.roomdatabase.ui.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.*
import android.widget.Toast
import com.aceplus.roomdatabase.R
import com.aceplus.roomdatabase.database.Contact
import com.aceplus.roomdatabase.model.DataModel
import com.aceplus.roomdatabase.ui.adapters.ContactListAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var dataModel: DataModel
    private val mAdapter: ContactListAdapter by lazy { ContactListAdapter(this::onClickItem, this::onLongClickItem) }

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

    private fun onClickItem(contact: Contact) {
        //don't use old style
//        val intent = Intent(this, AddContactInfoActivity::class.java)
//        intent.putExtra("isEdit", true)
//        intent.putExtra("name", contact.name)
//        intent.putExtra("phone", contact.phone)
//        intent.putExtra("address", contact.address)
//        startActivity(intent)

        //use like this
        val intent = AddContactInfoActivity.newActivity(
            this,
            isEdit = true,
            id = contact.id,
            name = contact.name,
            phone = contact.phone,
            address = contact.address
        )
        startActivity(intent)
    }

    private fun onLongClickItem(contact: Contact) {
        val alertDialog = AlertDialog.Builder(this)
            .setTitle("Delete")
            .setMessage("Are you sure to delete?")
            .setPositiveButton("OK") { _, _ ->
                dataModel.deleteContactData(contact)
                mAdapter.setNewList(dataModel.getContactList())
                Toast.makeText(applicationContext, "Successfully deleted ${contact.name}", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Cancel") { _, _ ->

            }
            .create()
        alertDialog.show()


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.menuAdd) {
            //don't use old style
//            val intent = Intent(this, AddContactInfoActivity::class.java)
//            intent.putExtra("isEdit", false)
//            startActivity(intent)

            //use like this
            val intent = AddContactInfoActivity.newActivity(this, isEdit = false)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }
}
