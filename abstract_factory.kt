interface Button {}

class WindowsButton : Button {}

class MacButton : Button {}

class WebButton : Button {}

interface CheckBox {}

class WindowsCheckBox : CheckBox {}

class MacCheckBox : CheckBox {}

class WebCheckBox : CheckBox {}

// This is 'abstract factory', not a method
// but whole class to be implemented
interface GUIFactory {
    fun getCheckBox(): CheckBox
    fun getButton(): Button
}

// This is 'abstract factory' implementation
class WindowsFactory : GUIFactory {
    override fun getCheckBox(): CheckBox {
        return WindowsCheckBox()
    }
    
    override fun getButton(): Button {
        return WindowsButton()
    }
}

class MacFactory : GUIFactory {
    override fun getCheckBox(): CheckBox {
        return MacCheckBox()
    }
    
    override fun getButton(): Button {
        return MacButton()
    }
}

class WebFactory : GUIFactory {
    override fun getCheckBox(): CheckBox {
        return WebCheckBox()
    }
    
    override fun getButton(): Button {
        return WebButton()
    }
}

class Application() {
    fun initialize(config: String): GUIFactory {
        if (config == "windows") {
            return WindowsFactory()
        } else if (config == "mac") {
            return MacFactory()
        } else {
            return WebFactory()
        }
    }
}

fun main() {
    Application().initialize("windows")
    print("Hello, world")
}
