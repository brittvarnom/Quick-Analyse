package britt.com.quickanalyse

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_analysis_result.*

class FrequencyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frequency)
        val type = ""
        val charFrequency = intent.getStringExtra("char freq")
        setFrequencyDisplayed(charFrequency)
    }

    fun setFrequencyDisplayed(type: String) {
            analyser_display_result.text = type
    }
}
