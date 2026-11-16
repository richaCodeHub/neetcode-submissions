class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val prefixArr = IntArray(nums.size)
        prefixArr[0] = 1

        for(i in 1 until nums.size) {
            prefixArr[i] = prefixArr[i - 1] * nums[i - 1]
        }

        val suffixArr = IntArray(nums.size)
        suffixArr[nums.size - 1] = 1

        for(i in nums.size - 2 downTo 0) {
            suffixArr[i] = suffixArr[i + 1] * nums[i + 1]
        }

        val res = IntArray(nums.size)
        
        for(i in 0 until nums.size) {
            res[i] = prefixArr[i] * suffixArr[i]
        }

        return res
    }
}
