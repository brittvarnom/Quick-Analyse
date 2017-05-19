package britt.com.quickanalyse

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_analysis_result.*

class AnalysisResultActivity : AppCompatActivity() {

    var countsLetters = false
    var countsNumbers = false
    var countsSymbols = false
    var countsWords = false
    var countsLongestWord = false
    var countsCFreq = false
    var countsWLengthFreq = false
    var countsCRFreq = false
    var countsWLengthRFreq = false
    var cChart = false
    var wChart = false

    var characterMap: MutableMap<String, Int> = mutableMapOf()

    val analyseCharacters = AnalyseCharacters()
    val analyseWords = AnalyseWords()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_analysis_result)
        val results = intent.getStringExtra("results")
        analyser_display_result.text = results
        goToFrequencyOnClick(results)
    }

    fun goToFrequencyOnClick(text: String) {
        val charFrequencyIntent = Intent(this@AnalysisResultActivity, FrequencyActivity().javaClass)
        charFrequencyIntent.putExtra("char freq", analyseCharacters.calculateFrequency(text, countsLetters,
            countsNumbers, countsSymbols, countsCRFreq, cChart, characterMap))
        analyser_chars_frequency_button.setOnClickListener {
            startActivity(charFrequencyIntent)
        }
    }
}
