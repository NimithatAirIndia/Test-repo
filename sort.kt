fun sortStringByCharacterFrequency(input: String): String {
    // Create a map to store the frequency of each character
    val frequencyMap = input.groupingBy { it }.eachCount()

    // Create a list of map entries and sort it by frequency in descending order
    val entryList = frequencyMap.entries.sortedByDescending { it.value }

    // Build the output string by appending each character the number of times it appears in the input string
    val outputBuilder = StringBuilder()
    for (entry in entryList) {
        val c = entry.key
        val frequency = entry.value
        repeat(frequency) {
            outputBuilder.append(c)
        }
    }

    return outputBuilder.toString()
}
