package britt.com.quickanalyse

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
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

    var characterMap: MutableMap<String, Int> = mutableMapOf()

    val analyseCharacters = AnalyseCharacters()
    val analyseWords = AnalyseWords()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_input)
        goToAnalysisResultOnClick()
    }

    fun goToAnalysisResultOnClick() {
        val intent = Intent(this@TextInputActivity, AnalysisResultActivity().javaClass)
        analyser_text_analyse_button.setOnClickListener {
            setCheckedBoxes()
            setUncheckedBoxes()
            setSpinnerChoices()
            var text = getUserText()
            intent.putExtra("results", runMethods(text))
            text = ""
            startActivity(intent)
        }
    }

    fun runMethods(text: String): String {
        var letterFrequency = "N/A"
        var numberFrequency = "N/A"
        var symbolFrequency = "N/A"
        var countWords = "N/A"

        if (countsLetters) {
            letterFrequency = analyseCharacters.letterFrequency(text).toString()
        }
        if (countsNumbers) {
            numberFrequency = analyseCharacters.numberFrequency(text).toString()
        }
        if (countsSymbols) {
            symbolFrequency = analyseCharacters.symbolFrequency(text).toString()
        }
        if (countsCFreq) {
            analyseCharacters.calculateFrequency(text, countsLetters, countsNumbers, countsSymbols, countsCFreq,
                cChart, characterMap)
        }
        if (countsWords) {
            countWords = analyseWords.countWords(text).toString()
        }
        if (countsLongestWord) {
            analyseWords.findLongestWord(analyseWords.textToList(text))
        }
        if (countsWLengthFreq) {
            analyseWords.countLengths(text, countsWLengthRFreq, wChart)
        }

        return "Total letters - $letterFrequency\n\nTotal numbers - $numberFrequency\n\n" +
            "Total special characters - $symbolFrequency\n\nTotal words - $countWords"
    }


    fun getUserText(): String {
        val text = analyser_user_input.editableText
        return text.toString()
    }


    fun makeTextToSendToAnalysisResult(): String {
        val output = "It's $countsLetters that letters are counted.\n" +
            "It's $countsNumbers that numbers are counted.\n" +
            "It's $countsSymbols that symbols are counted.\n" +
            "It's $countsCFreq that character frequency is counted.\n" +
            "It's $countsCRFreq that character r.frequency is counted.\n" +
            "It's $cChart that there's a character chart.\n" +
            "It's $countsWords that words are counted.\n" +
            "It's $countsLongestWord that the longest word is found.\n" +
            "It's $countsWLengthFreq that word frequency is counted.\n" +
            "It's $countsWLengthRFreq that word r.frequency is counted.\n" +
            "It's $wChart that there's a word chart.\n"
        return output
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
