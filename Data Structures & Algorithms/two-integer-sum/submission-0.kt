class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>()

        for(i in 0 until nums.size) {
            val req = target - nums[i]

            if(map.contains(req)) {
                return intArrayOf(map[req]!!, i)
            }

            map[nums[i]] = i
        }

        return IntArray(2)
    }
}
