package com.gameloft.android.ANMP.GloftDOH.white

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.gameloft.android.ANMP.GloftDOH.R

class Game : AppCompatActivity() {

    lateinit var enemyPic: ImageView
    lateinit var playerPic: ImageView
    val choices = mutableListOf<String>("Rock", "Paper", "Scissors")
    var playerscore = 0
    var enemyscore = 0
    lateinit var playerScoreText: TextView
    lateinit var enemyScoreText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        enemyPic = findViewById(R.id.enemy_pic)
        playerPic = findViewById(R.id.player_pic)

        playerScoreText = findViewById(R.id.player_score_text)
        enemyScoreText = findViewById(R.id.enemy_score_text)

    }
    fun rock(v: View){
        playerPic.setImageResource(R.drawable.rock)
        val enemychoice = choices.random()
        when (enemychoice){
            "Rock" -> {enemyPic.setImageResource(R.drawable.rock)}

            "Paper" -> {enemyPic.setImageResource(R.drawable.paper)
                enemyscore++
                enemyScoreText.text = enemyscore.toString()}

            "Scissors" -> {enemyPic.setImageResource(R.drawable.scissors)
                playerscore++
                playerScoreText.text = playerscore.toString()}

        }


    }

    fun paper(v: View){
        playerPic.setImageResource(R.drawable.paper)
        val enemychoice = choices.random()
        when (enemychoice){
            "Rock" -> {enemyPic.setImageResource(R.drawable.rock)
                playerscore++
                playerScoreText.text = playerscore.toString()}

            "Paper" -> {enemyPic.setImageResource(R.drawable.paper)}

            "Scissors" -> {enemyPic.setImageResource(R.drawable.scissors)
                enemyscore++
                enemyScoreText.text = enemyscore.toString()}

        }
    }

    fun scissors(v: View){
        playerPic.setImageResource(R.drawable.scissors)
        val enemychoice = choices.random()
        when (enemychoice){
            "Rock" -> {enemyPic.setImageResource(R.drawable.rock)
                enemyscore++
                enemyScoreText.text = enemyscore.toString()}

            "Paper" -> {enemyPic.setImageResource(R.drawable.paper)
                playerscore++
                playerScoreText.text = playerscore.toString()}

            "Scissors" -> {enemyPic.setImageResource(R.drawable.scissors) }

        }
    }


}