/**
 * Sorts the given array of numbers in ascending order.
 *
 * @param array The array of numbers to sort.
 * @return The sorted array.
 */
fun sortArray(array: IntArray): IntArray {
    array.sort()
    return array
}

import org.junit.Test
import kotlin.test.assertContentEquals

class ArraySorterTest {
    @Test
    fun testSortArray() {
        assertContentEquals(intArrayOf(40, 100, 180, 260, 310, 535, 695), sortArray(intArrayOf(100, 180, 260, 310, 40, 535, 695)))
        assertContentEquals(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), sortArray(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)))
        assertContentEquals(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), sortArray(intArrayOf(10, 9, 8, 7, 6, 5, 4, 3, 2, 1)))
        assertContentEquals(intArrayOf(1, 2, 3, 4, 5), sortArray(intArrayOf(5, 4, 3, 2, 1)))
        assertContentEquals(intArrayOf(1), sortArray(intArrayOf(1)))
    }
}

/**
 * Sorts the given array of numbers in ascending order using the quicksort algorithm.
 *
 * @param array The array of numbers to sort.
 * @return The sorted array.
 */
fun quicksort(array: IntArray): IntArray {
    if (array.size < 2) {
        return array
    }

    val pivot = array[array.size / 2]
    val less = array.filter { it < pivot }.toIntArray()
    val equal = array.filter { it == pivot }.toIntArray()
    val greater = array.filter { it > pivot }.toIntArray()

    return quicksort(less) + equal + quicksort(greater)
}

/**
 * Sorts the given array of numbers in ascending order using quicksort.
 * Uses insertion sort for small arrays to improve performance.
 *
 * @param array The array of numbers to sort.
 * @return The sorted array.
 */
fun sortArray(array: IntArray): IntArray {
    if (array.size < 10) {
        return array.sorted().toIntArray()
    }

    return quicksort(array)
}

import kotlin.system.measureTimeMillis

class ArraySorterPerformanceTest {
    @Test
    fun testSortArrayPerformance() {
        val array = IntArray(50000) { it }
        val time = measureTimeMillis {
            sortArray(array)
        }
        println("Sorted 50000 elements in $time ms")
    }
}
