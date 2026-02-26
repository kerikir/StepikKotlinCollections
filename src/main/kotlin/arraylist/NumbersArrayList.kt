package arraylist

class NumbersArrayList(
    initialCapacity: Int = INITIAL_CAPACITY
) : NumbersMutableList {

    private var numbers = arrayOfNulls<Int>(initialCapacity)

    override var size: Int = 0
        private set

    override fun get(index: Int): Int {
        TODO("Not yet implemented")
    }

    override fun add(number: Int) {
        TODO("Not yet implemented")
    }

    override fun add(index: Int, number: Int) {
        TODO("Not yet implemented")
    }

    override fun removeAt(index: Int) {
        TODO("Not yet implemented")
    }

    override fun remove(number: Int) {
        TODO("Not yet implemented")
    }

    override fun clear() {
        TODO("Not yet implemented")
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


    companion object {
        private const val INITIAL_CAPACITY = 10
    }
}