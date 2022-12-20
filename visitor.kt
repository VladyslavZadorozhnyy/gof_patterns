interface VisitedElement {
    fun accept(v: Visitor)
}

class Visitor() {
    fun visitRectangular(rectangular: Rectangular) {
        println("recatngular.topLeft is: ${rectangular.topLeft}")
    }
    
    fun visitCircle(circle: Circle) {
        println("circle.radius is: ${circle.radius}")
    }
}

abstract class Shape : VisitedElement {
    fun move(x: Int, y: Int) {}
    
    fun draw() {}
}

class Rectangular(
  val topLeft: Int,
    val topRight: Int,
    val bottomLeft: Int,
    val bottomRight: Int
) : Shape() {
    override fun accept(v: Visitor) {
        v.visitRectangular(this)
    }
}

class Circle(
  val center: Int,
    val radius: Int
) : Shape() {
    override fun accept(v: Visitor) {
        v.visitCircle(this)
    }
}


fun main() {
   val c = Circle(4, 10)
   val r = Rectangular(4, 10, 2, 2)
   val v = Visitor()
   
   c.accept(v)
   r.accept(v)
   
   println("Hello world")
}
