package com.example.jobprovider

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ItemAdapter(val context: Activity, val arrayList: List<user>):RecyclerView.Adapter<ItemAdapter.itemViewHolder>(){
    class itemViewHolder(ItemView:View):RecyclerView.ViewHolder(ItemView){
        val type = ItemView.findViewById<TextView>(R.id.type)
        val date = ItemView.findViewById<TextView>(R.id.date)
        val slot = ItemView.findViewById<TextView>(R.id.timeslot)
        val day = ItemView.findViewById<TextView>(R.id.day)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.customitem,parent,false)
        return itemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: itemViewHolder, position: Int) {
        holder.type.text = arrayList[position].type
        holder.date.text = arrayList[position].date
        holder.slot.text = arrayList[position].slot
        holder.day.text = arrayList[position].day
    }
}