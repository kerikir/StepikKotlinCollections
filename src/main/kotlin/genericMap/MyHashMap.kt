package genericMap

import kotlin.math.abs


class MyHashMap<K, V> : MyMutableMap<K, V> {

    private var elements = arrayOfNulls<Node<K, V>>(INITIAL_CAPACITY)

    override var size: Int = 0
        private set


    override fun put(key: K, value: V): V? {
        if (size >= elements.size * LOAD_FACTORY) {
            increaseArray()
        }

        return put(key, value, elements).also { oldValue ->
            if (oldValue == null) {
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
            modificationCounter++
            return
        }

        var before = existedElement
        while (before?.next != null) {
            val removingElement = before.next

            if (removingElement?.item == element) {
                before.next = removingElement?.next
                size--
                modificationCounter++
                return
            } else {
                before = before.next
            }
        }
    }


    override fun contains(element: T): Boolean {
        val position = getElementPosition(element, elements.size)
        var existedElement = elements[position]

        while (existedElement != null) {
            if (existedElement.item == element) {
                return true

            } else {
                existedElement = existedElement.next
            }
        }

        return false
    }


    override fun clear() {
        elements = arrayOfNulls<Node<T>>(INITIAL_CAPACITY)
        size = 0
        modificationCounter++
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


    private fun put(key: K, value: V, array: Array<Node<K, V>?>): V? {
        val newNode = Node<K, V>(key, value)
        val position = getElementPosition(key, array.size)

        var existedElement = array[position]
        if (existedElement == null) {
            array[position] = newNode
            return null

        } else {
            while (true) {
                if (existedElement?.key == key) {
                    return existedElement?.value.also {
                        existedElement?.value = value
                    }

                } else {
                    if (existedElement?.next == null) {
                        existedElement?.next = newNode
                        return null
                    } else {
                        existedElement = existedElement.next
                    }
                }
            }
        }
    }


    data class Node<K, V>(
        val key: K,
        var value: V,
        var next: Node<K, V>? = null
    )


    companion object {
        private const val INITIAL_CAPACITY = 16
        private const val LOAD_FACTORY = 0.75
    }
}