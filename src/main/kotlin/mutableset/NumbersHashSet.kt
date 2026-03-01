package mutableset

import kotlin.math.abs


class NumbersHashSet : NumbersMutableSet {

    private var elements = arrayOfNulls<Node>(INITIAL_CAPACITY)

    override var size: Int = 0
        private set


    private fun getElementPosition(number: Int, arraySize: Int): Int {
        return abs(number % arraySize)
    }


    private fun add(number: Int, array: Array<Node?>): Boolean {
        val newNode = Node(number)
        val position = getElementPosition(number, array.size)

        var existedElement = array[position]
        if (existedElement == null) {
            array[position] = newNode
            return true
            
        } else {
            while (true) {
                if (existedElement?.item == number) {
                    return false

                } else {
                    if (existedElement?.next == null) {
                        existedElement?.next = newNode
                        return true
                    } else {
                        existedElement = existedElement.next
                    }
                }
            }
        }
    }


    override fun add(number: Int): Boolean {
        if (size >= elements.size * LOAD_FACTORY) {

        }

        return add(number, elements)
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
        private const val LOAD_FACTORY = 0.75
    }


    class Node(
        val item: Int,
        var next: Node? = null
    )
}