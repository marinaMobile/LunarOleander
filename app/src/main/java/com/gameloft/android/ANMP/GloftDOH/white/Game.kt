package com.gameloft.android.ANMP.GloftDOH.white

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.gameloft.android.ANMP.GloftDOH.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class Game : AppCompatActivity() {

    lateinit var enemyPic: ImageView
    lateinit var playerPic: ImageView
    val choices = mutableListOf<String>("Pharaoh", "Q", "Book")
    var playerscore = 0
    var enemyscore = 0
    lateinit var playerScoreText: TextView
    lateinit var enemyScoreText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        MaterialAlertDialogBuilder(this@Game)
            .setTitle("Simple Rules")
            .setMessage("Pharaoh defeats Book, Q defeats Pharaoh, Book defeats Q")
            .setCancelable(false)
            .setPositiveButton("Play"){dialog, _ ->
                dialog.dismiss()
            }
            .create()
            .show()

        enemyPic = findViewById(R.id.enemy_pic)
        playerPic = findViewById(R.id.player_pic)

        playerScoreText = findViewById(R.id.player_score_text)
        enemyScoreText = findViewById(R.id.enemy_score_text)
        win()

    }
    fun rock(v: View){
        playerPic.setImageResource(R.drawable.pharaoh)
        val enemychoice = choices.random()
        when (enemychoice){
            "Pharaoh" -> {enemyPic.setImageResource(R.drawable.pharaoh)}

            "Q" -> {enemyPic.setImageResource(R.drawable.q)
                enemyscore++
                enemyScoreText.text = enemyscore.toString()

            }

            "Book" -> {enemyPic.setImageResource(R.drawable.book)
                playerscore++
                playerScoreText.text = playerscore.toString()

            }

        }


    }

    fun paper(v: View){
        playerPic.setImageResource(R.drawable.q)
        val enemychoice = choices.random()
        when (enemychoice){
            "Pharaoh" -> {enemyPic.setImageResource(R.drawable.pharaoh)
                playerscore++
                playerScoreText.text = playerscore.toString()}

            "Q" -> {enemyPic.setImageResource(R.drawable.q)}

            "Book" -> {enemyPic.setImageResource(R.drawable.book)
                enemyscore++
                enemyScoreText.text = enemyscore.toString()}

        }
        win()
    }

    fun scissors(v: View) {
        playerPic.setImageResource(R.drawable.book)
        val enemychoice = choices.random()
        when (enemychoice) {
            "Pharaoh" -> {
                enemyPic.setImageResource(R.drawable.pharaoh)
                enemyscore++
                enemyScoreText.text = enemyscore.toString()
            }

            "Q" -> {
                enemyPic.setImageResource(R.drawable.q)
                playerscore++
                playerScoreText.text = playerscore.toString()
            }

            "Book" -> {
                enemyPic.setImageResource(R.drawable.book)
            }

        }
        win()
    }

    private fun win() {
        val plscr = playerscore.toString()
        val enscr = enemyscore.toString()
        val intent = Intent(this@Game, FinishAct::class.java)
        intent.putExtra("key", plscr)
        intent.putExtra("key2", enscr)

        if (playerscore > 2 && playerscore > enemyscore) {

            startActivity(intent)

        } else if (enemyscore > 2 && enemyscore > playerscore ) {

            startActivity(intent)

        }
    }

}