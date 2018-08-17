package com.example.juliakozhukhovskaya.myapplication

import android.graphics.Paint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.CardView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.TextView
import org.jetbrains.anko.wrapContent
import android.arch.lifecycle.ViewModelProviders
import android.graphics.Color
import org.jetbrains.anko.textColor


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val model = ViewModelProviders.of(this).get(GameViewModel::class.java)

        setTiles(model.getTiles())

        addChips(model.getChips())

        for (i in 1..7) {
            val id = resources.getIdentifier("cv$i", "id", packageName)
            val cv = findViewById<CardView>(id)
            cv.setOnClickListener {
                Toast.makeText(applicationContext, (it.tag as Tile).letter.toString(), Toast.LENGTH_SHORT).show()
            }
            cv.tag = model.getTiles()?.get(i-1)
        }
    }

    private fun addChips(chips: List<String>?) {
        chips?.forEach {
            val chip = android.support.design.chip.Chip(this)
            chip.text = it
            chip.paintFlags = chip.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            chip.width = wrapContent
            chip.height = wrapContent
            chip.textColor = Color.parseColor("#ffffff")
            chip.setChipBackgroundColorResource(R.color.colorPurpleLight)
            chip_group.addView(chip)
        }
    }

    private fun setTiles(tiles: List<Tile>?) {
        for (i in 1..7) {
            val id = resources.getIdentifier("score_tv_$i", "id", packageName)
            val textView = findViewById<TextView>(id)
            textView.text = tiles?.get(i-1)?.points.toString()
        }
        for (i in 1..7) {
            val id = resources.getIdentifier("letter_tv_$i", "id", packageName)
            val textView = findViewById<TextView>(id)
            textView.text = tiles?.get(i-1)?.letter.toString()
        }
    }
}
