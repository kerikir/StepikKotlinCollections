package generic

fun main() {
    val people = MyLinkedList<Person>()

    people.add(Person("Nick", 20))
    people.add(Person("Mike", 16))
    people.add(Person(name = "John", age = 25))

    people.forEach(::println)
}