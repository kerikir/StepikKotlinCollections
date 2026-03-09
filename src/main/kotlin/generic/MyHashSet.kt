package generic


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


    class Node<T>(
        val item: Int,
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