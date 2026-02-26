package arraylist

class NumbersArrayList(
    initialCapacity: Int = INITIAL_CAPACITY
) : NumbersMutableList {

    private var numbers = arrayOfNulls<Int>(initialCapacity)

    override var size: Int = 0
        private set

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

    private fun growIfNeeded() {
        if (numbers.size == size) {
            val newArray = arrayOfNulls<Int>(numbers.size * 2)
            System.arraycopy(numbers, 0, newArray, 0, numbers.size)
            numbers = newArray
        }
    }

    override fun get(index: Int): Int {
        checkIndex(index)
        return numbers[index]!!
    }

    override fun add(number: Int) {
        growIfNeeded()
        numbers[size] = number
        size++
    }

    override fun add(index: Int, number: Int) {
        growIfNeeded()
        checkIndexAdding(index)
        System.arraycopy(numbers, index, number, index + 1, size - index)
        numbers[index] = number
        size++
    }

    override fun removeAt(index: Int) {
        checkIndex(index)
        System.arraycopy(numbers, index + 1, numbers, index, size - index - 1)
        size--
        numbers[size] = null
    }

    override fun remove(number: Int) {
        for (i in numbers.indices) {
            if (numbers[i] == number) {
                removeAt(i)
                return
            }
        }
    }

    override fun clear() {
        numbers = arrayOfNulls<Int>(INITIAL_CAPACITY)
        size = 0
    }

    override fun contains(number: Int): Boolean {
        for (i in numbers.indices) {
            if (numbers[i] == number) {
                return true
            }
        }
        return false
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