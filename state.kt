class Player(
  private var state: State
) {
    private var currentSong: String = ""
    private var volume: Int = 0
    private var playlist: MutableList<String> = mutableListOf()
    
    fun changeState(newState: State) {
        state = newState
    }
    
//     Here we delegate some functionality to states
//     instead of multiple 'if ... else' expressions
    fun clickLock() {
        state.clickLock()
    }
    
    fun clickPlay() {
        state.clickPlay()
    }
    
    fun clickNext() {
        state.clickNext()
    }
    
    fun clickPrevious() {
        state.clickPrevious()
    }
    
//     Some logic does not need states and, thus, no need
//     to use states for these operations
    fun startPlayback() {
//       Some logic here  
    }
    
    fun stopPlayback() {
//       Some logic here
    }
    
  fun nextSong() {
//       Some logic here
    }
    
  fun previousSong() {
//       Some logic here
    }
    
    fun fastForward() {
//       Some logic here       
    }
    
  fun rewind() {
//       Some logic here       
    }
}

abstract class State(
//     State has object of context and, thus,
//     can affect it as well
    private val player: Player
) {
   abstract fun clickLock() {}
   
   abstract fun clickPlay() {}
   
   abstract fun clickNext() {}
   
   abstract fun clickPrevious() {}
}


class ReadyState(private val player: Player) : State(player) {
//     Overriden methods and logic
}


class PlayingState(private val player: Player) : State(player) {
//     Overriden methods and logic
}


class LockedState(private val player: Player) : State(player) {
//     Overriden methods and logic
}


fun main() {
   println("Hello world")
}
