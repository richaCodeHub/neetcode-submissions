class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val res = IntArray(nums.size)
        res[0] = 1

        for(i in 1 until nums.size) {
            res[i] = res[i - 1] * nums[i - 1]
        }

        var suffix = 1

        for(i in nums.size - 1 downTo 0) {
            res[i] *= suffix
            suffix *= nums[i]
        }

        return res
    }
}
