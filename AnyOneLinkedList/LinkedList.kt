class LinkedList<T> {
    var head: Node<T>? = null
//    var tail: Node<T>? = null

    fun push(x: T) {
        val node = Node(x)
        node.next = head
        head = node
    }

    fun pop(): T? {
        val value = head?.value
        head = head?.next
        return value
    }

    /*
     Задача 1. Реализовать метод добавления элемента в хвост связного списка
     Задача 2. Сделать из односвязаного списка двусвязный
     и реализовать удаление хвоста списка.
     */
}