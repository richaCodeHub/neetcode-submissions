class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var res = 0
        var left = 0
        var right = 0
        val set = HashSet<Char>()

        while(right < s.length) {
            if(set.contains(s[right])) {
                set.remove(s[left])
                left++
            } else {
                set.add(s[right])
                res = maxOf(res, right - left + 1)
                right++
            }
        }

        return res
    }
}
