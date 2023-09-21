import org.junit.Test
import kotlin.test.assertEquals

class CharacterFrequencySorterTest {
    @Test
    fun testSortStringByCharacterFrequency() {
        assertEquals("llloohe wrd", sortStringByCharacterFrequency("hello world"))
        assertEquals("eetr", sortStringByCharacterFrequency("tree"))
        assertEquals("aaabbbccc", sortStringByCharacterFrequency("abcabcabc"))
        assertEquals("aabbcc", sortStringByCharacterFrequency("aabbcc"))
        assertEquals("dddeeefff", sortStringByCharacterFrequency("defdefdef"))
    }
}
