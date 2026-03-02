package generic

import mutablelist.NumbersMutableList
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MyArrayListTest {

    private val numbers = MyArrayList<Int>()


    @Test
    fun `When add 1 element then size is 1`() {
        numbers.add(1)
        assertEquals(1, numbers.size)
    }


    @Test
    fun `When add 10 element then size is 10`() {
        repeat(10) {
            numbers.add(it)
        }
        assertEquals(10, numbers.size)
    }
}