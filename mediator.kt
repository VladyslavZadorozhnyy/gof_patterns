interface Clickable {
    fun onClicked() {}
}

interface Mediator {
    fun clickedOnChild(child: Clickable, action: String) {}
}

class Button(
    private val label: String,
    private val mediator: Mediator
): Clickable {
//     Instead of defining logic here, we delegate this 
//     to mediator object. Thus, we can reuse the component
//     many times
    override fun onClicked() {
        mediator.clickedOnChild(this, "click")
    }
}

class CheckBox(
    private val hint: String,
    private val mediator: Mediator
): Clickable {
//     Instead of defining logic here, we delegate this 
//     to mediator object. Thus, we can reuse the component
//     many times
    override fun onClicked() {
        mediator.clickedOnChild(this, "check toggled")
    }
}

class Dialog(): Mediator {
    private val okButton = Button("Ok", this)
    private val declineButton = Button("Decline", this)
    private val rememberMe = CheckBox("Remember me", this)
    
    override fun clickedOnChild(child: Clickable, action: String) {
//         Here we work with click events on children
//         By doing this we keep logic in a common place
        if (child == okButton) {
//             Some logic here
        } else if (child == declineButton) {
//             Some logic here
        } else {
//             Some logic here
        }
    }
}

fun main() {
    val dialog = Dialog()
    println("Hello world")
}
