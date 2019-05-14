package com.aldana.ejemplo15

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_image.view.*


private const val ARG_TYPE = "TYPE"
private const val ARG_SEASON = "SEASON"


class ImageFragment : Fragment() {
    private var type: String? = null
    private var season: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            type = it.getString(ARG_TYPE)
            season = it.getString(ARG_SEASON)
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_image, container, false).apply {
            if (type == "clothes") {
                with(iv_image_content) {
                    when (season) {
                        Season.AUTUMN -> {
                            setImageResource(R.drawable.autumn_clothes)
                        }
                        Season.SPRING -> {
                            setImageResource(R.drawable.spring_clothes)
                        }
                        Season.SUMMER -> {
                            setImageResource(R.drawable.summer_clothes)
                        }
                        Season.WINTER -> {
                            setImageResource(R.drawable.winter_clothes)
                        }
                    }
                }
            } else {
                with(iv_image_content) {
                    when (season) {
                        Season.AUTUMN -> {
                            setImageResource(R.drawable.autumn)
                        }
                        Season.SPRING -> {
                            setImageResource(R.drawable.spring)
                        }
                        Season.SUMMER -> {
                            setImageResource(R.drawable.summer)
                        }
                        Season.WINTER -> {
                            setImageResource(R.drawable.winter)
                        }
                    }
                }
            }
        }
    }


    companion object {
        @JvmStatic
        fun newInstance(type: String, season: String) =
                ImageFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_TYPE, type)
                        putString(ARG_SEASON, season)
                    }
                }
    }
}
