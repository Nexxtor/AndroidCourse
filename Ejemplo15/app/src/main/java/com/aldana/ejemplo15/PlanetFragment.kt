package com.aldana.ejemplo15

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_planet.view.*


class PlanetFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_planet, container, false).apply {


            var season = model.currentSeason

            when (season) {
                Season.AUTUMN -> {
                    iv_planet.setImageResource(R.drawable.autumn)
                }
                Season.SPRING -> {
                    iv_planet.setImageResource(R.drawable.spring)
                }
                Season.SUMMER -> {
                    iv_planet.setImageResource(R.drawable.summer)
                }
                Season.WINTER -> {
                    iv_planet.setImageResource(R.drawable.winter)
                }
            }
            
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            PlanetFragment().apply {

            }
    }

    private lateinit var model: SeasonViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model = activity?.run {
            ViewModelProviders.of(this).get(SeasonViewModel::class.java)
        } ?: throw Exception("Invalid Activity")

    }

}
