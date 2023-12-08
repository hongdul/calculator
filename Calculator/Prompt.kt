package Calculator

import kotlin.system.exitProcess
class Prompt {
    fun prompt() : String {
        println("Please input arithmetic expression (1+2, 5 * 8, ...)")
        println("If you want to exit, input 0")
        println()
        val line = readln()
        when(line) {
            '0'.toString() -> exitProcess(0)
        }
        return line
    }
    fun printResult(result: Any) {
        println("result : $result")
        println()
    }
}