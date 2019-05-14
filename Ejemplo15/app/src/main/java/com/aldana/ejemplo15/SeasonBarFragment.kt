package com.aldana.ejemplo15

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_season_bar.view.*

class SeasonBarFragment : Fragment() {
    private var listener: OnTabListener? = null


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_season_bar, container, false).apply {
            bt_autumn.setOnClickListener {

                onButtonPressed(Season.AUTUMN)
                
            }
            bt_summer.setOnClickListener {
                onButtonPressed(Season.SUMMER)
            }
            bt_winter.setOnClickListener {
                onButtonPressed(Season.WINTER)
            }
            bt_spring.setOnClickListener {
                onButtonPressed(Season.SPRING)
            }
        }
    }


    fun onButtonPressed(season: String) {
        listener?.onSeasonSelect(season)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnTabListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnTabListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnTabListener {
        fun onSeasonSelect(season: String)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model = activity?.run {
            ViewModelProviders.of(this).get(SeasonViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
    }

    lateinit var model: SeasonViewModel

    companion object {

        @JvmStatic
        fun newInstance() =
                SeasonBarFragment().apply {
                }
    }
}
