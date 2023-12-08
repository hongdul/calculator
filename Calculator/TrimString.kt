package Calculator

class TrimString {
    fun trim(exp : String) : String {
        var trimmedStr = ""
        for(i in 0..exp.length - 1) {
            if (!exp[i].isWhitespace()) {
                trimmedStr += exp[i]
            }
        }
        return trimmedStr
    }
}