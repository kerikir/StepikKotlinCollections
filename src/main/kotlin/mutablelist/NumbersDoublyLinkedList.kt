package mutablelist

class NumbersDoublyLinkedList : NumbersMutableList {

    override var size: Int = 0
        private set

    private var first: Node? = null
    private var last: Node? = null

    override fun get(index: Int): Int {
        TODO("Not yet implemented")
    }

    override fun add(number: Int) {
        val prevLast = last
        last = Node(prevLast, number)
        if (prevLast == null) {
            first = last
        } else {
            prevLast.next = last
        }
        size++
    }

    override fun add(index: Int, number: Int) {
        TODO("Not yet implemented")
    }

    override fun removeAt(index: Int) {
        TODO("Not yet implemented")
    }

    override fun remove(number: Int) {
        TODO("Not yet implemented")
    }

    override fun clear() {
        TODO("Not yet implemented")
    }

    override fun contains(number: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun plus(number: Int) {
        TODO("Not yet implemented")
    }

    override fun minus(number: Int) {
        TODO("Not yet implemented")
    }

    private fun checkIndex(index: Int) {
        if (index < 0 || index >= size) {
            throw IndexOutOfBoundsException("Index: $index Size: $size")
        }
    }

    private fun checkIndexAdding(index: Int) {
        if (index < 0 || index > size) {
            throw IndexOutOfBoundsException("Index: $index Size: $size")
        }
    }

    class Node(
        var prev: Node? = null,
        val item: Int,
        var next: Node? = null
    )
}