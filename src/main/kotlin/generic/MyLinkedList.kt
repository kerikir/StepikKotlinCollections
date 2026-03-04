package generic

class MyLinkedList<T> : MyMutableCollection<T> {

    override var size: Int = 0
        private set


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

    override fun clear() {
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


    class Node<T>(
        var prev: Node<T>? = null,
        val item: T,
        var next: Node<T>? = null
    )
}