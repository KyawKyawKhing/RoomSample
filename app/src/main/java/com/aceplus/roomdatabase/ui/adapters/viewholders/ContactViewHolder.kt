package com.aceplus.roomdatabase.ui.adapters.viewholders

import android.support.v7.widget.RecyclerView
import android.view.View
import com.aceplus.roomdatabase.database.Contact
import kotlinx.android.synthetic.main.list_item_contact.view.*

class ContactViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    fun setData(contact: Contact) {
        view.apply {
            tvName.text = contact.name
            tvPhone.text = contact.phone
            tvAddress.text = contact.address
        }
    }
}