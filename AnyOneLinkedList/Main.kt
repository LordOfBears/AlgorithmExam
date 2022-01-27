fun main() {
    /*
    1 -> 2 -> 3 -> null
    */
//    val (name, _) = bestStudent()
//    println("студент $name")

    val node1 = Node("first")
    // тип node это Node<String>
    val node2 = Node("second")
    val node3 = Node("third")

    node1.next = node2
    node2.next = node3

    println(node1)

//    // Задача: создать связный список вида 1 -> 2 -> 3 -> ... -> 100.
//    var head: Node<Int>? = null
//    for (i in 100 downTo 1) {
//        val node = Node(i+1)
//        node.next = head
//        head = node
//    }

    val linkedList = LinkedList<Int>()

}

fun <T> selectRandom(a: T, b: T): T {
    return a
}

fun bestStudent(): Student {
    val student = Student("Ivan Ivanov", 20)
    return Student("Ivan Ivanov", 20)
}

data class Student(
    var name: String,
    var age: Int
)




//fun main1() {
//    val exp = "-123.01 8 + 32.1 * -5 + -1.2 * 312.0001 dgh. - 1.1 / sin"
//    val pattern = "-?(\\d+\\.)?\\d+|\\+|-|\\*|\\/|sin".toRegex()
//    val list = pattern.findAll(exp)
//    println(list.map { it.value }.joinToString(", "))
//}









fun main1() {
//    val s = "((()()()()))"
//    val result = isValid(s)
//    println("Verify $s: result = $result")
    val exp = "a|| !c || ( b &&!c) || !d&&e <-> a && b -> c"
    val pattern = "a|b|c|d|e|&&|\\|\\||\\(|\\)|!|->|<->".toRegex()
    val list = pattern.findAll(exp)
    list.forEach {
        print("${it.value}, ")
    }
}



fun isValid(s: String): Boolean {
    var b = 0
    for (c in s) {
        when (c) {
            '(' -> b++
            ')' -> b--
            else -> return false
        }
        if (b < 0) {
            return false
        }
    }
    return b == 0
}