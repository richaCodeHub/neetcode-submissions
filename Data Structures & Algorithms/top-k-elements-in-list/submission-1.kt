class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val map = HashMap<Int, Int>()
        for(n in nums) {
            map[n] = map.getOrDefault(n, 0) + 1
        }

        val buckets = Array(nums.size + 1) {
            mutableListOf<Int>()
        }

        for((num, freq) in map) {
            buckets[freq].add(num)
        }

        val res = mutableListOf<Int>()
        for(i in buckets.size - 1 downTo 1) {
            for(num in buckets[i]) {
                res.add(num)
                if(res.size == k) {
                    return res.toIntArray()
                }
            }
        }

        return res.toIntArray()
    }
}
