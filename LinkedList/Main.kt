import kotlin.math.abs
import kotlin.math.sin

fun main() {
    val list = LinkedList<Int>()
    for (x in 1..10) {
        list.enqueue(x)
    }
    println(list)
    var i = 0
    while (list.isNotEmpty && i < 20) {
        val x = list.removeLast()
        println("Удален $x, список: $list")
        i++
    }
}


/*
   ЦПИ-11_2

   Связный список Linked
   1 -> 2 -> 3
   println(node2) 2 -> 3
   println(node3) 3

   Задача. Создать связный список со значениями
   1 -> 2 -> 3 -> ... -> 50
*/

fun main10() {
    var head: Node<Int>? = null
    for (i in 50 downTo 1) {
        val node = Node(i)
        node.next = head
        head = node
    }
    print(head)
}

/*
   Алгоритм преобразования инфиксного выражения в постфиксное

   x * sin (y) + z

   4 * (2 + 3) / 3 + 5 - инфиксное выражение
   [+] - стек хранит операции и скобки
   4 2 3 + * 3 / 5 +

   Задача. Реализовать преобразование инфиксного выражения в постфиксное (+, -, /, *, sin)
   val list = listOf("4", "*", "(", "2", "+", "3", ")", ...)
*/


/*
  4 2 3 + * 3 / 5 +
  [4, 2, 3]
  [4]
  2 + 3
  [4, 5]
  []
  4 * 5
  [20, 3]
  []
  20 / 3
  [6.66, 5]
  []
  6.66 + 5
  [11.66]
 */

fun main12() {
    val list = listOf("&&", "||", "->", "<->")
    for (s in list) {
        when (s) {
            "&&", "<->" -> {

            }
            "||" -> {

            }
            "->" -> {

            }
            else -> {

            }
        }
    }
}

fun sum(x: Float, y: Float = 0f): Float = x + y

fun sum(x: Int, y: Int): Int = x + y

/*
 1 * (2 + 3) - инфиксное выражение
 Постфиксное выражение (postfix):
 1 2 3 + *
 Вычисление постфиксного выражения на стеке
 [5]



 */

fun main3() {
//    val xs = listOf("asa", "asda", "asa")
//    for (x in xs) {
//        println("Строка $x")
//    }


//    val text = "4 2 3 - * 3 / 5 + "

//    val stack = mutableListOf<Float>()
//    stack.add(1.1f)  // push
//    stack.removeLast() // pop
//    stack.last() // peek
//    "4".toFloat()

//    val list = listOf("x","y", "z", "-", "*", "z", "/", "t", "+")
//    val result = calcPostfix(list)
//    println("Ответ: $result")
}

fun calcPostfix(expr: List<String>, x: Float, y: Float): Float {
    val stack = mutableListOf<Float>()
    for (s in expr) {
        when (s) {
            "+" -> {
                val y = stack.removeLast()
                val x = stack.removeLast()
                stack.add(x + y)
            }
            "*" -> {
                val y = stack.removeLast()
                val x = stack.removeLast()
                stack.add(x * y)
            }
            "-" -> {
                val y = stack.removeLast()
                val x = stack.removeLast()
                stack.add(x - y)
            }
            "/" -> {
                val y = stack.removeLast()
                val x = stack.removeLast()
                stack.add(x / y)
            }
            "sin" -> {
                val x = stack.removeLast()
                stack.add(sin(x))
            }
            "x" -> {
                stack.add(x)
            }
            "y" -> {
                stack.add(y)
            }
            else -> {
                stack.add(s.toFloat())
            }
        }
        println(stack)
    }
    return stack.last()
}


fun main1() {
    println("Queens")
    val n = 8
    val board = mutableListOf<Int>()
    var isExpandable = true
    var solution = 1
    while (board.isNotEmpty() || isExpandable) {
        if (board.size == n) {
            println("Решение $solution: $board")
            solution++
        }
        var isExpandSuccess = false
        if (isExpandable) {
            for (x0 in 0 until n) {
                if (isValid(x0, board)) {
                    board.add(x0)
                    isExpandSuccess = true
                    isExpandable = true
                    break
                }
            }
        }
        if (!isExpandSuccess) {
            var isChangeSuccess = false
            val last = board.removeLastOrNull() ?: -1
            for (x0 in (last + 1) until n) {
                if (isValid(x0, board)) {
                    board.add(x0)
                    isChangeSuccess = true
                    isExpandable = true
                    break
                }
            }
            if (!isChangeSuccess) {
                isExpandable = false
            }
        }
    }
}

fun isValid(x0: Int, board: List<Int>): Boolean {
    val i0 = board.size
    for ((i, x) in board.withIndex()) {
        if (x == x0 || abs(i - i0) == abs(x - x0)) {
            return false
        }
    }
    return true
}