package com.example.joanabeleza.minderatestapp.Adapters

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.joanabeleza.minderatestapp.EventDetailActivity
import com.example.joanabeleza.minderatestapp.EventDetailsDescriptionActivity
import com.example.joanabeleza.minderatestapp.R

/**
 * Project MinderaTestApp refactored by joanabeleza on 14/04/2018.
 */
class EventDetailsAdapter(private val eventDetails: Array<String>) : RecyclerView.Adapter<EventDetailsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val eventDetailDescriptionsView = LayoutInflater.from(parent.context)
                .inflate(R.layout.event_detail_list_item, parent, false)
        return ViewHolder(eventDetailDescriptionsView)
    }

    override fun getItemCount(): Int {
        return eventDetails.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.item.text = eventDetails[position]
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        val item = v.findViewById<TextView>(R.id.tv_event_detail_list_item)

        init {
            v.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            val context = v.context
            val showEventDetailDescriptions = Intent(context, EventDetailsDescriptionActivity::class.java)
            showEventDetailDescriptions.putExtra(EVENT_DETAIL_KEY, item.text)
            context.startActivity(showEventDetailDescriptions)
        }

        companion object {
            const val EVENT_DETAIL_KEY = "EVENT_DETAIL"
        }
    }
}