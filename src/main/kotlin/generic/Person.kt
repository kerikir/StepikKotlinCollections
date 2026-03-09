package generic

class Person(
    val name: String,
    val age: Int
) {
    
    override fun toString(): String {
        return "${this.name}, ${this.age}"
    }


    override fun equals(other: Any?): Boolean {

        if (this === other) return true
        if (other !is Person) return false

        return this.name == other.name && this.age == other.age
    }
}