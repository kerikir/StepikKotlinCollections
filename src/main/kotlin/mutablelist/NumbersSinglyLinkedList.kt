package mutablelist

class NumbersSinglyLinkedList : NumbersMutableList {

    override var size: Int = 0
        private set

    private var first: Node? = null
    private var last: Node? = null

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

    private fun getNode(index: Int): Node {
        checkIndex(index)
        if (index == 0) return first!!
        if (index == size - 1) return last!!

        var node = first
        repeat(index) {
            node = node?.next
        }
        return node!!
    }

    override fun get(index: Int): Int {
        val node = getNode(index)
        return node.item
    }

    override fun add(number: Int) {
        if (size == 0) {
            val node = Node(number)
            first = node
            last = node
            size++
            return
        }
        val newNode = Node(number)
        last?.next = newNode
        last = newNode
        size++
    }

    override fun add(index: Int, number: Int) {
        checkIndexAdding(index)

        if (index == 0) {
            val newNode = Node(number, first)
            first = newNode
            size++
            return
        }
        if (index == size) {
            add(number)
            return
        }

        val before = getNode(index - 1)
        val after = before.next
        val node = Node(number, after)
        before.next = node
        size++
    }

    override fun removeAt(index: Int) {
        checkIndex(index)
        if (index == 0) {
            first = first?.next
            size--
            return
        }
        val before = getNode(index - 1)
        val after = before.next?.next
        before.next = after
        if (after == null) {
            last = before
        }
        size--
    }

    override fun remove(number: Int) {
        var node = first
        if (node?.item == number) {
            first = node.next
            size--
        }

        repeat(size) {
            val after = node?.next
            if (after?.item == number) {
                node?.next = after.next
                if (node?.next == null) {
                    last = node
                }
                size--
            } else {
                node = after
            }
        }
    }

    override fun clear() {
        size = 0
        first = null
        last = null
    }

    override fun contains(number: Int): Boolean {
        var node = first
        repeat(size) {
            if (node?.item == number) {
                return true
            }
            node = node?.next
        }
        return false
    }

    override fun plus(number: Int) {
        add(number)
    }

    override fun minus(number: Int) {
        remove(number)
    }

    class Node(
        val item: Int,
        var next: Node? = null
    )
}