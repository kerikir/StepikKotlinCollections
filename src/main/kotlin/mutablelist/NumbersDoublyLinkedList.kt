package mutablelist

class NumbersDoublyLinkedList : NumbersMutableList {

    override var size: Int = 0
        private set

    private var first: Node? = null
    private var last: Node? = null


    private fun getNode(index: Int): Node {
        if (index == 0) return first!!
        if (index == size - 1) return last!!

        if (index < size / 2) {
            var node = first
            repeat(index) {
                node = node?.next
            }
            return node!!
        } else {
            var node = last
            repeat(size - index - 1) {
                node = node?.prev
            }
            return node!!
        }
    }


    private fun unlink(node: Node) {
        val before = node.prev
        val after = node.next
        before?.next = after
        after?.prev = before

        if (after == null) {
            last = before
        }
        if (before == null) {
            first = after
        }
        size--
    }


    override fun get(index: Int): Int {
        checkIndex(index)
        return getNode(index).item
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
        checkIndexAdding(index)

        if (index == size) {
            add(number)
            return
        }
        if (index == 0) {
            val node = Node(null, number, first)
            first?.prev = node
            first = node
            size++
            return
        }

        val before = getNode(index - 1)
        val after = before.next
        val newNode = Node(before, number, after)
        before.next = newNode
        after?.prev = newNode
        size++
    }


    override fun removeAt(index: Int) {
        checkIndex(index)
        val node = getNode(index)
        unlink(node)
    }


    override fun remove(number: Int) {
        var node = first
        while (node != null) {
            if (node.item == number) {
                unlink(node)
                return
            } else {
                node = node.next
            }
        }
    }


    override fun clear() {
        size = 0
        first = null
        last = null
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