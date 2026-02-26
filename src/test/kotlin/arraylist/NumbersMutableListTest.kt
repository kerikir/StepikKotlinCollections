package arraylist

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals

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

    companion object {
        @JvmStatic
        private fun numbersMutableListSource() = listOf(NumbersArrayList())
    }
}