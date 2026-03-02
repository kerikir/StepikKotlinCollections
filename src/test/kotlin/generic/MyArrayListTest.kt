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


    @Test
    fun `When add 100 element then size is 100`() {
        repeat(100) {
            numbers.add(it)
        }
        assertEquals(100, numbers.size)
    }


    @Test
    fun `When element added to first position then it is in first position`() {
        repeat(100) {
            numbers.add(it)
        }
        numbers.add(0, 1000)
        assertEquals(1000, numbers[0])
    }


    @Test
    fun `When element added to last position then it is in last position`() {
        repeat(100) {
            numbers.add(it)
        }
        numbers.add(100, 1000)
        assertEquals(1000, numbers[100])
    }


    @Test
    fun `When get 5th element then result is correct`() {
        repeat(10) { numbers.add(it) }
        assertEquals(5, numbers[5])
    }


    @Test
    fun `When get 50th element then result is correct`() {
        repeat(100) { numbers.add(it) }
        assertEquals(50, numbers[50])
    }


    @Test
    fun `When element removed then size decreased`() {
        repeat(100) {
            numbers.add(it)
        }
        numbers.remove(50)
        assertEquals(99, numbers.size)
    }


    @Test
    fun `When removed 50th next value at this position`() {
        repeat(100) {
            numbers.add(it)
        }
        numbers.removeAt(50)
        assertEquals(51, numbers[50])
    }


    @Test
    fun `When removed value 50 next value at this position`() {
        repeat(100) {
            numbers.add(it)
        }
        numbers.remove(50)
        assertEquals(51, numbers.get(50))
    }


    @Test
    fun `When list is cleared then size is 0 elements`() {
        repeat(100) {
            numbers.add(it)
        }
        numbers.clear()
        assertEquals(0, numbers.size)
    }


    @Test
    fun `When list contains element then method return true`() {
        repeat(100) {
            numbers.add(it)
        }
        assertTrue(numbers.contains(99))
    }
}