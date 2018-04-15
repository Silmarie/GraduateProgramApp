package com.example.joanabeleza.minderatestapp.Adapters

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.joanabeleza.minderatestapp.EventDetailActivity
import com.example.joanabeleza.minderatestapp.R
import com.example.joanabeleza.minderatestapp.R.layout.event_list_item

/**
 * Project MinderaTestApp refactored by joanabeleza on 12/04/2018.
 */
class EventsAdapter(private val events: Array<String>) : RecyclerView.Adapter<EventsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val eventsView = LayoutInflater.from(parent.context)
                .inflate(R.layout.event_list_item, parent, false)
        return ViewHolder(eventsView)
    }

    override fun getItemCount(): Int {
       return events.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.day.text = events[position]
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        val day = v.findViewById<TextView>(R.id.tv_event_list_item_day_label)

        init {
            v.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            val context = v.context
            val showEventDetails = Intent(context, EventDetailActivity::class.java)
            showEventDetails.putExtra(EVENT_KEY, "${v.context.resources.getString(R.string.tv_open_day_18)} _ ${day.text}")
            context.startActivity(showEventDetails)
        }

        companion object {
            const val EVENT_KEY = "EVENT"
        }
    }
}