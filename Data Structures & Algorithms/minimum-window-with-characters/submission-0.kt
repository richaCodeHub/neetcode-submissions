class Solution {
    fun minWindow(s: String, t: String): String {
        val tMap = HashMap<Char, Int>()

        for(ch in t) {
            tMap[ch] = (tMap[ch] ?: 0) + 1
        }

        val sMap = HashMap<Char, Int>()
        var left = 0
        var right = 0
        var found = 0
        val target = tMap.size
        var res = ""

        while(right < s.length) {
            val chRight = s[right]
            sMap[chRight] = (sMap[chRight] ?: 0) + 1

            if((tMap[chRight] ?: 0) == sMap[chRight]) {
                found++
            }

            while(found == target) {
                if(res.isEmpty() || res.length > (right - left + 1)) {
                    res = s.substring(left, right + 1)
                }

                val chLeft = s[left]
                if(sMap[chLeft] == (tMap[chLeft] ?: 0)) {
                    found--
                }
                sMap[chLeft] = sMap[chLeft]!! - 1
                left++
            }

            right++
        }

        return res
    }
}
