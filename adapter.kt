class Hole(private val radius: Int) {
    fun fits(item: RoundReg): Boolean {
        return item.getRadius() <= radius
    }
}

open class RoundReg(private val radius: Int) {
    open fun getRadius(): Int {
        return radius
    }
}

class SquareRegAdapter(private val square: SquareReg) : RoundReg(square.getSide()) {
    override fun getRadius(): Int {
        return (square.getSide() * (1.4) / 2).toInt()
    }
}

class SquareReg(private val side: Int) {
    fun getSide(): Int {
        return side
    }
}

fun main() {
    val a = Hole(5)
    val b = RoundReg(10)
    val c = SquareReg(5)
    
    a.fits(b)
//     a.fits(c) // Crashes because of incompatible types
    
    val d = SquareRegAdapter(c)
    
    a.fits(d)
    println("Hello world")
}
