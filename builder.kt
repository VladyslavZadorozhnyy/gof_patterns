// Builder pattern means you have several classes for constructing classes
// instead of making plenty of subclasses or constructors with big number
// of parameters.

class Car {}

class Manual {}

interface Builder {
    fun reset()
    fun setSeats()
    fun setEngine()
}

class CarBuilder() : Builder {
    private var car: Car?
    
    init {
        car = Car()
    }
    
    override fun reset() {}
    
    override fun setSeats() {}
    
    override fun setEngine() {}
    
    fun getResult(): Car? {
        return car
    }
    
    fun createSportCar() : Car? {
        return getResult()
    }
}

class CarManualBuilder(): Builder {
    private var manual: Manual?
    
    init {
        manual = Manual()
    }
    
    override fun reset() {}
    
    override fun setSeats() {}
    
    override fun setEngine() {}
    
    fun getResult(): Manual? {
        return manual
    }
    
    fun createSportCarManual() : Manual? {
        return getResult()
    }
}

fun main() {
    CarManualBuilder().createSportCarManual()
    print("Hello, world")
}
