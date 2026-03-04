package generic

class MyLinkedList<T> : MyMutableList<T> {

    private var first: Node<T>? = null
    private var last: Node<T>? = null

    override var size: Int = 0
        private set


    override fun get(index: Int): T {
        checkIndex(index)
        return getNode(index).item
    }


    override fun add(index: Int, element: T) {
        TODO("Not yet implemented")
    }


    override fun removeAt(index: Int) {
        TODO("Not yet implemented")
    }

    override fun clear() {
        size = 0
        first = null
        last = null
    }


    override fun iterator(): Iterator<T> {
        TODO("Not yet implemented")
    }


    override fun add(element: T): Boolean {
        TODO("Not yet implemented")
    }

    override fun remove(element: T) {
        TODO("Not yet implemented")
    }

    override fun contains(element: T): Boolean {
        TODO("Not yet implemented")
    }


    private fun unlink(node: Node<T>) {
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


    private fun getNode(index: Int): Node<T> {
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


    class Node<T>(
        var prev: Node<T>? = null,
        val item: T,
        var next: Node<T>? = null
    )
}