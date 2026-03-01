package mutableset

class NumbersHashSet : NumbersMutableSet {

    override var size: Int = 0
        private set

    override fun add(number: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun remove(number: Int) {
        TODO("Not yet implemented")
    }

    override fun contains(number: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun clear() {
        TODO("Not yet implemented")
    }


    class Node(
        val item: Int,
        var next: Node? = null
    )
}