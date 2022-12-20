interface Strategy {
  fun findRoute(pointA: Double, pointB: Double)   
}

class LandStrategy() : Strategy {
//     We delegate logic to Strategy object, but the object
//     does not know about the context
    override fun findRoute(pointA: Double, pointB: Double) {
//         Some logic here for finding land route
    }
}

class SeaStrategy() : Strategy {
    override fun findRoute(pointA: Double, pointB: Double) {
//         Some logic here for finding sea route
    }
}

class AirStrategy() : Strategy {
    override fun findRoute(pointA: Double, pointB: Double) {
//         Some logic here for finding air route
    }
}

class Navigator() {
    private var strategy: Strategy? = null
    
    fun setStrategy(newStrategy: Strategy) {
        strategy = newStrategy
    }
    
    fun findRoute(pointA: Double, pointB: Double) {
        strategy.findRoute(pointA, pointB)
    }
}



fun main() {
   println("Hello world")
}
