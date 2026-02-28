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
        TODO("Not yet implemented")
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

    class Node(
        var prev: Node? = null,
        val item: Int,
        var next: Node? = null
    )
}