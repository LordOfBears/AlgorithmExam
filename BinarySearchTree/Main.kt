/*
   корень
   левый правый

   (1) элемент Tree(x), где x: T - бинарное дерево,
   (2) пустой элемент null - бинарное дерево
   (3) A и B - бинарные деревья, а x - элемент типа T,
       тогда (x, A, B) - бинарное дерево,
       A - левым потомок
       B - правый потомок

       x
    A    B

    Бинарное дерево поиска - это бинарное дерево со сравнимыми элементами
    с доп. условием:
    все элементы в левом поддереве меньше корня
    все элементы в правом поддерреве больше или равны корня.
*/
fun main() {
    val tree = BinarySearchTree<Int>()
    val list = listOf(5, 3, 2, 3, 1, 7, 6)
    for (x in list) {
        tree.insert(x)
    }
    println(tree)
//    val node = tree.find(11)
//    println(node)
    tree.remove(5)
    println(tree)
}


fun main1() {
    /*
    a = [1, 2, 5, 4, 6, 8, 7]
    x = 4
    indexOf(x)
    O(n) - поиск элемента в произвольном массиве.
    Бинарный поиск
    a = [1, 4, 5, 8, 9, 18, 32, 68, 99]
    x = 68
    O(log n) - бинарный поиск в упорядоченном массиве

    индексация
    */
    val array = arrayListOf(1, 1, 1, 5, 15, 17, 19, 22, 24, 31, 31, 31, 105, 150, 150)
    val x = 150
    val start = array.startIndex(x)
    val end = array.endIndex(x)
    println("Диапазон индексов элемента $x: $start..$end")
    /*
    Задача. Найти диапазон индексов, который заполняет данный элемент x
    в упорядоченном массиве, за логарифмическое время.
    */
}

fun <T: Comparable<T>>  ArrayList<T>.endIndex(value: T,
                                                range: IntRange = indices): Int? {
    if (range.first > range.last) {
        return null
    }
    val size = range.last - range.first + 1
    val middle = range.first + size / 2
    if (value == this[middle]) {
        if (middle == range.last) {
            return range.last
        }
        if (this[middle + 1] != value) {
            return middle
        } else {
            endIndex(value, middle + 1..range.last)
        }
    }
    if (value < this[middle]) {
        return endIndex(value, range.first until middle)
    } else {
        return endIndex(value, middle + 1..range.last)
    }
}



fun <T: Comparable<T>>  ArrayList<T>.startIndex(value: T,
                                                range: IntRange = indices): Int? {
    if (range.first > range.last) {
        return null
    }
    val size = range.last - range.first + 1
    val middle = range.first + size / 2
    if (value == this[middle]) {
        if (middle == range.first) {
            return middle
        }
        if (value == this[middle - 1]) {
            return startIndex(value, range.first until middle)
        } else {
            return middle
        }
    }
    if (value < this[middle]) {
        return startIndex(value, range.first until middle)
    } else {
        return startIndex(value, middle + 1..range.last)
    }
}

/*
a.compareTo(b)
a > b
*/

fun <T: Comparable<T>> ArrayList<T>.search1(value: T,
                                           range: IntRange = indices): Int? {
    if (range.first > range.last) {
        return null
    }
    val size = range.last - range.first + 1
    val middle = range.first + size / 2
    if (value == this[middle]) {
        return middle
    }
    if (value < this[middle]) {
        return search1(value, range.first until middle)
    } else {
        return search1(value, middle + 1..range.last)
    }
}




