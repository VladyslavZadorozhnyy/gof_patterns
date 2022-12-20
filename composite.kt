interface Priceable {    
    fun getPrice(): Int
}

class Box : Priceable {
    val content: MutableList<Priceable> = mutableListOf()
    
//     This class is a composite, that delegates functionality
//     to its childred (leaves)
    override fun getPrice(): Int {
        return content.map { it.getPrice() }.sum()
    }
    
    fun addItem(item: Priceable) {
        content.add(item)
    }
}

class Laptop(private val price: Int) : Priceable {
//     This class is a leave, which processes needed
//     functionality
    override fun getPrice(): Int {
        return price
    }
}

fun main() {
    val box = Box()
    val sealedBox = Box()
    val laptop = Laptop(20)
    
    box.addItem(laptop)
    box.getPrice() // 20
    
    sealedBox.addItem(laptop)
    box.addItem(sealedBox)
    box.getPrice() // 40
    
    println("Hello world")
}
