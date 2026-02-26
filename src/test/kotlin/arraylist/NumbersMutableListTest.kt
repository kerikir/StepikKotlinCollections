package arraylist

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class NumbersMutableListTest {

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
    fun `When list not contains element then method return false`(list: NumbersMutableList) {
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
        private fun numbersMutableListSource() = listOf(NumbersArrayList())
    }
}