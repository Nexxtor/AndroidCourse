package com.aldana.ejemplo15

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_clothes.view.*


class ClothesFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model = activity?.run {
            // TODO 3: Se obtiene la instancia del ViewModel de la actividad a la cual el fragmento ha sido agregado.
            ViewModelProviders.of(this).get(SeasonViewModel::class.java)
        } ?: throw Exception("Invalid Activity")

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_clothes, container, false).apply {

            // TODO 4: Las acciones de los fragmentos dependen de los valores del ViewModel

            var season = model.currentSeason

            when (season) {
                Season.AUTUMN -> {
                    iv_clothes.setImageResource(R.drawable.autumn_clothes)
                }
                Season.SPRING -> {
                    iv_clothes.setImageResource(R.drawable.spring_clothes)
                }
                Season.SUMMER -> {
                    iv_clothes.setImageResource(R.drawable.summer_clothes)
                }
                Season.WINTER -> {
                    iv_clothes.setImageResource(R.drawable.winter_clothes)
                }
            }

        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ClothesFragment()

    }

    private lateinit var model: SeasonViewModel
}
