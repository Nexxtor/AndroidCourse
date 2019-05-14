package com.aldana.ejemplo15

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SeasonBarFragment.OnTabListener {

    lateinit var viewModelSeason: SeasonViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModelSeason = ViewModelProviders.of(this).get(SeasonViewModel::class.java)

        if (savedInstanceState == null) {
            var fragment: ClothesFragment = ClothesFragment.newInstance()
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fl_content, fragment).commit()
        }

        bt_clothes.setOnClickListener {
            viewModelSeason.clothesDisplay = true
            changeFragmentType()
        }

        bt_planet.setOnClickListener {
            viewModelSeason.clothesDisplay = false
            changeFragmentType()
        }
    }

    override fun onSeasonSelect(season: String) {

        viewModelSeason.currentSeason = season

        changeFragmentType()
    }

    fun changeFragmentType() {
        var fragment = if (viewModelSeason.clothesDisplay){
            ClothesFragment.newInstance()
        }else {
            PlanetFragment.newInstance()
        }
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.fl_content, fragment)
                .commit()
    }
}
