package com.example.diceroll

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
    }

    private fun rollDice() {
        val diceImage: ImageView = findViewById(R.id.imageView)
        val dice = Dice(6)
        val diceRoll = dice.roll()

        val luckyNumber = 4
        var resultString = ""
        val drawableResource = when (diceRoll) {
            luckyNumber -> {
                resultString = "a lucky number!"
                R.drawable.dice_4
            }
            1 -> {
                resultString = "1"
                R.drawable.dice_1
            }
            2 -> {
                resultString = "2"
                R.drawable.dice_2
            }
            3 -> {
                resultString = "3"
                R.drawable.dice_3
            }
            5 -> {
                resultString = "5"
                R.drawable.dice_5
            }
            else -> {
                resultString = "6"
                R.drawable.dice_6
            }
        }
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = drawableResource.toString()
        Toast.makeText(this, "Congrats on rolling $resultString", Toast.LENGTH_LONG).show()
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}