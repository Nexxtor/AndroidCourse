package com.aldana.ejemplo15

import androidx.lifecycle.ViewModel

class SeasonViewModel : ViewModel() { // TODO 2: ViewModel utilizado para compartir datos entre fragmentos
    var currentSeason = Season.SUMMER
    var clothesDisplay: Boolean = true
}