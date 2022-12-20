interface ComponentWithHelp {
    fun showHelp()
}


abstract class Component() : ComponentWithHelp {
    public var tooltipText: String?
    public var container: Container?
    
    override fun showHelp(): String {
        if (tooltipText == null) {
//             We get back to precessor component
//             until we get tooltipText
            return container.showHelp()
        } else {
            return tooltipText
        }
    }
}


abstract class Container() : Component {
    protected val children: List<Component> = mutableListOf()
    
    fun add(child: Component) {
        children.add(child)
        child.container = this
    }
}


class Button() : Component {
//     Some logic here
}


class Panel() : Container {
    private final modalTooltipText: String?
    
    override fun showHelp(): String {
        if (modalTooltipText == null) {
          return super.showHelp()
        } else {
            return modalTooltipText
        }
    }
}


fun main() {
    println("Hello world")
}
