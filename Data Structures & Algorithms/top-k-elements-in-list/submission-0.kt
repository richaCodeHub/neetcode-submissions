class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val map = HashMap<Int, Int>()
        for(n in nums) {
            map[n] = map.getOrDefault(n, 0) + 1
        }

        return map.entries
            .sortedByDescending { it.value }
            .take(k)
            .map{ it.key }
            .toIntArray()
    }
}
