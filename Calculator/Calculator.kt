package Calculator


class Calculator {
    fun calc() {
        var exp = Prompt().prompt()
        exp = TrimString().trim(exp)
        val operator = CheckOperatorAndIndex().checkOperator(exp)
        val result = ExpDivider().calculateExp(operator, exp)
        Prompt().printResult(result)
    }
}
fun main() {
    while (true) {
        val c = Calculator()
        c.calc()
    }
}
