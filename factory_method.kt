// Button is different object on different platforms
interface Button {
    fun setOnClickListener()
    fun changeColor()
}


class WindowsButton : Button {
    override fun setOnClickListener() {}
    override fun changeColor() {}
}

class MacButton : Button {
    override fun setOnClickListener() {}
    override fun changeColor() {}
}

class WebButton : Button {
    override fun setOnClickListener() {}
    override fun changeColor() {}
}


// This class acts as a basic factory to be overriden
abstract class Dialog {
    fun show() {}
//     This is 'fabric method'
    abstract fun getButton(): Button
}


// This class acts as a factory implementation one
// method is overriden here only, that's why the name
// is: factory method.
class WindowsDialog : Dialog() {
    override fun getButton(): Button {
        return WindowsButton()
    }
}


class MacDialog : Dialog() {
    override fun getButton(): Button {
        return MacButton()
    }
}

class WebDialog : Dialog() {
    override fun getButton(): Button {
        return WebButton()
    }
}

// This method defines what exact factory to 
// return.
class Application() {
    fun initialize(config: String): Dialog {
        if (config == "windows") {
            return WindowsDialog()
        } else if (config == "mac") {
            return WindowsDialog()
        } else {
            return WebDialog()
        }
    }
}


fun main() {
    Application().initialize("windows")
    print("Hello, world")
}
