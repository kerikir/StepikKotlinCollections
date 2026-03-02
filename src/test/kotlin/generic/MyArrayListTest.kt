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
}