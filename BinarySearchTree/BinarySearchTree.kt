class BinarySearchTree<T: Comparable<T>> {
    var root: BinaryNode<T>? = null

    override fun toString(): String = root?.toString() ?: "empty tree"

    fun insert(value: T) {
        root = insert(root, value)
    }

    private fun insert(node: BinaryNode<T>?, value: T): BinaryNode<T> {
        if (node == null) {
            val node = BinaryNode(value)
            return node
        }
        if (value < node.value) {
            node.left = insert(node.left, value)
        } else {
            node.right = insert(node.right, value)
        }
        return node
    }

    fun find(value: T): BinaryNode<T>? {
        var node = root
        while (node != null) {
            if (value == node.value) {
                return node
            }
            if (value < node.value) {
                node = node.left
            } else {
                node = node.right
            }
        }
        return null
    }

    fun remove(value: T) {
        root = remove(root, value)
    }

    private fun remove(node: BinaryNode<T>?, value: T): BinaryNode<T>? {
        if (node == null) {
            return null
        }
        if (value == node.value) {
            if (node.left == null && node.right == null) {
                return null
            }
            if (node.left == null) {
                return node.right
            }
            val right = node.right
            if (right == null) {
                return node.left
            }
            val minNode = right.getMin()
            node.value = minNode.value
            node.right = remove(node.right, minNode.value)
        }
        if (value < node.value) {
            node.left = remove(node.left, value)
        } else {
            node.right = remove(node.right, value)
        }
        return node
    }

    /*
    (1) Добавление элемента в бинарное дерево поиска
    (2) Поиск элемента в BST (binary search tree)
    (3) Удаление элемента из BST
    (4) Проход по бинарному дереву поиска
     */

    /*
    Задача. Реализовать добавление элемента в BST.
     */

    /*
    Задача. Реализовать перечисление элементов бинарного дерева поиска
    в неубывающем порядке.
     */
    fun getList(): List<T> {
        return getList(root)
    }

    private fun getList(node: BinaryNode<T>?): List<T> {
        if (node == null) {
            return emptyList()
        }
        val list = mutableListOf<T>()
        val leftList = getList(node.left)
        for (x in leftList) {
            list.add(x)
        }
        list.add(node.value)
        val rightList = getList(node.right)
        for (x in rightList) {
            list.add(x)
        }
        return list
    }
    /*
    Задача 1. Реализовать поиск узла BST по значению.
    Задача 2. Для каждой вершины бинарного дерева поиска найти следующую
    за ней вершину по значению.
     */

}