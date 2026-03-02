package generic

class MyArrayList<T>(initialCapacity: Int = INITIAL_CAPACITY) : MyMutableList<T> {

    private var elements = arrayOfNulls<Any>(initialCapacity)

    override var size: Int = 0
        private set


    override fun clear() {
        elements = arrayOfNulls<Any>(INITIAL_CAPACITY)
        size = 0
    }


    override fun iterator(): Iterator<T> {
        TODO("Not yet implemented")
    }


    override fun add(element: T): Boolean {
        TODO("Not yet implemented")
    }

    override fun add(index: Int, element: T) {
        TODO("Not yet implemented")
    }

    override fun remove(element: T) {
        TODO("Not yet implemented")
    }

    override fun contains(element: T): Boolean {
        TODO("Not yet implemented")
    }

    override fun get(index: Int): T {
        TODO("Not yet implemented")
    }

    override fun removeAt(index: Int) {
        TODO("Not yet implemented")
    }

    
    companion object {
        private const val INITIAL_CAPACITY = 10
    }
}