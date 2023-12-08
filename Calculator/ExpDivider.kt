package Calculator
class ExpDivider {
    fun calculateExp(operator: Pair<Operator, Int>, exp: String) : Any {
        val num1 = exp.substring(0, operator.second).toInt()
        val num2 = exp.substring(operator.second + 1).toInt()
        val result = when(operator.first) {
            Operator.Plus -> Operator.Plus.operate(num1, num2)
            Operator.Minus -> Operator.Minus.operate(num1, num2)
            Operator.Times -> Operator.Times.operate(num1, num2)
            Operator.Division -> Operator.Division.operate(num1, num2)
            else -> Operator.Mod.operate(num1, num2)
        }
        return result
    }
}