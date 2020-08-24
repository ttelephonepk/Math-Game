package com.example.mathgame

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import com.example.mathgame.R.id.activity_main as activity_main


class MainActivity : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Close basilganda oyinnan shigiw
        CloseButtom.setOnClickListener {
            finish()
        }
        //Play basilganda oyin aynasina otiw (GameActivityge)
        playButton.setOnClickListener {
            val intent= Intent(this,GameActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}