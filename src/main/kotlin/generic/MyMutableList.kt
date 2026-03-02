package generic

interface MyMutableList<T> : MyMutableCollection<T> {

    override val size: Int

    override fun add(element: T): Boolean

    override fun remove(element: T)

    override fun contains(element: T): Boolean

    override fun clear()

    fun add(index: Int, element: T)

    operator fun get(index: Int): T

    fun removeAt(index: Int)
}