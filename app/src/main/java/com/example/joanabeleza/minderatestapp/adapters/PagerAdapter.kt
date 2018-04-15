package com.example.joanabeleza.minderatestapp.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.joanabeleza.minderatestapp.fragments.EventsFragment
import com.example.joanabeleza.minderatestapp.fragments.VacanciesFragment

/**
 * Project MinderaTestApp refactored by joanabeleza on 11/04/2018.
 */
class PagerAdapter(fm: FragmentManager, private var tabCount: Int) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return tabCount
    }

    override fun getItem(position: Int): Fragment? {
        return when (position) {
            0 -> EventsFragment()
            1 -> VacanciesFragment()
            else -> null
        }
    }

}