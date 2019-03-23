// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/jyosna/Documents/dev/Booksplorer_Backend/conf/routes
// @DATE:Sat Mar 23 13:19:04 IST 2019

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:49
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:49
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:44
  class ReverseCountController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:44
    def count(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "count")
    }
  
  }

  // @LINE:12
  class ReverseUsersController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def getCurrentUser(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "users/me")
    }
  
    // @LINE:17
    def updateUser(): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "users/update")
    }
  
    // @LINE:15
    def signInUser(): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "users/login")
    }
  
    // @LINE:13
    def registerUser(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "users")
    }
  
    // @LINE:16
    def signOutUser(): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "users/signout")
    }
  
    // @LINE:12
    def getAllUsers(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "users")
    }
  
  }

  // @LINE:20
  class ReverseHelloWorldController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:22
    def hello(name:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "hello/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("name", name)))
    }
  
    // @LINE:27
    def me(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "me")
    }
  
    // @LINE:23
    def hellos(name:String, count:Integer): Call = {
    
      (name: @unchecked, count: @unchecked) match {
      
        // @LINE:23
        case (name, count)  =>
          
          Call("GET", _prefix + { _defaultPrefix } + "hellos/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("name", name)) + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[Integer]].unbind("count", count)))))
      
      }
    
    }
  
    // @LINE:21
    def helloMattias(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "hello/Mattias")
    }
  
    // @LINE:20
    def helloWorld(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "helloWorld")
    }
  
    // @LINE:26
    def greetings(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "greetings")
    }
  
  }

  // @LINE:29
  class ReverseBooksController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:36
    def deleteBookById(id:Integer): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "books/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Integer]].unbind("id", id)))
    }
  
    // @LINE:37
    def getAllBooks(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "books")
    }
  
    // @LINE:35
    def updateBookById(id:Integer): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "books/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Integer]].unbind("id", id)))
    }
  
    // @LINE:29
    def createBook(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "books")
    }
  
    // @LINE:31
    def searchBooks(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "books/search")
    }
  
    // @LINE:30
    def getBookByUser(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "books/token")
    }
  
    // @LINE:34
    def getBookById(): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "books")
    }
  
    // @LINE:32
    def getBookByCategory(name:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "books/category" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("name", name)))))
    }
  
  }

  // @LINE:42
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:42
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:46
  class ReverseAsyncController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:46
    def message(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "message")
    }
  
  }

  // @LINE:6
  class ReverseImagesController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def downloadImage(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "images/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:9
    def getImagesByBookId(id:Integer): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "images/book/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Integer]].unbind("id", id)))
    }
  
    // @LINE:8
    def deleteImage(id:String): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "images/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:6
    def uploadImage(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "images")
    }
  
  }


}
