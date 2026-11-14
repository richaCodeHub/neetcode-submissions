class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = HashMap<String, MutableList<String>>()

        for(s in strs) {
            val arr = IntArray(26)
            for(char in s.toCharArray()) {
                arr[char - 'a']++
            }

            val key = arr.joinToString("#")
            map.getOrPut(key) { mutableListOf() }.add(s)
        }

        return map.values.toList()
    }
}
