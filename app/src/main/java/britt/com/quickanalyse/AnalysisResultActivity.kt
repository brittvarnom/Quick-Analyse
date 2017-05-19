package britt.com.quickanalyse

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_analysis_result.*

class AnalysisResultActivity : AppCompatActivity() {

    var characterMap: MutableMap<String, Int> = mutableMapOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_analysis_result)
        var results = intent.getStringExtra("results")
        analyser_display_result.text = results
        goToFrequencyOnClick()
    }

    fun goToFrequencyOnClick() {
        val charFrequencyIntent = Intent(this@AnalysisResultActivity, FrequencyActivity().javaClass)
        val wordFrequencyIntent = Intent(this@AnalysisResultActivity, FrequencyActivity().javaClass)
        val characterList = characterMap.toList().toTypedArray()
        charFrequencyIntent.putExtra("char frequency", characterList)
        wordFrequencyIntent.putExtra("word frequency", characterList)
        analyser_chars_frequency_button.setOnClickListener {
            startActivity(charFrequencyIntent)
        }
        analyser_wordss_frequency_button.setOnClickListener {
            startActivity(wordFrequencyIntent)
        }
    }
}
