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


    @Test
    fun `When added 10 similar elements Then size 1`() {
        repeat(10) {
            numbers.add(0)
        }
        assertEquals(1, numbers.size)
    }
}