package generic

class Person(
    val name: String,
    val age: Int
) {
    
    override fun toString(): String {
        return "${this.name}, ${this.age}"
    }
}