package com.example.joanabeleza.minderatestapp.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.joanabeleza.minderatestapp.R

/**
 * Project MinderaTestApp refactored by joanabeleza on 14/04/2018.
 */
class EventDetailDescriptionAdapter(private val eventDetailDescriptions: Array<String>) : RecyclerView.Adapter<EventDetailDescriptionAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val eventDetailsView = LayoutInflater.from(parent.context)
                .inflate(R.layout.event_detail_description_list_item, parent, false)
        return ViewHolder(eventDetailsView)
    }

    override fun getItemCount(): Int {
        return eventDetailDescriptions.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.item.text = eventDetailDescriptions[position]
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val item: TextView = v.findViewById(R.id.tv_event_detail_description_list_item)
    }
}