package com.abc.diceroll

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton : Button= findViewById(R.id.button)
        //do a dice roll when app start.
        rollButton.setOnClickListener{

            //roll dice every time when button is clicked
            rollDice()
        }
        // set image when app is opened
        rollDice()
    }
/*
*    method to set image to both dice in layout
*/

    private fun rollDice(){
        // create a dice with 6 sides
        val dice = Dice(6)
        // get random number from roll function in dice
        val diceRoll1=dice.roll1()

        //find the ImageView from layout
       val diceImage1: ImageView = findViewById(R.id.diceImg1)
        //set respective dice picture to to val drawableResources
       val drawableResource1=when(diceRoll1){
         1->R.drawable.dice_1
         2->R.drawable.dice_2
         3->R.drawable.dice_3
         4->R.drawable.dice_4
         5->R.drawable.dice_5
         else->R.drawable.dice_6
       }
        // set image to Image in Layout
        diceImage1.setImageResource(drawableResource1)
        //Update content Description
        diceImage1.contentDescription=diceRoll1.toString()

/*
       for dice 2
*/

        val diceRoll2=dice.roll2()
        val diceImage2: ImageView = findViewById(R.id.diceImg2)
        //set respective dice picture to to val drawableResources
        val drawableResource2=when(diceRoll2){
            1->R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            else->R.drawable.dice_6
        }
        // set image to Image in Layout
        diceImage2.setImageResource(drawableResource2)
        //Update content Description
        diceImage2.contentDescription=diceRoll1.toString()
    }

    /*
        class with 2 methods to set random number to respective dices
    */
    private class Dice (private val numSides:Int){
       fun roll1():Int{
           //return random number to diceRoll
         return(1..numSides).random()
       }
        fun roll2():Int{
            //return random number to diceRoll
            return(1..numSides).random()
        }
    }
}