[README FILE.md.txt](https://github.com/user-attachments/files/15766491/README.FILE.md.txt)


package
com.example.myapplication.myapplication.myapplication.myapplication.myapplication  
  
import android.annotation.SuppressLint  
import androidx.appcompat.app.AppCompatActivity  
import android.os.Bundle  
import android.widget.Button  
import
com.example.myapplication.myapplication.myapplication.myapplication.myapplication.R.id.*exitButton  
*import
com.example.myapplication.myapplication.myapplication.myapplication.myapplication.R.id.*startButton  
  
*@SuppressLint("CustomSplashScreen")  
class SplashActivity : AppCompatActivity() {  
override fun onCreate(savedInstanceState: Bundle?) {  
super.onCreate(savedInstanceState)  
setContentView(R.layout.*activity_splash*)  
  
val startButton = findViewById\<Button>(*startButton*)  
val exitButton = findViewById\<Button>(*exitButton*)  
  
startButton.setOnClickListener **{  
**val intent = intent(this, MainActivity::class.*java*)  
startActivity(intent)  
**}  
  
**exitButton.setOnClickListener **{  
**finish()  
**}  
**}  
}

package
com.example.myapplication.myapplication.myapplication.myapplication.myapplication  
  
import android.annotation.SuppressLint  
import android.content.Intent  
import androidx.appcompat.app.AppCompatActivity  
import android.os.Bundle  
import android.widget.Button  
import android.widget.EditText  
import android.widget.Toast  
  
class MainActivity : AppCompatActivity() {  
@SuppressLint("MissingInflatedId")  
override fun onCreate(savedInstanceState: Bundle?) {  
super.onCreate(savedInstanceState)  
setContentView(R.layout.*activity_main*)  
  
val daysEditText = findViewById\<EditText>(R.id.*daysEditText*)  
val minWeatherEditText =
findViewById\<EditText>(R.id.*minWeatherEditText*)  
val maxWeatherEditText =
findViewById\<EditText>(R.id.*maxWeatherEditText*)  
val weatherConditionEditText =
findViewById\<EditText>(R.id.*weatherConditionEditText*)  
val viewDetailsButton =
findViewById\<Button>(R.id.*viewDetailsButton*)  
val clearButton = findViewById\<Button>(R.id.*clearButton*)  
val exitButton = findViewById\<Button>(R.id.*exitButton*)  
  
clearButton.setOnClickListener **{  
**val days = daysEditText.*text*.toString()  
val minWeather = minWeatherEditText.*text*.toString()  
val maxWeather = maxWeatherEditText.*text*.toString()  
val weatherCondition = weatherConditionEditText.*text*.toString()  
  
if (days.*isNotEmpty*() && minWeather.*isNotEmpty*() &&
maxWeather.*isNotEmpty*() && weatherCondition.*isNotEmpty*()) {  
Toast.makeText(this, "Data added: $days, $minWeather, $maxWeather,
$weatherCondition", Toast.*LENGTH_SHORT*).show()  
} else {  
Toast.makeText(this, "Please fill in all fields",
Toast.*LENGTH_SHORT*).show()  
}  
clearFields(daysEditText, minWeatherEditText, maxWeatherEditText,
weatherConditionEditText)  
**}  
  
**viewDetailsButton.setOnClickListener **{  
**val intent = Intent(this, DetailedViewActivity::class.*java*)  
intent.putStringArrayListExtra("days",
*arrayListOf*(daysEditText.*text*.toString()))  
intent.putStringArrayListExtra("minWeather",
*arrayListOf*(minWeatherEditText.*text*.toString()))  
intent.putStringArrayListExtra("maxWeather",
*arrayListOf*(maxWeatherEditText.*text*.toString()))  
intent.putStringArrayListExtra("weatherCondition",
*arrayListOf*(weatherConditionEditText.*text*.toString()))  
startActivity(intent)  
**}  
  
**exitButton.setOnClickListener **{  
**finish()  
**}  
**}  
  
private fun clearFields(  
daysEditText: EditText,  
minWeatherEditText: EditText,  
maxWeatherEditText: EditText,  
weatherConditionEditText: EditText  
) {  
daysEditText.*text*.clear()  
minWeatherEditText.*text*.clear()  
maxWeatherEditText.*text*.clear()  
weatherConditionEditText.*text*.clear()  
}  
}

package
com.example.myapplication.myapplication.myapplication.myapplication.myapplication  
  
import android.annotation.SuppressLint  
import android.content.Intent  
import androidx.appcompat.app.AppCompatActivity  
import android.os.Bundle  
import android.widget.Button  
import android.widget.TextView  
  
class DetailedViewActivity : AppCompatActivity() {  
@SuppressLint("SetTextI18n")  
override fun onCreate(savedInstanceState: Bundle?) {  
super.onCreate(savedInstanceState)  
setContentView(R.layout.*activity_detailed_view*)  
  
val days = *intent*.getStringArrayListExtra("days") ?: *arrayListOf*()  
val minWeather = *intent*.getStringArrayListExtra("minWeather") ?:
*arrayListOf*()  
val maxWeather = *intent*.getStringArrayListExtra("maxWeather") ?:
*arrayListOf*()  
val weatherCondition =
*intent*.getStringArrayListExtra("weatherCondition") ?:
*arrayListOf*()  
  
val detailsTextView = findViewById\<TextView>(R.id.*detailsTextView*)  
val averageTemperatureTextView =
findViewById\<TextView>(R.id.*averageTemperatureTextView*)  
val backButton = findViewById\<Button>(R.id.*backButton*)  
  
var totalWeatherTemperature = 0  
var displayText = ""  
  
for (i in days.*indices*) {  
val minTemp = minWeather\[i\].*toIntOrNull*() ?: 0  
val maxTemp = maxWeather\[i\].*toIntOrNull*() ?: 0  
val dailyWeatherTemperature = minTemp + maxTemp  
totalWeatherTemperature += dailyWeatherTemperature  
displayText += "Day: ${days\[i\]}, Min: ${minTemp}°, Max: ${maxTemp}°,
Condition: ${weatherCondition\[i\]}\\n\\n"  
}  
  
val averageTemperature = if (days.*isNotEmpty*())
totalWeatherTemperature / days.size else 0  
  
detailsTextView.*text* = displayText  
averageTemperatureTextView.*text* = "Average Temperature:
$averageTemperature°/day"  
  
backButton.setOnClickListener **{  
**val intent = Intent(this, MainActivity::class.*java*)  
startActivity(intent)  
**}  
**}  
}

