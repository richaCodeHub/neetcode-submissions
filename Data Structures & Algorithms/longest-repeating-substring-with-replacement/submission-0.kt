class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        var res = 0
        var maxFreq = 0
        var left = 0 
        var right = 0
        val map = HashMap<Char, Int>()

        while(right < s.length) {
            map[s[right]] = (map[s[right]] ?: 0) + 1

            maxFreq = maxOf(maxFreq, map[s[right]]?:0)

            val temp = right - left + 1

            if(temp - maxFreq > k) {
                map[s[left]] = map[s[left]]!! - 1
                left++
            } 

            res = maxOf(res, right - left + 1)

            right++
        }

        return res
    }
}
