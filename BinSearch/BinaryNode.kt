class BinaryNode<T>(var value: T) : TreePrinter.PrintableNode {
    var left: BinaryNode<T>? = null
    var right: BinaryNode<T>? = null

    override fun toString(): String = TreePrinter.print(this)

    override fun getLeft(): TreePrinter.PrintableNode? {
        return left
    }

    override fun getRight(): TreePrinter.PrintableNode? {
        return right
    }

    override fun getText(): String {
        return "$value"
    }
}