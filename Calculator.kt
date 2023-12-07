import kotlin.system.exitProcess

class Calculator {
    fun calc() {
        var exp = Prompt().prompt()                    // 연산식 입력받기
        val trimexp = TrimString()                  // 공백 지우는 클래스 객체 생성
        exp = trimexp.trim(exp)                     // 공백 지우기
        val check = CheckOperatorAndIndex()
        val operator = check.checkOperator(exp)
        val expDivider = ExpDivider()
        val result = expDivider.calculateExp(operator, exp)
        println("result : $result")
        println()
    }
}

class Prompt {
    fun prompt() : String {
        println("Please input arithmetic expression (1+2, 5 * 8, ...)")
        println("If you want to exit, input 0")
        val line = readln()
        when(line) {
            '0'.toString() -> exitProcess(0)
        }
        return line
    }
}

class ExpDivider {
    fun calculateExp(operator: Pair<Operator, Int>, exp: String) : Any {
        val num1 = exp.substring(0, operator.second).toInt()
        val num2 = exp.substring(operator.second + 1).toInt()
        val result = when(operator.first) {
            Operator.Plus -> Operator.Plus.operate(num1, num2)
            Operator.Minus  -> Operator.Minus.operate(num1, num2)
            Operator.Times  -> Operator.Times.operate(num1, num2)
            Operator.Division  -> Operator.Division.operate(num1, num2)
            else -> Operator.Mod.operate(num1, num2)
        }
        return result
    }

}
enum class Operator {
    Plus {
        override fun operate(num1: Int, num2: Int): Int { return num1 + num2 }
    },
    Minus{
        override fun operate(num1 : Int, num2 : Int) : Int { return num1 - num2 }
    },
    Times{
        override fun operate(num1 : Int, num2 : Int) : Int { return num1 * num2 }
    },
    Division{
        override fun operate(num1 : Int, num2 : Int) : String {
            if(num2 == 0) {
                println("divider can't be 0!")
                val c = Calculator()
                c.calc()
            }
            val returnStr = num1.toDouble() / num2.toDouble()
            return String.format("%.1f", returnStr)
        }
    },
    Mod{
        override fun operate(num1 : Int, num2 : Int) : Int {
            return num1 % num2
        }
    };
    abstract fun operate(num1: Int, num2 : Int) : Any
}
class CheckOperatorAndIndex{
    fun checkOperator(exp : String) : Pair<Operator, Int> {
        if(exp.contains('+')) {
            return Pair(Operator.Plus, exp.indexOf('+'))
        }
        if(exp.contains('-')) {
            return Pair(Operator.Minus, exp.indexOf('-'))
        }
        if(exp.contains('*')) {
            return Pair(Operator.Times, exp.indexOf('*'))
        }
        if(exp.contains('/')) {
            return Pair(Operator.Division, exp.indexOf('/'))
        }
        if(exp.contains('%')) {
            return Pair(Operator.Mod, exp.indexOf('%'))
        }
        else {
            println("Invalid expression")
            exitProcess(3)
        }
    }
}
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
fun main() {
    while(true) {
        val c = Calculator()
        c.calc()
    }
}
