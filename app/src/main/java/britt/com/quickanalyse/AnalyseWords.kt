package britt.com.quickanalyse

class AnalyseWords {
    val analyseCharacters = AnalyseCharacters()

    var wordMap: MutableMap<Int, Int> = mutableMapOf()

    fun textToList(text: String): List<String> {
        return text.split(" ")
    }

    fun countWords(text: String): Int {
        return textToList(text).size
    }

    fun findLongestWord(words: List<String>) {
        var longestWord = ""
        words
            .asSequence()
            .filter { it.length >= longestWord.length }
            .forEach { longestWord = it }
    }

    fun addToList(wordLength: Int) {
        val character = wordMap[wordLength]

        if (character == null) {
            wordMap.put(wordLength, 1)
        } else {
            val newCount = character + 1
            wordMap.put(wordLength, newCount)
        }
    }

    fun countLengths(text: String, countsWRFreq: Boolean, wChart: Boolean) {
        val array = textToList(text)
        val total: Double = countWords(text).toDouble()
        var relFreq: Double
        for (i in 0..array.size - 1) {
            addToList(array[i].length)
        }
        val iterator = wordMap.keys.iterator()
        println("Word length frequency")
        println("---------------------")
        while (iterator.hasNext()) {
            val key = iterator.next()
            val value = wordMap[key]
            relFreq = value?.div(total) as Double
            relFreq = Math.round(relFreq * 10000) / 100.0
            if (countsWRFreq and wChart) {

                if (relFreq >= 10 && relFreq.toString().length >= 5) {
                    print("$key=$value | $relFreq% | ")
                    analyseCharacters.makeBarChart(relFreq)
                } else if (relFreq.toString().length <= 3) {
                    print("$key=$value | $relFreq%   | ")
                    analyseCharacters.makeBarChart(relFreq)
                } else {
                    print("$key=$value | $relFreq%  | ")
                    analyseCharacters.makeBarChart(relFreq)
                }
            } else if (countsWRFreq) {
                println("$key=$value | $relFreq%")
            } else {
                println("$key=$value")
            }
        }
    }
}