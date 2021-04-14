package com.example.tictac

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity() : AppCompatActivity(), View.OnClickListener {

    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button

    private lateinit var resetButton: Button

    private var activePlayer = 1

    private var firstPlayer = ArrayList<Int>()
    private var secondPlayer = ArrayList<Int>()

    constructor(parcel: Parcel) : this() {
        activePlayer = parcel.readInt()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)

        resetButton = findViewById(R.id.resetButton)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button3.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)

        resetButton.setOnClickListener(this)
    }

    override fun onClick(clickedView: View?) {
        if (clickedView is Button) {
            var buttonNumber = 0
            when (clickedView.id) {
                R.id.button1 -> buttonNumber = 1
                R.id.button2 -> buttonNumber = 2
                R.id.button3 -> buttonNumber = 3
                R.id.button4 -> buttonNumber = 4
                R.id.button5 -> buttonNumber = 5
                R.id.button6 -> buttonNumber = 6
                R.id.button7 -> buttonNumber = 7
                R.id.button8 -> buttonNumber = 8
                R.id.button9 -> buttonNumber = 9
            }
            if (buttonNumber != 0){
                playGame(buttonNumber, clickedView)
            }
        }
    }

    private fun playGame(buttonNumber: Int, clickedView: Button) {
        if (activePlayer == 1) {
            clickedView.text = "X"
            clickedView.setBackgroundColor(Color.RED)
            activePlayer = 2
            firstPlayer.add(buttonNumber)
        } else {
            clickedView.text = "0"
            clickedView.setBackgroundColor(Color.BLUE)
            activePlayer = 1
            secondPlayer.add(buttonNumber)
        }
        clickedView.isEnabled = false
        check()
    }

    private fun check() {
        var winnerPlayer = 0
        if (firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(2) && secondPlayer.contains(3)){
            winnerPlayer = 2
        }
        if (firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(4) && secondPlayer.contains(5) && secondPlayer.contains(6)){
            winnerPlayer = 2
        }
        if (firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(7) && secondPlayer.contains(8) && secondPlayer.contains(9)){
            winnerPlayer = 2
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(4) && firstPlayer.contains(7)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(4) && secondPlayer.contains(7)){
            winnerPlayer = 2
        }
        if (firstPlayer.contains(2) && firstPlayer.contains(5) && firstPlayer.contains(8)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(2) && secondPlayer.contains(5) && secondPlayer.contains(8)){
            winnerPlayer = 2
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(6) && firstPlayer.contains(9)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(6) && secondPlayer.contains(9)){
            winnerPlayer = 2
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(5) && secondPlayer.contains(9)){
            winnerPlayer = 2
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(5) && firstPlayer.contains(7)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(5) && secondPlayer.contains(7)){
            winnerPlayer = 2
        }

        if (winnerPlayer != 0){
            if (winnerPlayer == 1){
                Toast.makeText(this, "X wins!", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "0 Wins!", Toast.LENGTH_LONG).show()
            }
        }

    }
}