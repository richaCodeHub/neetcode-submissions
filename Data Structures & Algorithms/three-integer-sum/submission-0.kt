class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()

        val res = mutableListOf<List<Int>>()
        for(i in 0 until nums.size - 2) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            if(nums[i] > 0) break;

            var left = i + 1
            var right = nums.size - 1
            var target = -nums[i]

            while(left < right) {
                val sum = nums[left] + nums[right]

                when {
                    sum < target -> left++
                    sum > target -> right--
                    else -> {
                        res.add(listOf(nums[left++], nums[right--], nums[i]))

                        while(left < right && nums[left] == nums[left - 1]) left++
                        while(left < right && nums[right] == nums[right + 1]) right--
                    }
                }
            }
        }

        return res
    }
}
