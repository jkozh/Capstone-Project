package com.example.juliakozhukhovskaya.myapplication

import android.support.annotation.Keep
import java.util.*

class Tile(val uuid: String = UUID.randomUUID().toString(),
           val letter: Char,
           val points: Int) {}