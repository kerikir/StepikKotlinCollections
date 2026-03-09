package generic

import mutableset.NumbersHashSet.Node
import kotlin.math.abs


class MyHashSet<T> : MyMutableSet<T> {

    private var elements = arrayOfNulls<Node<T>>(INITIAL_CAPACITY)

    override var size: Int = 0
        private set


    override fun add(element: T): Boolean {
        if (size >= elements.size * LOAD_FACTORY) {
            increaseArray()
        }

        return add(element, elements).also { added ->
            if (added) {
                size++
            }
        }
    }


    override fun remove(element: T) {
        val position = getElementPosition(element, elements.size)
        val existedElement = elements[position]

        if (existedElement?.item == element) {
            elements[position] = existedElement?.next
            size--
            return
        }

        var before = existedElement
        while (before?.next != null) {
            val removingElement = before.next

            if (removingElement?.item == element) {
                before.next = removingElement?.next
                size--
                return
            } else {
                before = before.next
            }
        }
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


    private fun add(element: T, array: Array<Node<T>?>): Boolean {
        val newNode = Node<T>(element)
        val position = getElementPosition(element, array.size)

        var existedElement = array[position]
        if (existedElement == null) {
            array[position] = newNode
            return true

        } else {
            while (true) {
                if (existedElement?.item == element) {
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