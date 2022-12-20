interface YouTubeLibClass {
    fun listVideos() {}
    fun getVideoInfo(id: Int) {}
    fun downloadVideo(id: Int) {}
}


// This class is part of library functionality and
// cannot be modified by the user
class YouTubeLibImpl() : YouTubeLibClass {
    override fun listVideos() {
//         Some logic here
    }
    
    override fun getVideoInfo(id: Int) {
//         Some logic here
    }
        
    override fun downloadVideo(id: Int) {
//         Some logic here
    }
}


// This is a proxy class, which makes caching processes work
// by using as aggregation YouTubeLibImpl object
class YouTubeLibProxy(private val service: YouTubeLibClass) : YouTubeLibClass {
    private val videoCache: Any?
    private val listCache: Any?
    private var shouldReset = false
    
    override fun listVideos() {
    if (listCache == null  shouldReset) {
            listCache = service.listVideos()
        }
        return listCache
    }
    
    override fun getVideoInfo(id: Int) {
    if (videoCache == null  shouldReset) {
            videoCache = service.getVideoInfo(id)
        }
        return videoCache
    }
        
    override fun downloadVideo(id: Int) {
    if (!downloadExists(id) || shouldReset) {
            service.dowloadVideo(id)
        }
    }
}


class YouTubeManager(protected var service: YouTubeLibClass) {
    fun renderVideoPage(id: Int) {
        service.getVideoInfo()
    }
    
    fun renderListPanel() {
        service.listVideos()
    }
    
    fun reactOnUserInput() {
        renderVideoPage()
        renderListPanel()
    }
}


fun main() {
  val youTubeLibImpl = YouTubeLibImpl()
    val youTubeProxy = YouTubeProxy(youTubeLibImpl)
    
    val youTubeManager = YouTubeManager(youTubeProxy)
  youTubeManager.reactOnUserInput()
    
    println("Hello world")
}
