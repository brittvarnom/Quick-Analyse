package britt.com.quickanalyse

class GetExtraInfo() {

    val analyseCharacters = AnalyseCharacters()

    fun getFrequencyType(type: String): String {
        return type
    }

    fun getMap(): MutableMap<String, Int> {
        return analyseCharacters.getMap()
    }

}