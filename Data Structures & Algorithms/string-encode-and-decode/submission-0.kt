class Solution {

    fun encode(strs: List<String>): String {
        var res = "" 
        for(s in strs) {
            res += "${s.length}#$s"
        }

        return res
    }

    fun decode(str: String): List<String> {
        val res = mutableListOf<String>()

        var num = 0
        var i = 0
        while(i < str.length) {
            if(str[i].isDigit()) {
                val newNum = str[i] - '0'
                num = num * 10 + newNum
            } else if(str[i] == '#') {
                val start = i + 1
                val end = start + num
                res.add(str.substring(start, end))
                num = 0
                i = end - 1
            } 
            i++
        }

        return res
    }
}
