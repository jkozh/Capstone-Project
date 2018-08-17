package com.example.juliakozhukhovskaya.myapplication

import android.arch.lifecycle.ViewModel


class GameViewModel : ViewModel() {

    fun getTiles(): List<Tile>? {
        return TILE_LIST.take(7)
    }

    fun getChips(): List<String>? {
        return SAMPLE_CHIPS.asList()
    }

}