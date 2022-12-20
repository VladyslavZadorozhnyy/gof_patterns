interface Operation {
    fun execute(operateOn: Int): Int
    
    fun undo(operateOn: Int): Int
}

class Addition(private val operateWith: Int): Operation {
    override fun execute(operateOn: Int): Int {
        return operateOn + operateWith
    }
    
    override fun undo(operateOn: Int): Int {
        return operateOn - operateWith
    }
}

class Subtraction(private val operateWith: Int): Operation {
    override fun execute(operateOn: Int): Int {
        return operateOn - operateWith
    }
    
    override fun undo(operateOn: Int): Int {
        return operateOn + operateWith
    }
}

class Mutltiplication(private val operateWith: Int): Operation {
    override fun execute(operateOn: Int): Int {
        return operateOn * operateWith
    }
    
    override fun undo(operateOn: Int): Int {
        return operateOn / operateWith
    }
}

class Division(private val operateWith: Int): Operation {
    override fun execute(operateOn: Int): Int {
        return operateOn / operateWith
    }
    
    override fun undo(operateOn: Int): Int {
        return operateOn * operateWith
    }
}


class Calculator(private var currentValue: Int) {
    private val operationStack: MutableList<Operation> = mutableListOf()
    
    fun addOperation(operation: Operation) {
        currentValue = operation.execute(currentValue)
        operationStack.add(operation)
    }
    
    fun popOperation() {
        currentValue = operationStack.last().undo(currentValue)
        operationStack.removeLast()
    }
    
    fun getValue(): Int {
        return currentValue
    }
}


fun main() {
    val calculator = Calculator(0)
    val addOperation = Addition(10)
    
    
    calculator.addOperation(addOperation)
    println("Current value: ${calculator.getValue()}") // expected 10
    
    calculator.popOperation()
    println("Current value: ${calculator.getValue()}") // expected 0
    
    println("Hello world")
}
