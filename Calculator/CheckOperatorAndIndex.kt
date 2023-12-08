package Calculator

import kotlin.system.exitProcess

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