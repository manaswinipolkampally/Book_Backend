// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/jyosna/Documents/dev/Booksplorer_Backend/conf/routes
// @DATE:Sat Mar 23 13:19:04 IST 2019


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
