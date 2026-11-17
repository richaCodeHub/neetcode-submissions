class Solution {
    fun maxArea(heights: IntArray): Int {
        var res = 0

        var start = 0
        var end = heights.size - 1

        while(start < end) {
            res = maxOf(res, (end - start) * minOf(heights[start], heights[end]))

            if(heights[start] < heights[end]) start++
            else end--
        }

        return res
    }
}
