class RedBlackTree<T: Comparable<T>> {
    var root: RedBlackNode<T>? = null

    fun insert(value: T) {
        root = insert(root, value)
    }

    private fun insert(node: RedBlackNode<T>?, value: T): RedBlackNode<T> {
        // Задача. Реализовать добавление узла в красно-черное дерево
        TODO()
    }
}