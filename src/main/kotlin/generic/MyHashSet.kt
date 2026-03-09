package generic

import mutableset.NumbersHashSet
import mutableset.NumbersHashSet.Companion
import mutableset.NumbersHashSet.Node

class MyHashSet<T> : MyMutableSet<T> {

    private var elements = arrayOfNulls<Any>(INITIAL_CAPACITY)

    
    override fun iterator(): Iterator<T> {
        TODO("Not yet implemented")
    }

    override val size: Int
        get() = TODO("Not yet implemented")

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


    companion object {
        private const val INITIAL_CAPACITY = 16
        private const val LOAD_FACTORY = 0.75
    }
}