package com.example.mathgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_game.*
import java.util.*


class GameActivity : AppCompatActivity() {
    private val random= Random()
    private var res:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        generateQuestion()
    }
    //button basqanda
    fun onClick(view:View){
        val SelectedVariant=(view as Button).text.toString().toInt()
        if (SelectedVariant==res){
            generateQuestion()
        }
        else {
            val intent=Intent(this,GameOverActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    //random esap jaratiw
    private fun generateQuestion(){
        var firstNumber=random.nextInt(100)
        val secondNumber=random.nextInt(100)
        when(random.nextInt(4)) {
            0 -> {
                tvQuestion.text = "$firstNumber+$secondNumber"
                res = firstNumber + secondNumber
            }
            1 -> {
                tvQuestion.text = "$firstNumber-$secondNumber"
                res = firstNumber - secondNumber
            }
            2 -> {
                tvQuestion.text = "$firstNumber*$secondNumber"
                res = firstNumber * secondNumber
            }
            2 -> {
                tvQuestion.text = "$firstNumber*$secondNumber"
                res = firstNumber * secondNumber
            }
            3 -> {
                firstNumber=random.nextInt(20)*secondNumber
                tvQuestion.text = "$firstNumber/$secondNumber"
                res = firstNumber / secondNumber
            }
        }
        //Qate juwap variantlarin jaratiw
        val correctAnswerPosition=random.nextInt(4)
        generateWrongAnswers(btnA)
        generateWrongAnswers(btnB)
        generateWrongAnswers(btnC)
        generateWrongAnswers(btnD)
        //Duris juwapti buttonga beriw
        when (correctAnswerPosition){
            0->btnA.text=res.toString()
            1->btnB.text=res.toString()
            2->btnC.text=res.toString()
            3->btnD.text=res.toString()
            
        }
    }
    //qate juwaplardi avto geretatsiya arqali jaratiw
    private fun generateWrongAnswers(button:Button) {
        when (random.nextBoolean()){
            true-> {
                button.text=(res+random.nextInt(10)+1).toString()
            }
            false->button.text=(res+random.nextInt(10)+2).toString()

        }
    }
}