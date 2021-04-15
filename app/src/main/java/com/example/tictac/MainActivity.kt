package com.example.tictac

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity() : AppCompatActivity(), View.OnClickListener {

    private val X_BUTTON = 101
    private val O_BUTTON = 202
    private val RESET_BUTTON = 303
//    private val Info : String = getString(R.string.geo)

    private lateinit var x_button: Button
    private lateinit var o_button: Button

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
    private var xWins = 0
    private var oWins = 0
    private var xoClickedCount = 0

    private var gameButtons = ArrayList<Button>()
    private var firstPlayer = ArrayList<Int>()
    private var secondPlayer = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        x_button = findViewById(R.id.x_scores)
        o_button = findViewById(R.id.o_scores)

        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        gameButtons.add(button1)
        gameButtons.add(button2)
        gameButtons.add(button3)
        gameButtons.add(button4)
        gameButtons.add(button5)
        gameButtons.add(button6)
        gameButtons.add(button7)
        gameButtons.add(button8)
        gameButtons.add(button9)


        resetButton = findViewById(R.id.resetButton)

        for (b in gameButtons) b.setOnClickListener(this)
        x_button.setOnClickListener(this)
        o_button.setOnClickListener(this)

        resetButton.setOnClickListener(this)

        resetGame()
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
                R.id.x_scores -> buttonNumber = X_BUTTON
                R.id.o_scores -> buttonNumber = O_BUTTON
                R.id.resetButton -> buttonNumber = RESET_BUTTON
            }
            if (buttonNumber in (1..9)) {
                playGame(buttonNumber, clickedView)
            }
            if (buttonNumber == RESET_BUTTON) {
                resetGame()
            }
            if (buttonNumber == X_BUTTON || buttonNumber == O_BUTTON){
                xoClickedCount++
                if (xoClickedCount % 10 == 7)
                    Toast.makeText(this, "დაანებე თავი მაგას", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun resetGame() {
        for (b in gameButtons) resetButton(b)
        firstPlayer.clear()
        secondPlayer.clear()
        activePlayer = 1
    }

    private fun resetButton(clickedView: Button) {
        clickedView.setBackgroundColor(Color.BLUE)
        clickedView.text = ""
        clickedView.isEnabled = true
    }

    private fun playGame(buttonNumber: Int, clickedView: Button) {
        if (activePlayer == 1) {
            clickedView.text = "X"
            clickedView.setBackgroundColor(Color.RED)
            activePlayer = 2
            firstPlayer.add(buttonNumber)
        } else {
            clickedView.text = "0"
            clickedView.setBackgroundColor(Color.YELLOW)
            activePlayer = 1
            secondPlayer.add(buttonNumber)
        }
        clickedView.isEnabled = false
        check()
    }

    private fun check() {
        var winnerPlayer = 0
        if (firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(2) && secondPlayer.contains(3)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(4) && secondPlayer.contains(5) && secondPlayer.contains(6)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(7) && secondPlayer.contains(8) && secondPlayer.contains(9)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(4) && firstPlayer.contains(7)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(4) && secondPlayer.contains(7)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(2) && firstPlayer.contains(5) && firstPlayer.contains(8)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(2) && secondPlayer.contains(5) && secondPlayer.contains(8)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(6) && firstPlayer.contains(9)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(6) && secondPlayer.contains(9)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(5) && secondPlayer.contains(9)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(5) && firstPlayer.contains(7)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(5) && secondPlayer.contains(7)) {
            winnerPlayer = 2
        }

        if (winnerPlayer != 0) {
            if (winnerPlayer == 1) {
                xWins++
                val newCount = x_button.text.substring(0, 4) + xWins.toString()
                x_button.text = newCount
                Toast.makeText(this, "X wins!", Toast.LENGTH_LONG).show()
            } else {
                oWins++
                val newCount = o_button.text.substring(0, 4) + oWins.toString()
                o_button.text = newCount
                Toast.makeText(this, "0 Wins!", Toast.LENGTH_LONG).show()
            }
            for (b in gameButtons) b.isEnabled = false
        }
        if (firstPlayer.size + secondPlayer.size == 9) {
            Toast.makeText(this, "Tie!", Toast.LENGTH_LONG).show()
            for (b in gameButtons) b.isEnabled = false
        }

    }
}