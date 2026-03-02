package generic

fun main() {
    val people = MyArrayList<Person>()

    people.add(Person("Nick", 20))
    people.add(Person("Mike", 16))
    people.add(Person(name = "John", age = 25))

    people.forEach(::println)
}