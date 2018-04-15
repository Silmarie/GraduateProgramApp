package com.example.joanabeleza.minderatestapp.Fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.joanabeleza.minderatestapp.Adapters.EventsAdapter

import com.example.joanabeleza.minderatestapp.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class EventsFragment : Fragment() {

    private lateinit var rvEvents: RecyclerView
    private lateinit var rvGraduateProgram: RecyclerView
    private lateinit var rvMeetMindera: RecyclerView
    private lateinit var eventsAdapter: RecyclerView.Adapter<*>
    private lateinit var eventsManager: RecyclerView.LayoutManager
    private lateinit var graduteProgramAdapter: RecyclerView.Adapter<*>
    private lateinit var graduteProgramManager: RecyclerView.LayoutManager
    private lateinit var meetMinderaAdapter: RecyclerView.Adapter<*>
    private lateinit var meetMinderaManager: RecyclerView.LayoutManager
    private lateinit var eventsData: Array<String>
    private lateinit var emptyData: Array<String>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_events, container, false)

        rvEvents = view.findViewById<RecyclerView>(R.id.rv_events_open_day).apply {
            setHasFixedSize(true)
            layoutManager = eventsManager
            adapter = eventsAdapter
        }

        rvGraduateProgram = view.findViewById<RecyclerView>(R.id.rv_events_graduate_program).apply {
            setHasFixedSize(true)
            layoutManager = graduteProgramManager
            adapter = graduteProgramAdapter
        }

        rvMeetMindera = view.findViewById<RecyclerView>(R.id.rv_events_meet_mindera).apply {
            setHasFixedSize(true)
            layoutManager = meetMinderaManager
            adapter = meetMinderaAdapter
        }


        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loadData()
        eventsManager = LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
        eventsAdapter = EventsAdapter(eventsData)

        graduteProgramManager = LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
        graduteProgramAdapter = EventsAdapter(emptyData)

        meetMinderaManager = LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
        meetMinderaAdapter = EventsAdapter(emptyData)
    }

    private fun loadData() {
        eventsData = Array(10, {""})
        for (i in 1..10) {
            eventsData[i - 1] = ("Day ${i.toString().padStart(2, '0')}")
        }
        emptyData = Array(10, {""})
    }

}
