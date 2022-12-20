interface DataSource {
    fun writeData(datta: String)
    fun readData(): String
}


class FileDataSource(private val fileName: String) : DataSource {
    override fun writeData(datta: String) {
//         Extend write method to write to fileName
        println("Write in file")
    }
    
    override fun readData(): String {
//         Extend read method to read from fileName
        println("Read from file")
        return ""
    }
}


// Basic decorator
open class DataSourceDecorator(protected val wrapee: DataSource) : DataSource {
    override fun writeData(datta: String) {
        println("Writing data")
        wrapee.writeData(datta)
    }
    
    override fun readData(): String {
        println("Reading data")
        return wrapee.readData()
    }
}


// Decorator implementation
class EncryptionDecorator(source: DataSource) : DataSourceDecorator(source) {    
    override fun writeData(datta: String) {
        println("Encrypting data to write")
        wrapee.writeData(datta)
    }
    
    override fun readData(): String {
        println("Encrypting data to read")
        return wrapee.readData()
    }
}

// Decorator implementation
class CompressionDecorator(source: DataSource) : DataSourceDecorator(source) {
    override fun writeData(datta: String) {
        println("Compressing data to write")
        wrapee.writeData(datta)
    }
    
    override fun readData(): String {
        println("Compressing data to read")
        return wrapee.readData()
    }
}


fun main() {
    val a = FileDataSource("example.txt")
    val b = DataSourceDecorator(a)
    val c = EncryptionDecorator(b)
    val d = CompressionDecorator(c)
    
    d.writeData("Data sample")
    println("Hello world")
}
