interface Device {
    fun switchOn() {}
    
    fun switchOff() {}
    
    fun channelUp() {}
    
    fun channelDown() {}
    
    fun mute() {}
}

class Tv : Device {
    override fun switchOn() {
        println("Switching on")
    }
    
    override fun switchOff() {
        println("Switching off")
    }
    
    override fun channelUp() {
        println("Channeling up")
    }
    
    override fun channelDown() {
        println("Channeling down")
    }
    
    override fun mute() {
        println("Mutting")
    }
}

class Radio : Device {
    override fun switchOn() {
        println("Switching on (Radio)")
    }
    
    override fun switchOff() {
        println("Switching off (Radio)")
    }
    
    override fun channelUp() {
        println("Channeling up (Radio)")
    }
    
    override fun channelDown() {
        println("Channeling down (Radio)")
    }
    
    override fun mute() {
        println("Mutting (Radio)")
    }
}


open class RemoteController(private val device: Device) {
    open fun switchOn() {
        device.switchOn()
    }
}

class RemoteControllerAdvanced(private val device: Device): RemoteController(device) {
    override fun switchOn() {
        device.switchOn()
    }
    
    fun mute() {
        device.mute()
    }
}

fun main() {
    val a = Tv()
    val b = RemoteController(a)
    
    val c = Radio()
    val d = RemoteControllerAdvanced(c)
    
    b.switchOn()
    d.mute()
    
    println("Hello world")
}

