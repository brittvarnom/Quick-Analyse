package britt.com.quickanalyse

class AnalyseCharacters {

    fun letterFrequency(text: String): Int {
        var upperCount = 0
        var lowerCount = 0
        var totalCount = 0

        for (i in 0..text.length - 1) {
            if ((text[i].toInt() >= 65) and (text[i].toInt() <= 90)) {
                upperCount++
            }
            if ((text[i].toInt() >= 97) and (text[i].toInt() <= 122)) {
                lowerCount++
            }
            totalCount = upperCount + lowerCount
        }
        return totalCount
    }

    fun numberFrequency(text: String): Int {
        var numberCount = 0

        for (i in 0..text.length - 1) {
            if ((text[i].toInt() >= 48) and (text[i].toInt() <= 57)) {
                numberCount++
            }
        }
        return numberCount
    }

    fun symbolFrequency(text: String): Int {
        var symbolCount = 0
        var isSymbol: Boolean

        for (i in 0..text.length - 1) {
            if (((text[i].toInt()) >= 65) and ((text[i].toInt()) <= 90)) {
                isSymbol = false
            } else if (((text[i].toInt()) >= 97) and ((text[i].toInt()) <= 122)) {
                isSymbol = false
            } else if (((text[i].toInt()) >= 48) and ((text[i].toInt()) <= 57)) {
                isSymbol = false
            } else if (text[i] == '\n') {
                isSymbol = false
            } else isSymbol = text[i].toInt() != 32
            if (isSymbol) {
                symbolCount++
            }
        }
        return symbolCount
    }

    fun countFrequency(mapKey: String, characterMap: MutableMap<String, Int>) {
        val character = characterMap[mapKey]

        if (character == null) {
            characterMap.put(mapKey, 1)
        } else {
            val newCount = character + 1
            characterMap.put(mapKey, newCount)
        }
    }

    fun characterFrequency(text: String, countsLetters: Boolean, countsNumbers: Boolean,
                           countsSymbols: Boolean, characterMap: MutableMap<String, Int>) {
        for (i in 0..text.length - 1) {
            var isSymbol = true
            if (countsLetters) {
                if ((text[i].toInt() >= 65) and (text[i].toInt() <= 90) or
                    ((text[i].toInt() >= 97) and (text[i].toInt() <= 122))) {
                    countFrequency(text[i].toString(), characterMap)
                    isSymbol = false
                }
            }
            if (countsNumbers) {
                if ((text[i].toInt() >= 48) and (text[i].toInt() <= 57)) {
                    countFrequency(text[i].toString(), characterMap)
                    isSymbol = false
                }
            }
            if ((text[i] == ' ')) {
                isSymbol = false
            }
            if (countsSymbols) {
                if (isSymbol) {
                    countFrequency(text[i].toString(), characterMap)
                }
            }
        }
    }

    fun calculateFrequency(text: String, countsLetters: Boolean, countsNumbers: Boolean,
                           countsSymbols: Boolean, countsCRFreq: Boolean, cChart: Boolean,
                           characterMap: MutableMap<String, Int>) {
        characterFrequency(text, countsLetters, countsNumbers, countsSymbols, characterMap)
        val iterator = characterMap.keys.iterator()
        var relFreq = 0.0
        val total: Double = getTotal(characterMap)

        if (countsCRFreq) {
            println("Note - Relative frequency is only an approximation and may total up to be just" +
                " over 100%.\n")
        }

        while (iterator.hasNext()) {
            val key = iterator.next()
            val value = characterMap[key]
            relFreq = value?.div(total) as Double
            relFreq = Math.round(relFreq * 10000) / 100.0
            if (countsCRFreq and cChart) {

                if (relFreq >= 10 && relFreq.toString().length >= 5) {
                    print("$key=$value | $relFreq% | ")
                    makeBarChart(relFreq)
                } else if (relFreq.toString().length <= 3) {
                    print("$key=$value | $relFreq%   | ")
                    makeBarChart(relFreq)
                } else {
                    print("$key=$value | $relFreq%  | ")
                    makeBarChart(relFreq)
                }
            } else if (countsCRFreq) {
                println("$key=$value | $relFreq%")
            } else {
                println("$key=$value")
            }

        }
        characterMap.clear()

    }

    fun getTotal(characterMap: MutableMap<String, Int>): Double {
        val iterator = characterMap.keys.iterator()
        var total = 0.0
        while (iterator.hasNext()) {
            val key = iterator.next()
            val value = characterMap[key] as Int
            total += value
        }
        return total
    }

    fun makeBarChart(relFreq: Double) {
        val bar = "X"
        val repeats = (relFreq + 0.5).toInt()
        repeat(repeats) {
            print(bar)
        }
        println()
    }
}