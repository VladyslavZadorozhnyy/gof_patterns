abstract class Shape {
   var x = 0
   var y = 0
    
   constructor() {}
   
   constructor(source: Shape) {
       this.x = source.x
       this.y = source.y
   }
   
   abstract fun clone(): Shape
}


class Rectangle: Shape {
    var width: Int = 0
    var height: Int = 0
    
    constructor(width: Int, height: Int) {
        this.width = width
        this.height = height
    }
    
    constructor (source: Rectangle) {
        width = source.width
        height = source.width
    }
    
    override fun clone(): Shape {
        return Rectangle(this)
    }
}

class Circle: Shape {
    var radius: Int = 0
    
    constructor(radius: Int) {
        this.radius = radius
    }
    
    
    constructor(source: Circle) {
        radius = source.radius
    }
    
    override fun clone(): Shape {
        return Circle(this)
    }
}



fun main() {
    val a = Rectangle(2,2)
    val b = a.clone()
    print("Hello, world")
}
