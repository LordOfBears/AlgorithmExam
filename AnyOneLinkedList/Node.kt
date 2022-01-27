data class Node<T>(
    var value: T,
    var next: Node<T>? = null,
    var prev: Node<T>? = null
) {
    // 1 -> 2, 3, ..., 100
    override fun toString(): String {
        return if (next != null) {
            "$value -> ${next.toString()}"
        } else {
            "$value"
        }
    }
}
