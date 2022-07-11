package com.example.geocomputers.ticktacktoe

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonClick(view: View) {
        val buttonSelected = view as Button
        var cellID = 0
        when (buttonSelected.id) {
            R.id.button1 -> cellID = 1
            R.id.button2 -> cellID = 2
            R.id.button3 -> cellID = 3
            R.id.button4 -> cellID = 4
            R.id.button5 -> cellID = 5
            R.id.button6 -> cellID = 6
            R.id.button7 -> cellID = 7
            R.id.button8 -> cellID = 8
            R.id.button9 -> cellID = 9
        }

        playGame(cellID, buttonSelected)
    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

    var activePlayer = 1
    var total = 0

    private fun playGame(cellID: Int, buttonSelected: Button) {
        if(activePlayer == 1){
            buttonSelected.text = "X"
            player1.add(cellID)
            total += 1
            activePlayer = 2
        }else{
            buttonSelected.text = "O"
            player2.add(cellID)
            total += 1
            activePlayer = 1
        }
        buttonSelected.isEnabled = false

        checkWinner()
        if (total == 9){
            Toast.makeText(this, "DRAW",Toast.LENGTH_LONG).show()
        }
    }

    private fun checkWinner() {
       var winner = -1
        if(player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winner = 1
        }
        if(player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winner = 2
        }
        if(player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winner = 1
        }
        if(player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winner = 2
        }
        if(player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winner = 1
        }
        if(player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winner = 2
        }
        if(player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winner = 1
        }
        if(player2.contains(1) && player2.contains(4) && player2.contains(7)){
            winner = 2
        }
        if(player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winner = 1
        }
        if(player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winner = 2
        }
        if(player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winner = 1
        }
        if(player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winner = 2
        }
        if(player1.contains(1) && player1.contains(5) && player1.contains(9)){
            winner = 1
        }
        if(player2.contains(1) && player2.contains(5) && player2.contains(9)){
            winner = 2
        }
        if(player1.contains(3) && player1.contains(5) && player1.contains(7)){
            winner = 1
        }
        if(player2.contains(3) && player2.contains(5) && player2.contains(7)){
            winner = 2
        }
        if(winner != -1){
            if(winner == 1){
                buttonDisabled()
                Toast.makeText(this, "Player 1 Won The Game",Toast.LENGTH_LONG).show()
            }else{
                buttonDisabled()
                Toast.makeText(this, "Player 2 Won The Game",Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun buttonDisabled() {
        val button1 = findViewById<View>(R.id.button1) as Button
        button1.isEnabled = false
        val button2 = findViewById<View>(R.id.button2) as Button
        button2.isEnabled = false
        val button3 = findViewById<View>(R.id.button3) as Button
        button3.isEnabled = false
        val button4 = findViewById<View>(R.id.button4) as Button
        button4.isEnabled = false
        val button5 = findViewById<View>(R.id.button5) as Button
        button5.isEnabled = false
        val button6 = findViewById<View>(R.id.button6) as Button
        button6.isEnabled = false
        val button7 = findViewById<View>(R.id.button7) as Button
        button7.isEnabled = false
        val button8 = findViewById<View>(R.id.button8) as Button
        button8.isEnabled = false
        val button9 = findViewById<View>(R.id.button9) as Button
        button9.isEnabled = false
    }
}
