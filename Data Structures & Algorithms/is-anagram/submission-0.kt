class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        val sArr = IntArray(26) { 0 }
        val tArr = IntArray(26) { 0 }

        for(char in s) sArr[char - 'a']++
        for(char in t) tArr[char - 'a']++

        for(i in 0 until 26)
            if(sArr[i] != tArr[i]) return false
            
        return true
    }
}
