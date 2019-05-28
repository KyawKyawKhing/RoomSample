package com.aceplus.roomdatabase.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.aceplus.roomdatabase.R
import com.aceplus.roomdatabase.database.Contact
import com.aceplus.roomdatabase.ui.adapters.viewholders.ContactViewHolder

class ContactListAdapter : RecyclerView.Adapter<ContactViewHolder>() {
    private var contactDataList = emptyList<Contact>()
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ContactViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.list_item_contact, p0, false)
        return ContactViewHolder(view = view)
    }

    override fun getItemCount(): Int {
        return contactDataList.size
    }

    override fun onBindViewHolder(viewholder: ContactViewHolder, position: Int) {
        viewholder.setData(contactDataList[position])
    }

    fun setNewList(contactList: List<Contact>) {
        this.contactDataList = contactList
        notifyDataSetChanged()
    }
}