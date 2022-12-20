fun main() {
    SingletonObj.a = 20
    SingletonObj.describe()
    println("Hello, world!!!")
}

// Constructors not allowed in objects
object SingletonObj {
    var a: Int = 10
    val b: Int = 20    
    
    init {
        println("This is init object executed (called once)")
        this(1)
    }
    
    fun describe() = println("var a: $a, val b: $b")
}
