package generic

import mutableset.NumbersHashSet.Node
import kotlin.math.abs


class MyHashSet<T> : MyMutableSet<T> {

    private var elements = arrayOfNulls<Any>(INITIAL_CAPACITY)

    override var size: Int = 0
        private set


    override fun add(element: T): Boolean {
        TODO("Not yet implemented")
    }

    override fun remove(element: T) {
        TODO("Not yet implemented")
    }

    override fun contains(element: T): Boolean {
        TODO("Not yet implemented")
    }

    override fun clear() {
        TODO("Not yet implemented")
    }


    private fun getElementPosition(element: T, arraySize: Int): Int {
        return abs(element.hashCode() % arraySize)
    }


    private fun increaseArray() {
        val newArray = arrayOfNulls<Node<T>>(elements.size * 2)

        for (node in elements) {
            var currentElement = node
            while (currentElement != null) {
                add(currentElement.item, newArray)
                currentElement = currentElement.next
            }
        }
        elements = newArray
    }


    class Node<T>(
        val item: T,
        var next: Node<T>? = null
    )


    override fun iterator(): Iterator<T> {
        TODO("Not yet implemented")
    }


    companion object {
        private const val INITIAL_CAPACITY = 16
        private const val LOAD_FACTORY = 0.75
    }
}