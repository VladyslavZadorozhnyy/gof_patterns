class TreeNode() {}

class TreeCollection() {
//     Some logic here

    fun getIteratorWidth(): Iterator<TreeNode> {
        return IteratorWidth(this)
    }
    
    fun getIteratorDepth(): Iterator<TreeNode> {
        return IteratorDepth(this)
    }
}

interface Iterator<T> {
    fun hasNext(): Boolean
    
    fun getNext(): T
}

class IteratorDepth(private val collection: TreeCollection): Iterator<TreeNode> {
    override fun hasNext(): Boolean {
//         Some logic here with iteration in Depth
        return false
    }
    
    override fun getNext(): TreeNode {
//         Some logic here with iteration in Depth
        return TreeNode()
    }
}

class IteratorWidth(private val collection: TreeCollection): Iterator<TreeNode> {
        override fun hasNext(): Boolean {
//         Some logic here with iteration in Width
        return false
    }
    
    override fun getNext(): TreeNode {
//         Some logic here with iteration in Width
        return TreeNode()
    }
}


fun main() {
    println("Hello world")
}
