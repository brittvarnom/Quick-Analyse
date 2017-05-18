package britt.com.quickanalyse

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_text_input.*

class TextInputActivity : AppCompatActivity() {

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_input)
        onAnalyseTextButtonClick()
    }

    fun onAnalyseTextButtonClick() {
        analyser_text_analyse_button.setOnClickListener {
            setCheckedBoxes()
            setUncheckedBoxes()
            setSpinnerChoices()
            Toast.makeText(this, "It's $countsLetters that letters are counted.", Toast.LENGTH_SHORT).show()
            Toast.makeText(this, "It's $countsNumbers that numbers are counted.", Toast.LENGTH_SHORT).show()
            Toast.makeText(this, "It's $countsSymbols that symbols are counted.", Toast.LENGTH_SHORT).show()
            Toast.makeText(this, "It's $countsCFreq that character frequency is counted.", Toast.LENGTH_SHORT).show()
            Toast.makeText(this, "It's $countsCRFreq that character r.frequency is counted.", Toast.LENGTH_SHORT).show()
            Toast.makeText(this, "It's $cChart that there's a character chart.", Toast.LENGTH_SHORT).show()
            Toast.makeText(this, "It's $countsWords that words are counted.", Toast.LENGTH_SHORT).show()
            Toast.makeText(this, "It's $countsLongestWord that the longest word is found.", Toast.LENGTH_SHORT).show()
            Toast.makeText(this, "It's $countsWLengthFreq that word frequency is counted.", Toast.LENGTH_SHORT).show()
            Toast.makeText(this, "It's $countsWLengthRFreq that word r.frequency is counted.", Toast.LENGTH_SHORT).show()
            Toast.makeText(this, "It's $wChart that there's a word chart.", Toast.LENGTH_SHORT).show()
        }
    }

    fun setCheckedBoxes() {
        if (analyser_chars_alpha_check.isChecked) {
            countsLetters = true
        }
        if (analyser_chars_num_check.isChecked) {
            countsNumbers = true
        }
        if (analyser_chars_sym_check.isChecked) {
            countsSymbols = true
        }
        if (analyser_words_count_check.isChecked) {
            countsWords = true
        }
        if (analyser_words_longest_check.isChecked) {
            countsLongestWord = true
        }
    }

    fun setUncheckedBoxes() {
        if (!analyser_chars_alpha_check.isChecked) {
            countsLetters = false
        }
        if (!analyser_chars_num_check.isChecked) {
            countsNumbers = false
        }
        if (!analyser_chars_sym_check.isChecked) {
            countsSymbols = false
        }
        if (!analyser_words_count_check.isChecked) {
            countsWords = false
        }
        if (!analyser_words_longest_check.isChecked) {
            countsLongestWord = false
        }
    }

    fun setSpinnerChoices() {
        //CHARACTERS
        if (analyser_chars_freq_spin.selectedItem.toString() == "Frequency") {
            countsCFreq = true
            countsCRFreq = false
            cChart = false
        } else if (analyser_chars_freq_spin.selectedItem.toString() == "+ Relative Frequency") {
            countsCFreq = true
            countsCRFreq = true
            cChart = false
        } else if (analyser_chars_freq_spin.selectedItem.toString() == "+ Bar Chart") {
            countsCFreq = true
            countsCRFreq = true
            cChart = true
        } else {
            countsCFreq = false
            countsCRFreq = false
            cChart = false
        }
        //WORDS
        if (analyser_words_freq_spin.selectedItem.toString() == "Frequency") {
            countsWLengthFreq = true
            countsWLengthRFreq = false
            wChart = false
        } else if (analyser_words_freq_spin.selectedItem.toString() == "+ Relative Frequency") {
            countsWLengthFreq = true
            countsWLengthRFreq = true
            wChart = false
        } else if (analyser_words_freq_spin.selectedItem.toString() == "+ Bar Chart") {
            countsWLengthFreq = true
            countsWLengthRFreq = true
            wChart = true
        } else {
            countsWLengthFreq = false
            countsWLengthRFreq = false
            wChart = false
        }
    }
}
