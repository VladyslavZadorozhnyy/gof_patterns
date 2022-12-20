// This class will hold inner state, AKA non-changeable
// fields 
class TreeType(
    private val name: String,
    private val color: String,
    private val texture: String,
) {
    fun draw(x: Int, y: Int, canvas: String) {
        println("Drawing on following canvas: $canvas")
    }
    
    fun equalType(name: String, color: String, texture: String): Boolean {
        return this.name == name && this.color == color && this.texture == texture
    }
}

// This class will hold outer state, AKA changeable
// fields 
class Tree(
  private val x: Int,
  private val y: Int,
  private val type: TreeType,
) {
    fun draw(c: String) {
        type.draw(x, y, c)
    }
}

// This class will contain inner state examples 
class TreeFactory() {
    companion object {
        private val treeTypes: MutableList<TreeType> = mutableListOf()
        
        fun getType(
          name: String,
        color: String,
        texture: String,
        ): TreeType {
            var result = treeTypes.firstOrNull { it.equalType(name, color, texture) }
            
            if (result == null) {
                val newType = TreeType(name, color, texture)
                treeTypes.add(newType)
            }
            
            return treeTypes.firstOrNull { it.equalType(name, color, texture) }!!
        }
        
        fun getTypesLength(): Int {
            return treeTypes.size
        }
    }
}

fun main() {
//     TreeFactory.getType("g", "g", "g")
    val a = Tree(1, 1, TreeFactory.getType("g", "g", "g"))
    val b = Tree(1, 2, TreeFactory.getType("g", "g", "g"))

    println("Hello world: ${TreeFactory.getTypesLength()}") // Equal to 1 as we reuse same TreeType
}
