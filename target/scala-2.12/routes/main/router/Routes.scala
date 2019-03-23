// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/jyosna/Documents/dev/Booksplorer_Backend/conf/routes
// @DATE:Sat Mar 23 13:19:04 IST 2019

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  ImagesController_7: controllers.ImagesController,
  // @LINE:12
  UsersController_1: controllers.UsersController,
  // @LINE:20
  HelloWorldController_5: controllers.HelloWorldController,
  // @LINE:29
  BooksController_3: controllers.BooksController,
  // @LINE:42
  HomeController_2: controllers.HomeController,
  // @LINE:44
  CountController_0: controllers.CountController,
  // @LINE:46
  AsyncController_4: controllers.AsyncController,
  // @LINE:49
  Assets_6: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    ImagesController_7: controllers.ImagesController,
    // @LINE:12
    UsersController_1: controllers.UsersController,
    // @LINE:20
    HelloWorldController_5: controllers.HelloWorldController,
    // @LINE:29
    BooksController_3: controllers.BooksController,
    // @LINE:42
    HomeController_2: controllers.HomeController,
    // @LINE:44
    CountController_0: controllers.CountController,
    // @LINE:46
    AsyncController_4: controllers.AsyncController,
    // @LINE:49
    Assets_6: controllers.Assets
  ) = this(errorHandler, ImagesController_7, UsersController_1, HelloWorldController_5, BooksController_3, HomeController_2, CountController_0, AsyncController_4, Assets_6, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, ImagesController_7, UsersController_1, HelloWorldController_5, BooksController_3, HomeController_2, CountController_0, AsyncController_4, Assets_6, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """images""", """controllers.ImagesController.uploadImage()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """images/""" + "$" + """id<[^/]+>""", """controllers.ImagesController.downloadImage(id:String)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """images/""" + "$" + """id<[^/]+>""", """controllers.ImagesController.deleteImage(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """images/book/""" + "$" + """id<[^/]+>""", """controllers.ImagesController.getImagesByBookId(id:Integer)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users""", """controllers.UsersController.getAllUsers()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users""", """controllers.UsersController.registerUser()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users/me""", """controllers.UsersController.getCurrentUser()"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users/login""", """controllers.UsersController.signInUser()"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users/signout""", """controllers.UsersController.signOutUser()"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users/update""", """controllers.UsersController.updateUser()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """helloWorld""", """controllers.HelloWorldController.helloWorld()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """hello/Mattias""", """controllers.HelloWorldController.helloMattias()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """hello/""" + "$" + """name<[^/]+>""", """controllers.HelloWorldController.hello(name:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """hellos/""" + "$" + """name<[^/]+>""", """controllers.HelloWorldController.hellos(name:String, count:Integer)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """hellos/""" + "$" + """name<[^/]+>""", """controllers.HelloWorldController.hellos(name:String, count:Integer ?= null)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """hellos/""" + "$" + """name<[^/]+>""", """controllers.HelloWorldController.hellos(name:String, count:Integer ?= 2)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """greetings""", """controllers.HelloWorldController.greetings()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """me""", """controllers.HelloWorldController.me()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """books""", """controllers.BooksController.createBook()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """books/token""", """controllers.BooksController.getBookByUser()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """books/search""", """controllers.BooksController.searchBooks()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """books/category""", """controllers.BooksController.getBookByCategory(name:String)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """books""", """controllers.BooksController.getBookById()"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """books/""" + "$" + """id<[^/]+>""", """controllers.BooksController.updateBookById(id:Integer)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """books/""" + "$" + """id<[^/]+>""", """controllers.BooksController.deleteBookById(id:Integer)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """books""", """controllers.BooksController.getAllBooks()"""),
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """count""", """controllers.CountController.count"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """message""", """controllers.AsyncController.message"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_ImagesController_uploadImage0_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("images")))
  )
  private[this] lazy val controllers_ImagesController_uploadImage0_invoker = createInvoker(
    ImagesController_7.uploadImage(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ImagesController",
      "uploadImage",
      Nil,
      "POST",
      this.prefix + """images""",
      """""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_ImagesController_downloadImage1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("images/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ImagesController_downloadImage1_invoker = createInvoker(
    ImagesController_7.downloadImage(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ImagesController",
      "downloadImage",
      Seq(classOf[String]),
      "GET",
      this.prefix + """images/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_ImagesController_deleteImage2_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("images/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ImagesController_deleteImage2_invoker = createInvoker(
    ImagesController_7.deleteImage(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ImagesController",
      "deleteImage",
      Seq(classOf[String]),
      "DELETE",
      this.prefix + """images/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_ImagesController_getImagesByBookId3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("images/book/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ImagesController_getImagesByBookId3_invoker = createInvoker(
    ImagesController_7.getImagesByBookId(fakeValue[Integer]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ImagesController",
      "getImagesByBookId",
      Seq(classOf[Integer]),
      "GET",
      this.prefix + """images/book/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_UsersController_getAllUsers4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users")))
  )
  private[this] lazy val controllers_UsersController_getAllUsers4_invoker = createInvoker(
    UsersController_1.getAllUsers(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UsersController",
      "getAllUsers",
      Nil,
      "GET",
      this.prefix + """users""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_UsersController_registerUser5_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users")))
  )
  private[this] lazy val controllers_UsersController_registerUser5_invoker = createInvoker(
    UsersController_1.registerUser(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UsersController",
      "registerUser",
      Nil,
      "POST",
      this.prefix + """users""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_UsersController_getCurrentUser6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users/me")))
  )
  private[this] lazy val controllers_UsersController_getCurrentUser6_invoker = createInvoker(
    UsersController_1.getCurrentUser(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UsersController",
      "getCurrentUser",
      Nil,
      "GET",
      this.prefix + """users/me""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_UsersController_signInUser7_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users/login")))
  )
  private[this] lazy val controllers_UsersController_signInUser7_invoker = createInvoker(
    UsersController_1.signInUser(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UsersController",
      "signInUser",
      Nil,
      "PUT",
      this.prefix + """users/login""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_UsersController_signOutUser8_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users/signout")))
  )
  private[this] lazy val controllers_UsersController_signOutUser8_invoker = createInvoker(
    UsersController_1.signOutUser(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UsersController",
      "signOutUser",
      Nil,
      "PUT",
      this.prefix + """users/signout""",
      """""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_UsersController_updateUser9_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users/update")))
  )
  private[this] lazy val controllers_UsersController_updateUser9_invoker = createInvoker(
    UsersController_1.updateUser(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UsersController",
      "updateUser",
      Nil,
      "PUT",
      this.prefix + """users/update""",
      """""",
      Seq()
    )
  )

  // @LINE:20
  private[this] lazy val controllers_HelloWorldController_helloWorld10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("helloWorld")))
  )
  private[this] lazy val controllers_HelloWorldController_helloWorld10_invoker = createInvoker(
    HelloWorldController_5.helloWorld(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HelloWorldController",
      "helloWorld",
      Nil,
      "GET",
      this.prefix + """helloWorld""",
      """""",
      Seq()
    )
  )

  // @LINE:21
  private[this] lazy val controllers_HelloWorldController_helloMattias11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("hello/Mattias")))
  )
  private[this] lazy val controllers_HelloWorldController_helloMattias11_invoker = createInvoker(
    HelloWorldController_5.helloMattias(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HelloWorldController",
      "helloMattias",
      Nil,
      "GET",
      this.prefix + """hello/Mattias""",
      """""",
      Seq()
    )
  )

  // @LINE:22
  private[this] lazy val controllers_HelloWorldController_hello12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("hello/"), DynamicPart("name", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HelloWorldController_hello12_invoker = createInvoker(
    HelloWorldController_5.hello(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HelloWorldController",
      "hello",
      Seq(classOf[String]),
      "GET",
      this.prefix + """hello/""" + "$" + """name<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:23
  private[this] lazy val controllers_HelloWorldController_hellos13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("hellos/"), DynamicPart("name", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HelloWorldController_hellos13_invoker = createInvoker(
    HelloWorldController_5.hellos(fakeValue[String], fakeValue[Integer]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HelloWorldController",
      "hellos",
      Seq(classOf[String], classOf[Integer]),
      "GET",
      this.prefix + """hellos/""" + "$" + """name<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:24
  private[this] lazy val controllers_HelloWorldController_hellos14_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("hellos/"), DynamicPart("name", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HelloWorldController_hellos14_invoker = createInvoker(
    HelloWorldController_5.hellos(fakeValue[String], fakeValue[Integer]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HelloWorldController",
      "hellos",
      Seq(classOf[String], classOf[Integer]),
      "GET",
      this.prefix + """hellos/""" + "$" + """name<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:25
  private[this] lazy val controllers_HelloWorldController_hellos15_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("hellos/"), DynamicPart("name", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HelloWorldController_hellos15_invoker = createInvoker(
    HelloWorldController_5.hellos(fakeValue[String], fakeValue[Integer]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HelloWorldController",
      "hellos",
      Seq(classOf[String], classOf[Integer]),
      "GET",
      this.prefix + """hellos/""" + "$" + """name<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:26
  private[this] lazy val controllers_HelloWorldController_greetings16_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("greetings")))
  )
  private[this] lazy val controllers_HelloWorldController_greetings16_invoker = createInvoker(
    HelloWorldController_5.greetings(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HelloWorldController",
      "greetings",
      Nil,
      "POST",
      this.prefix + """greetings""",
      """""",
      Seq()
    )
  )

  // @LINE:27
  private[this] lazy val controllers_HelloWorldController_me17_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("me")))
  )
  private[this] lazy val controllers_HelloWorldController_me17_invoker = createInvoker(
    HelloWorldController_5.me(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HelloWorldController",
      "me",
      Nil,
      "GET",
      this.prefix + """me""",
      """""",
      Seq()
    )
  )

  // @LINE:29
  private[this] lazy val controllers_BooksController_createBook18_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("books")))
  )
  private[this] lazy val controllers_BooksController_createBook18_invoker = createInvoker(
    BooksController_3.createBook(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.BooksController",
      "createBook",
      Nil,
      "POST",
      this.prefix + """books""",
      """""",
      Seq()
    )
  )

  // @LINE:30
  private[this] lazy val controllers_BooksController_getBookByUser19_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("books/token")))
  )
  private[this] lazy val controllers_BooksController_getBookByUser19_invoker = createInvoker(
    BooksController_3.getBookByUser(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.BooksController",
      "getBookByUser",
      Nil,
      "GET",
      this.prefix + """books/token""",
      """""",
      Seq()
    )
  )

  // @LINE:31
  private[this] lazy val controllers_BooksController_searchBooks20_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("books/search")))
  )
  private[this] lazy val controllers_BooksController_searchBooks20_invoker = createInvoker(
    BooksController_3.searchBooks(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.BooksController",
      "searchBooks",
      Nil,
      "POST",
      this.prefix + """books/search""",
      """""",
      Seq()
    )
  )

  // @LINE:32
  private[this] lazy val controllers_BooksController_getBookByCategory21_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("books/category")))
  )
  private[this] lazy val controllers_BooksController_getBookByCategory21_invoker = createInvoker(
    BooksController_3.getBookByCategory(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.BooksController",
      "getBookByCategory",
      Seq(classOf[String]),
      "GET",
      this.prefix + """books/category""",
      """""",
      Seq()
    )
  )

  // @LINE:34
  private[this] lazy val controllers_BooksController_getBookById22_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("books")))
  )
  private[this] lazy val controllers_BooksController_getBookById22_invoker = createInvoker(
    BooksController_3.getBookById(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.BooksController",
      "getBookById",
      Nil,
      "PUT",
      this.prefix + """books""",
      """ GET  /books/:id          controllers.BooksController.getBookById(id: Integer)""",
      Seq()
    )
  )

  // @LINE:35
  private[this] lazy val controllers_BooksController_updateBookById23_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("books/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_BooksController_updateBookById23_invoker = createInvoker(
    BooksController_3.updateBookById(fakeValue[Integer]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.BooksController",
      "updateBookById",
      Seq(classOf[Integer]),
      "PUT",
      this.prefix + """books/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:36
  private[this] lazy val controllers_BooksController_deleteBookById24_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("books/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_BooksController_deleteBookById24_invoker = createInvoker(
    BooksController_3.deleteBookById(fakeValue[Integer]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.BooksController",
      "deleteBookById",
      Seq(classOf[Integer]),
      "DELETE",
      this.prefix + """books/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:37
  private[this] lazy val controllers_BooksController_getAllBooks25_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("books")))
  )
  private[this] lazy val controllers_BooksController_getAllBooks25_invoker = createInvoker(
    BooksController_3.getAllBooks(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.BooksController",
      "getAllBooks",
      Nil,
      "GET",
      this.prefix + """books""",
      """""",
      Seq()
    )
  )

  // @LINE:42
  private[this] lazy val controllers_HomeController_index26_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index26_invoker = createInvoker(
    HomeController_2.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:44
  private[this] lazy val controllers_CountController_count27_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("count")))
  )
  private[this] lazy val controllers_CountController_count27_invoker = createInvoker(
    CountController_0.count,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CountController",
      "count",
      Nil,
      "GET",
      this.prefix + """count""",
      """ An example controller showing how to use dependency injection""",
      Seq()
    )
  )

  // @LINE:46
  private[this] lazy val controllers_AsyncController_message28_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("message")))
  )
  private[this] lazy val controllers_AsyncController_message28_invoker = createInvoker(
    AsyncController_4.message,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AsyncController",
      "message",
      Nil,
      "GET",
      this.prefix + """message""",
      """ An example controller showing how to write asynchronous code""",
      Seq()
    )
  )

  // @LINE:49
  private[this] lazy val controllers_Assets_versioned29_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned29_invoker = createInvoker(
    Assets_6.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_ImagesController_uploadImage0_route(params@_) =>
      call { 
        controllers_ImagesController_uploadImage0_invoker.call(ImagesController_7.uploadImage())
      }
  
    // @LINE:7
    case controllers_ImagesController_downloadImage1_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_ImagesController_downloadImage1_invoker.call(ImagesController_7.downloadImage(id))
      }
  
    // @LINE:8
    case controllers_ImagesController_deleteImage2_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_ImagesController_deleteImage2_invoker.call(ImagesController_7.deleteImage(id))
      }
  
    // @LINE:9
    case controllers_ImagesController_getImagesByBookId3_route(params@_) =>
      call(params.fromPath[Integer]("id", None)) { (id) =>
        controllers_ImagesController_getImagesByBookId3_invoker.call(ImagesController_7.getImagesByBookId(id))
      }
  
    // @LINE:12
    case controllers_UsersController_getAllUsers4_route(params@_) =>
      call { 
        controllers_UsersController_getAllUsers4_invoker.call(UsersController_1.getAllUsers())
      }
  
    // @LINE:13
    case controllers_UsersController_registerUser5_route(params@_) =>
      call { 
        controllers_UsersController_registerUser5_invoker.call(UsersController_1.registerUser())
      }
  
    // @LINE:14
    case controllers_UsersController_getCurrentUser6_route(params@_) =>
      call { 
        controllers_UsersController_getCurrentUser6_invoker.call(UsersController_1.getCurrentUser())
      }
  
    // @LINE:15
    case controllers_UsersController_signInUser7_route(params@_) =>
      call { 
        controllers_UsersController_signInUser7_invoker.call(UsersController_1.signInUser())
      }
  
    // @LINE:16
    case controllers_UsersController_signOutUser8_route(params@_) =>
      call { 
        controllers_UsersController_signOutUser8_invoker.call(UsersController_1.signOutUser())
      }
  
    // @LINE:17
    case controllers_UsersController_updateUser9_route(params@_) =>
      call { 
        controllers_UsersController_updateUser9_invoker.call(UsersController_1.updateUser())
      }
  
    // @LINE:20
    case controllers_HelloWorldController_helloWorld10_route(params@_) =>
      call { 
        controllers_HelloWorldController_helloWorld10_invoker.call(HelloWorldController_5.helloWorld())
      }
  
    // @LINE:21
    case controllers_HelloWorldController_helloMattias11_route(params@_) =>
      call { 
        controllers_HelloWorldController_helloMattias11_invoker.call(HelloWorldController_5.helloMattias())
      }
  
    // @LINE:22
    case controllers_HelloWorldController_hello12_route(params@_) =>
      call(params.fromPath[String]("name", None)) { (name) =>
        controllers_HelloWorldController_hello12_invoker.call(HelloWorldController_5.hello(name))
      }
  
    // @LINE:23
    case controllers_HelloWorldController_hellos13_route(params@_) =>
      call(params.fromPath[String]("name", None), params.fromQuery[Integer]("count", None)) { (name, count) =>
        controllers_HelloWorldController_hellos13_invoker.call(HelloWorldController_5.hellos(name, count))
      }
  
    // @LINE:24
    case controllers_HelloWorldController_hellos14_route(params@_) =>
      call(params.fromPath[String]("name", None), params.fromQuery[Integer]("count", Some(null))) { (name, count) =>
        controllers_HelloWorldController_hellos14_invoker.call(HelloWorldController_5.hellos(name, count))
      }
  
    // @LINE:25
    case controllers_HelloWorldController_hellos15_route(params@_) =>
      call(params.fromPath[String]("name", None), params.fromQuery[Integer]("count", Some(2))) { (name, count) =>
        controllers_HelloWorldController_hellos15_invoker.call(HelloWorldController_5.hellos(name, count))
      }
  
    // @LINE:26
    case controllers_HelloWorldController_greetings16_route(params@_) =>
      call { 
        controllers_HelloWorldController_greetings16_invoker.call(HelloWorldController_5.greetings())
      }
  
    // @LINE:27
    case controllers_HelloWorldController_me17_route(params@_) =>
      call { 
        controllers_HelloWorldController_me17_invoker.call(HelloWorldController_5.me())
      }
  
    // @LINE:29
    case controllers_BooksController_createBook18_route(params@_) =>
      call { 
        controllers_BooksController_createBook18_invoker.call(BooksController_3.createBook())
      }
  
    // @LINE:30
    case controllers_BooksController_getBookByUser19_route(params@_) =>
      call { 
        controllers_BooksController_getBookByUser19_invoker.call(BooksController_3.getBookByUser())
      }
  
    // @LINE:31
    case controllers_BooksController_searchBooks20_route(params@_) =>
      call { 
        controllers_BooksController_searchBooks20_invoker.call(BooksController_3.searchBooks())
      }
  
    // @LINE:32
    case controllers_BooksController_getBookByCategory21_route(params@_) =>
      call(params.fromQuery[String]("name", None)) { (name) =>
        controllers_BooksController_getBookByCategory21_invoker.call(BooksController_3.getBookByCategory(name))
      }
  
    // @LINE:34
    case controllers_BooksController_getBookById22_route(params@_) =>
      call { 
        controllers_BooksController_getBookById22_invoker.call(BooksController_3.getBookById())
      }
  
    // @LINE:35
    case controllers_BooksController_updateBookById23_route(params@_) =>
      call(params.fromPath[Integer]("id", None)) { (id) =>
        controllers_BooksController_updateBookById23_invoker.call(BooksController_3.updateBookById(id))
      }
  
    // @LINE:36
    case controllers_BooksController_deleteBookById24_route(params@_) =>
      call(params.fromPath[Integer]("id", None)) { (id) =>
        controllers_BooksController_deleteBookById24_invoker.call(BooksController_3.deleteBookById(id))
      }
  
    // @LINE:37
    case controllers_BooksController_getAllBooks25_route(params@_) =>
      call { 
        controllers_BooksController_getAllBooks25_invoker.call(BooksController_3.getAllBooks())
      }
  
    // @LINE:42
    case controllers_HomeController_index26_route(params@_) =>
      call { 
        controllers_HomeController_index26_invoker.call(HomeController_2.index)
      }
  
    // @LINE:44
    case controllers_CountController_count27_route(params@_) =>
      call { 
        controllers_CountController_count27_invoker.call(CountController_0.count)
      }
  
    // @LINE:46
    case controllers_AsyncController_message28_route(params@_) =>
      call { 
        controllers_AsyncController_message28_invoker.call(AsyncController_4.message)
      }
  
    // @LINE:49
    case controllers_Assets_versioned29_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned29_invoker.call(Assets_6.versioned(path, file))
      }
  }
}
