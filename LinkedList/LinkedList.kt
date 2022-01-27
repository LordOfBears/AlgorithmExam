class LinkedList<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    override fun toString(): String = if (head == null) "empty list" else head.toString()

    /** Добавление элемента в голову связного списка. */
    fun push(value: T) {
        val node = Node(value)
        node.next = head
        head?.prev = node
        head = node
        if (tail == null) {
            tail = node
        }
    }

    /** Удаление элемента из головы связного списка. */
    fun pop(): T? {
        val value = head?.value
        head = head?.next
        head?.prev = null
        if (head == null) {
            tail = null
        }
        return value
    }

    fun enqueue(value: T) {
        if (tail == null) {
            push(value)
        } else {
            val node = Node(value)
            tail?.next = node
            node.prev = tail
            tail = node
        }
    }

    fun removeLast(): T? {
        val value = tail?.value
        tail = tail?.prev
        tail?.next = null
        if (tail == null) {
            head = null
        }
        return value
    }

    fun dequeue(): T? = pop()

    fun peek(): T? {
        val value = head?.value
        return value
    }

    val isEmpty: Boolean get() = peek() == null

    fun isEmpty1(): Boolean {
        return peek() == null
    }

    val isNotEmpty: Boolean get() = !isEmpty
}