package mutablelist

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource


class NumbersMutableListTest {

    @ParameterizedTest
    @MethodSource("numbersMutableListSource")
    fun `When add 1 element then size is 1`(list: NumbersMutableList) {
        list.add(1)
        assertEquals(1, list.size)
    }

    @ParameterizedTest
    @MethodSource("numbersMutableListSource")
    fun `When add 10 element then size is 10`(list: NumbersMutableList) {
        repeat(10) {
            list + it
        }
        assertEquals(10, list.size)
    }

    @ParameterizedTest
    @MethodSource("numbersMutableListSource")
    fun `When add 100 element then size is 100`(list: NumbersMutableList) {
        repeat(100) {
            list + it
        }
        assertEquals(100, list.size)
    }

    @ParameterizedTest
    @MethodSource("numbersMutableListSource")
    fun `When element added to first position then it is in first position`(list: NumbersMutableList) {
        repeat(100) {
            list.add(it)
        }
        list.add(0, 1000)
        assertEquals(1000, list.get(0))
    }

    @ParameterizedTest
    @MethodSource("numbersMutableListSource")
    fun `When element added to last position then it is in last position`(list: NumbersMutableList) {
        repeat(100) {
            list.add(it)
        }
        list.add(100, 1000)
        assertEquals(1000, list.get(100))
    }

    @ParameterizedTest
    @MethodSource("numbersMutableListSource")
    fun `When get 5th element then result is correct`(list: NumbersMutableList) {
        repeat(10) { list.add(it) }
        assertEquals(5, list[5])
    }

    @ParameterizedTest
    @MethodSource("numbersMutableListSource")
    fun `When get 50th element then result is correct`(list: NumbersMutableList) {
        repeat(100) { list.add(it) }
        assertEquals(50, list[50])
    }

    @ParameterizedTest
    @MethodSource("numbersMutableListSource")
    fun `When element removed then size decreased`(list: NumbersMutableList) {
        repeat(100) {
            list.add(it)
        }
        list.remove(50)
        assertEquals(99, list.size)
    }

    @ParameterizedTest
    @MethodSource("numbersMutableListSource")
    fun `When removed 50th next value at this position`(list: NumbersMutableList) {
        repeat(100) {
            list.add(it)
        }
        list.removeAt(50)
        assertEquals(51, list[50])
    }

    @ParameterizedTest
    @MethodSource("numbersMutableListSource")
    fun `When removed value 50 next value at this position`(list: NumbersMutableList) {
        repeat(100) {
            list.add(it)
        }
        list.remove(50)
        assertEquals(51, list.get(50))
    }

    @ParameterizedTest
    @MethodSource("numbersMutableListSource")
    fun `When list is cleared then size is 0 elements`(list: NumbersMutableList) {
        repeat(100) {
            list.add(it)
        }
        list.clear()
        assertEquals(0, list.size)
    }

    @ParameterizedTest
    @MethodSource("numbersMutableListSource")
    fun `When list contains element then method return true`(list: NumbersMutableList) {
        repeat(100) {
            list.add(it)
        }
        assertTrue(list.contains(99))
    }

    @ParameterizedTest
    @MethodSource("numbersMutableListSource")
    fun `When list does not contains element then method return false`(list: NumbersMutableList) {
        repeat(100) {
            list.add(it)
        }
        assertFalse(list.contains(100))
    }

    @ParameterizedTest
    @MethodSource("numbersMutableListSource")
    fun `When method get invoked with wrong index then exception is thrown`(list: NumbersMutableList) {
        repeat(10) {
            list.add(it)
        }
        assertThrows<IndexOutOfBoundsException> {
            list[10]
        }
    }

    @ParameterizedTest
    @MethodSource("numbersMutableListSource")
    fun `When method get invoked with negative index then exception is thrown`(list: NumbersMutableList) {
        repeat(10) {
            list.add(it)
        }
        assertThrows<IndexOutOfBoundsException> {
            list[-2]
        }
    }

    companion object {
        @JvmStatic
        private fun numbersMutableListSource() = listOf(NumbersArrayList(), NumbersSinglyLinkedList())
    }
}