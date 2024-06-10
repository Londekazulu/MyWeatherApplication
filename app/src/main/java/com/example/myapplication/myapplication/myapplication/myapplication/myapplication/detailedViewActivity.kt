package com.example.myapplication.myapplication.myapplication.myapplication.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class detailedViewActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_view)

        val days = intent.getStringArrayListExtra("days")?: arrayListOf()
        val minWeather= intent.getStringArrayListExtra("minWeather")?: arrayListOf()
        val maxWeather= intent.getStringArrayListExtra("maxWeather")?: arrayListOf()
        val weatherCondition = intent.getStringArrayListExtra("weatherCondition")?: arrayListOf()


        val detailsTextView= findViewById<TextView>(R.id.detailsTextView)
        val averageTemperatureTextView=findViewById<TextView>(R.id.averageTemperatureTextView)
        val backButton= findViewById<Button>(R.id.backButton)


        val totalWeatherTemperature= 0
        var displayTextView= ""
        for (i in days.indices){
            val dailyWeatherTemperature= minWeather[i]+ maxWeather[i]
            totalWeatherTemperature+= dailyWeatherTemperature
            displayTextView+= "Day: ${days[i]}, Min:${minWeather[i]}min, Max:${maxWeather[i]}min,Condition:${weatherCondition[i]}\n\n"
        }
        val averageTemperature= if (days.isNotEmpty())totalWeatherTemperature/ days.size else 0


        detailsTextView.text= displayTextView
        averageTemperatureTextView.text= "Average Temperature: $averageTemperature temperature/ day"


        backButton.setOnClickListener {
            val intent= intent(this, MainActivity::class.java)
            startActivity(intent)


        }
    }

    private fun intent(detailedViewActivity: detailedViewActivity, java: Class<MainActivity>): Intent? {

    }
}

private operator fun Int.plusAssign(dailyWeatherTemperature: String) {
    TODO("Not yet implemented")
}
