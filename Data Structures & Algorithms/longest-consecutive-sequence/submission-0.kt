class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val set = HashSet<Int>()

        for(n in nums) {
            set.add(n)
        }

        var res = 0

        for(value in set) {
            if(!set.contains(value - 1)) {
                var temp = 1
                var i = value
                while(set.contains(i + 1)) {
                    temp++
                    i++
                }
                res = Math.max(res, temp)
            }
        }

        return res
    }
}
