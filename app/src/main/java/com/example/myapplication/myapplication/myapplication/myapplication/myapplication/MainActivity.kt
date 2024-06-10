package com.example.myapplication.myapplication.myapplication.myapplication.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

private fun add() {
    TODO("Not yet implemented")
}

abstract class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val daysEditText=findViewById<EditText>(R.id.daysEditText)
        val minWeatherEditText= findViewById<EditText>(R.id.minWeatherEditText)
        val maxWeatherEditText= findViewById<EditText>(R.id.maxWeatherEditText)
        val weatherConditionEditText= findViewById<EditText>(R.id.weatherConditionEditText)
        val viewDetailsButton=findViewById<Button>(R.id.viewDetailsButton)
        val clearButton= findViewById<Button>(R.id.clearButton)
       val exitButton=findViewById<Button>(R.id.exitButton)

        clearButton.setOnClickListener {
            val days= daysEditText.text.toString()
            minWeatherEditText.text.toString()
            maxWeatherEditText.text.toString()
            val weatherCondition= weatherConditionEditText.text.toString()

            if (days.isNotEmpty() && weatherCondition.isNotEmpty()) {
                add()
                add()
                add()
                add()
                Toast.makeText(this,minWeatherEditText,maxWeatherEditText,weatherConditionEditText)
            } else {
                Toast.makeText(this,"Please fill in all fields",Toast.LENGTH_SHORT).show()
        }
//The code that is commented out below will clear all data saved in the arraylist
      clearButton.setOnClickListener {  }
        //days.clear()
        // minWeather()
        // maxWeather()
        // weatherCondition()
        //Toast.makeText(this, "Data cleared", Toast.LENGTH_SHORT).show()
          clearFields(daysEditText,minWeatherEditText,maxWeatherEditText,weatherConditionEditText)


}

    viewDetailsButton.setOnClickListener {
        val intent= intent (this,detailedViewActivity::class.java)
        intent.putStringArrayListExtra("days", daysEditText)
        intent.putStringArrayListExtra("minWeather", minWeatherEditText)
        intent.putStringArrayListExtra("maxWeather", maxWeatherEditText)
        intent.putSringArrayListExtra("weatherCondition", weatherConditionEditText)
        startActivity(intent)
    }
}

    abstract fun intent(mainActivity: MainActivity, java: Class<detailedViewActivity>): Intent?

    abstract fun clearFields(
        daysEditText: EditText?,
        minWeatherEditText: EditText?,
        maxWeatherEditText: EditText?,
        weatherConditionEditText: EditText?
    )
}


