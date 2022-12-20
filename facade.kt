class VideoFile {
//     Some standard functionality
}

class OggCompressionCodec {
//     Some standard functionality
}

class MPEG4CompressionCodec {
//     Some standard functionality
}

class CodecFactory {
//     Some standard functionality
}

class BitrateReader {
//     Some standard functionality
}

class AudioMixer {
//     Some standard functionality
}


// This class is a facade class, which makes functionality 
// usage easier. This class will be used by the user.
class VideoConverter {
    fun convert(filename: String, format: String): File {
        val resultFile = VideoFile(filename)
        val sourceCodec = CodecFactory.extract(resultFile)
        
        val destinationCodec = if (format == "mp4") {
            MPEG4CompressionCodec()
        } else {
            OggCompressionCodec()
        }
        
        val buffer = BitrateReader.read(filename, sourceCodec)
        var result = BitrateReader.convert(buffer, destinationCodec)
        result = AudioMixer().fix(result)
        
        return File(result)
    }
}

// Example of the pattern usage by a client
class Application() {
    fun main() {
        val convertor = VideoConvertor()
        val oggFile = convertor.convert("sample_video_name.mp4", "ogg")
        oggFile.save()
    }
}
