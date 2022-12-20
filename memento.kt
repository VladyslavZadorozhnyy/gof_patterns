interface Memento {
    fun getName()
    fun getSnapshotDate()
}

class Snapshot(
    private val editor: Editor,
    private val text: String?,
    private val positionX: Int?,
    private val positionY: Int?
) : Memento {
    override fun getName() {
//         Some logic here
    }
    
    override fun getSnapshotDate() {
//         Some logic here
    }
    
    fun restore() {
        editor.setText(this.text)
        editor.setPositionX(this.positionX)
        editor.setPositionY(this.positionY)
    }
}

class Editor() {
    private var text: String? = null
    private var positionX: Int? = null
    private var positionY: Int? = null
    
    fun setText(value: String?) {
        text = value
    }
    
//     This is just a demo function and is redundant in this example
    fun getText(): String? {
        return text
    }
    
    fun setPositionX(value: Int?) {
        positionX = value
    }
    
    fun setPositionY(value: Int?) {
        positionY = value
    }
    
    fun makeSnapshot(): Snapshot {
        val currentState = Snapshot(this, text, positionX, positionY)
        return currentState
    }
    
    fun restoreSnapshot(s: Snapshot) {
        s.restore()
    }
}

fun main() {
    val editor = Editor()
    editor.setText("First line")
    
    val snapshot = editor.makeSnapshot()
    editor.setText("Second line")
    
    println("Current text: ${editor.getText()}")
    snapshot.restore()
    println("Restored text: ${editor.getText()}")
    
    println("Hello world")
}
