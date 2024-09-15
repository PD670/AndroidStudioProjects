package com.example.kotlin_volley_cms_crud

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class UserAdapter_lv(private val context: Context, private val dataSource: List<User_lv>) : BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return dataSource[position].id.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = inflater.inflate(android.R.layout.simple_list_item_2, parent, false)

        val userLv = getItem(position) as User_lv

        val textView1 = rowView.findViewById<TextView>(android.R.id.text1)
        val textView2 = rowView.findViewById<TextView>(android.R.id.text2)

        textView1.text = userLv.name
        textView2.text = "${userLv.email}, ${userLv.phone}"

        return rowView
    }
}