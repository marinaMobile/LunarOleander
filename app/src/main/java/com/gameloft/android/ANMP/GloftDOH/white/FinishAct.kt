package com.gameloft.android.ANMP.GloftDOH.white

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gameloft.android.ANMP.GloftDOH.R
import kotlinx.android.synthetic.main.activity_finish.*
import kotlinx.android.synthetic.main.activity_game.*
import kotlinx.android.synthetic.main.activity_game.enemy_score_text
import kotlinx.android.synthetic.main.activity_game.player_score_text

class FinishAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        val plScr = intent.getStringExtra("key")?.toInt()
        val enScr = intent.getStringExtra("key2")?.toInt()

        if(plScr!! > enScr!!) {
            win_text.setText("You win")
        } else {
            win_text.setText("You lose")
        }


        play_again.setOnClickListener {
            startActivity(Intent(this, Game::class.java))
        }

    }
}