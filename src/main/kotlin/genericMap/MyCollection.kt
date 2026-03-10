package genericMap

interface MyCollection<T> {

    val size: Int

    fun contains(element: T): Boolean
}