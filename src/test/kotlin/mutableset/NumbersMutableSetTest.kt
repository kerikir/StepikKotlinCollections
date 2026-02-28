package mutableset

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class NumbersMutableSetTest {

    private val numbers = NumbersHashSet()


    @Test
    fun `When added 100 elements Then size 100`() {
		repeat(100) {
            numbers.add(it)
        }
        assertEquals(100, numbers.size)
    }
}