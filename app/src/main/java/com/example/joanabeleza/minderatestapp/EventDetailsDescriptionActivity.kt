package com.example.joanabeleza.minderatestapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.joanabeleza.minderatestapp.Adapters.EventDetailDescriptionAdapter
import com.example.joanabeleza.minderatestapp.Adapters.EventDetailsAdapter.ViewHolder.Companion.EVENT_DETAIL_KEY
import kotlinx.android.synthetic.main.activity_main.*

class EventDetailsDescriptionActivity : AppCompatActivity() {

    private lateinit var rvEventDetailDescriptionList: RecyclerView
    private lateinit var eventsAdapter: RecyclerView.Adapter<*>
    private lateinit var eventsManager: RecyclerView.LayoutManager
    private lateinit var eventDetailDescriptionsData: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_details_description)

        setSupportActionBar(toolbar)
        supportActionBar?.title = intent.getStringExtra(EVENT_DETAIL_KEY)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        loadData()
        eventsManager = GridLayoutManager(this, 2)
        eventsAdapter = EventDetailDescriptionAdapter(eventDetailDescriptionsData)

        rvEventDetailDescriptionList = findViewById<RecyclerView>(R.id.rv_event_detail_description_list).apply {
            setHasFixedSize(true)
            layoutManager = eventsManager
            adapter = eventsAdapter
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun loadData() {
        eventDetailDescriptionsData = Array(10, {""})
        for (i in 1..10) {
            eventDetailDescriptionsData[i - 1] = ("Description ${i.toString().padStart(2, '0')}")
        }
    }
}
