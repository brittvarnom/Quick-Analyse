package britt.com.quickanalyse

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_analysis_result.*
import android.text.method.ScrollingMovementMethod
import kotlinx.android.synthetic.main.activity_frequency.*


class FrequencyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frequency)
        analyser_display_frequency_result.movementMethod = ScrollingMovementMethod()
        val type = ""
        val charFrequency = intent.getStringExtra("char freq")
        setFrequencyDisplayed(charFrequency)
    }

    fun setFrequencyDisplayed(type: String) {
            analyser_display_frequency_result.text = type
    }
}
