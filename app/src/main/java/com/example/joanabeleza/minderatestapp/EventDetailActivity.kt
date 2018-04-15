package com.example.joanabeleza.minderatestapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.joanabeleza.minderatestapp.Adapters.EventDetailsAdapter
import com.example.joanabeleza.minderatestapp.Adapters.EventsAdapter.ViewHolder.Companion.EVENT_KEY
import kotlinx.android.synthetic.main.activity_main.*

class EventDetailActivity : AppCompatActivity() {
    private lateinit var rvEventDetailList: RecyclerView
    private lateinit var eventsAdapter: RecyclerView.Adapter<*>
    private lateinit var eventsManager: RecyclerView.LayoutManager
    private lateinit var eventDetailsData: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_detail)

        setSupportActionBar(toolbar)
        supportActionBar?.title = intent.getStringExtra(EVENT_KEY)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        loadData()
        eventsManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        eventsAdapter = EventDetailsAdapter(eventDetailsData)

        rvEventDetailList = findViewById<RecyclerView>(R.id.rv_event_detail_list).apply {
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
        eventDetailsData = Array(10, {""})
        for (i in 1..10) {
            eventDetailsData[i - 1] = ("List ${i.toString().padStart(2, '0')}")
        }
    }
}
