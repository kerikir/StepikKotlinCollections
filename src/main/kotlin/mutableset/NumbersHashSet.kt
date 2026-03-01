package mutableset

import kotlin.math.abs


class NumbersHashSet : NumbersMutableSet {

    private var elements = arrayOfNulls<Int>(INITIAL_CAPACITY)

    override var size: Int = 0
        private set


    private fun getElementPosition(number: Int, arraySize: Int): Int {
        return abs(number % arraySize)
    }


    override fun add(number: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun remove(number: Int) {
        TODO("Not yet implemented")
    }

    override fun contains(number: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun clear() {
        TODO("Not yet implemented")
    }


    companion object {
        private const val INITIAL_CAPACITY = 16
    }


    class Node(
        val item: Int,
        var next: Node? = null
    )
}