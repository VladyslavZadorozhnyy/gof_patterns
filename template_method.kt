abstract class ProcessFileAlgorithm() {
    fun execute() {
        openFile()
        extractData()
        parseRawData()
        writeData()
    }
    
    fun openFile(fileName: String) {
//         Some logic here
    }
    
    abstract fun extractData(fileobj: FileObject) {
//         Here will be logic for specificly typed file
    }
    
    abstract fun parseRawData(rawData: BytesRange) {
//         Here will be logic for specificly typed file
    }
    
    fun processData() {
//         Some logic here
    }
    
    fun writeData(newFileName: String, dataObj: DataObject) {
//         Some logic here
    }
}

class ProcessPdfAlgorithm() : ProcessFileAlgorithm() {
    override fun extractData() {
//         Some logic here
    }
    
    override fun parseRawData() {
//         Some logic here
    }
}

class ProcessDocAlgorithm() : ProcessFileAlgorithm() {
    override fun extractData() {
//         Some logic here
    }
    
    override fun parseRawData() {
//         Some logic here
    }
}

class ProcessXlsxAlgorithm() : ProcessFileAlgorithm() {
    override fun extractData() {
//         Some logic here
    }
    
    override fun parseRawData() {
//         Some logic here
    }
}


fun main() {
   println("Hello world")
}
