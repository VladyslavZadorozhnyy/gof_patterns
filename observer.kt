interface Consumer {
//     Method to be executed when notified on value change
    fun <T> update(argument: T)
}

class IntConsumer() : Consumer {    
    override fun<String> update(a : String) {
        println("Given new value to IntConsumer: $a")
    }
}

class StringConsumer() : Consumer {    
    override fun<String> update(a : String) {
        println("Given new value to StringConsumer: $a")
    }
}

class Producer() {
    private val consumers: MutableList<Consumer> = mutableListOf()
    
//     We add consumers to be notified on value change
    fun addConsumer(consumer: Consumer) {
        consumers.add(consumer)
    }
    
//     We notify consumers on value change
    fun updateConsumers() {
        consumers.forEach {
            it.update("New value")
        }
    }
}

fun main() {
    val a = IntConsumer()
    val b = StringConsumer()
    
    val c = Producer()
    c.addConsumer(a)
    c.addConsumer(b)
    
    c.updateConsumers()
    println("Hello world")
}
