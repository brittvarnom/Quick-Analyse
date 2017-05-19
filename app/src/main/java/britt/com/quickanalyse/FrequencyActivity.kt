package britt.com.quickanalyse

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_analysis_result.*

class FrequencyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frequency)
        val type = ""
        setFrequencyDisplayed(type)
    }

    fun setFrequencyDisplayed(type: String) {


        if (type == "char") {
            analyser_display_result.text = "charFrequency"
        } else if (type == "word") {
            analyser_display_result.text = "wordFrequency"
        } else {
            analyser_display_result.text = "N/A"
        }
    }
}
