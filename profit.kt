/**
 * Finds the best days to buy and sell stocks to maximize profit, given an array of stock prices.
 * Returns the maximum profit that can be made. If no profit can be made, returns -1.
 *
 * @param prices The array of stock prices.
 * @return The maximum profit that can be made.
 */
fun findMaxProfit(prices: IntArray): Int {
    if (prices.size < 2) {
        return -1
    }

    var buyDay = 0
    var sellDay = 0
    var maxProfit = 0

    for (i in 1 until prices.size) {
        if (prices[i] < prices[buyDay]) {
            buyDay = i
            sellDay = i
        } else if (prices[i] > prices[sellDay]) {
            sellDay = i
        }

        if (prices[sellDay] - prices[buyDay] > maxProfit) {
            maxProfit = prices[sellDay] - prices[buyDay]
        }
    }

    if (maxProfit == 0) {
        return -1
    }

    println("Buy on day ${buyDay + 1} at price ${prices[buyDay]}")
    println("Sell on day ${sellDay + 1} at price ${prices[sellDay]}")
    println("Max profit: $maxProfit")
    return maxProfit
}

import org.junit.Test
import kotlin.test.assertEquals

class StockProfitTest {
    @Test
    fun testFindMaxProfit() {
        assertEquals(655, findMaxProfit(intArrayOf(100, 180, 260, 310, 40, 535, 695)))
        assertEquals(-1, findMaxProfit(intArrayOf(100, 90, 80, 70, 60, 50)))
        assertEquals(400, findMaxProfit(intArrayOf(100, 200, 300, 400, 500)))
        assertEquals(-1, findMaxProfit(intArrayOf(500, 400, 300, 200, 100)))
        assertEquals(200, findMaxProfit(intArrayOf(100, 200, 300, 200, 100)))
    }
}
