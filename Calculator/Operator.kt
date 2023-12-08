package Calculator

enum class Operator {
    Plus {
        override fun operate(num1: Int, num2: Int): Int {
            return num1 + num2
        }
    },
    Minus {
        override fun operate(num1: Int, num2: Int): Int {
            return num1 - num2
        }
    },
    Times {
        override fun operate(num1: Int, num2: Int): Int {
            return num1 * num2
        }
    },
    Division {
        override fun operate(num1: Int, num2: Int): String {
            if (num2 == 0) {
                println("divider can't be 0!")
                val c = Calculator()
                c.calc()
            }
            val returnStr = num1.toDouble() / num2.toDouble()
            return String.format("%.1f", returnStr)
        }
    },
    Mod {
        override fun operate(num1: Int, num2: Int): Int {
            return num1 % num2
        }
    };

    abstract fun operate(num1: Int, num2: Int): Any
}