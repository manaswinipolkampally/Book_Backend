package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import controllers.security.Authenticator;
import daos.ImageDao;
import daos.BookDao;
import models.Books;
import models.Image;
import models.User;
import models.Books;
import org.springframework.beans.factory.annotation.Autowired;
import play.Logger;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import daos.*;

import javax.inject.Inject;
import java.awt.print.Book;
import java.beans.Transient;
import java.util.Collection;
import java.util.Optional;

import static daos.BookDao.*;

public class BooksController extends Controller {

    private final static Logger.ALogger LOGGER = Logger.of(BooksController.class);


   private BookDao bookDao;
   private ImageDao imageDao;
   private UserDao userDao;

    @Inject
    public BooksController(BookDao bookDao, ImageDao imageDao, UserDao userDao) {
        this.bookDao = bookDao;
        this.imageDao = imageDao;
        this.userDao = userDao;
    }



    @Transactional
    @Authenticator
    public Result createBook() {

        final JsonNode json = request().body().asJson();

        final Books books = Json.fromJson(json, Books.class);

        final User user = (User) ctx().args.get("user");
        books.setUser(user);

        LOGGER.debug("Books title = " + books.getTitle());
        LOGGER.error("This is an error");

       /* if (null == books.getTitle()) {
            return badRequest("Title must be provided");
        }

        if (null == books.getAuthor()) {
            return badRequest(" Author must be provided");
        }

        if (null == books.getCategory()) {
            return badRequest(" Category must be provided");
        }

        if (null == books.getPrice()) {
            return badRequest(" Price must be provided");
        }

        if (null == books.getCount()) {
            return badRequest(" Copies count must be provided");
        }*/

        final Books newBook = bookDao.create(books);

        for (String url : books.getImageUrls()) {
            final Image image = new Image(url);
            image.setImageUrl(url);
            image.setBook(newBook);
            imageDao.create(image);

        }

        final JsonNode result = Json.toJson(newBook);
        return ok(result);
    }

    @Transactional
    public Result searchBooks() {

        final JsonNode json = request().body().asJson();
        final Books book = Json.fromJson(json,Books.class);


        final Collection<Books> newBook = bookDao.search(book);
        for(Books book_new: newBook){
            String[] image_strings = imageDao.searchByBookId(book_new.getId());
            Logger.debug("img collection is "+ image_strings);
            book_new.setImageUrls(image_strings);

        }


        final JsonNode result = Json.toJson(newBook);

        return ok(result);
    }

    @Transactional
    public Result getBookByCategory(String name) {
        if(null== name) {
            return badRequest("name must be provided");
        }

        final Collection<Books> books = bookDao.findBookByCategory(name);


        final JsonNode result = Json.toJson(books);

        return ok(result);
    }

    @Transactional
    public Result getBookByUser()
    {
        final JsonNode json= request().body().asJson();
        final String token= json.get("accessToken").asText();
        LOGGER.debug("token"+token);
        if(null==token)
           return badRequest("Missing Mandatory Parameter");
        final User user= userDao.findUserByAuthToken(token);
        final String username= user.getUsername();
        final Collection<Books> books= bookDao.findBookByUname(username);
        final JsonNode result=Json.toJson(books);
        return ok(result);

    }

    @Transactional
    public Result getBooksByUsername() {

        final JsonNode json = request().body().asJson();
        final Books books = Json.fromJson(json, Books.class);
        final String username = json.get("username").asText();
        Collection<Books> hotels = bookDao.searchByUsername(username);

//        for (Books b : books) {
//            Collection<Image> images = imageDao.getImageById(b.getId());
//            String[] arr = new String[images.size()];
//            arr = images.toArray(arr);
//            b.setImageUrls(arr);
//        }

        final JsonNode result = Json.toJson(books);
        return ok(result);

    }

    @Transactional
    public Result getBookById() {

        final JsonNode json = request().body().asJson();
        final Integer id= json.get("id").asInt();

        if (null == id) {
            return badRequest("Id must be provided");
        }



        final Optional<Books> book = bookDao.read(id);
        if (book.isPresent()) {
            final JsonNode result = Json.toJson(book.get());
            return ok(result);
        } else {
            return notFound();
        }

    }





    @Transactional
    public Result getBookById(Integer id) {

        if (null == id) {
            return badRequest("Id must be provided");
        }


        final Books books = bookDao.findBookById(id);

        final JsonNode result = Json.toJson(books);

        return ok(result);


        /*final Optional<Books> book = bookDao.read(id);
        if (book.isPresent()) {
            final JsonNode result = Json.toJson(book.get());
            return ok(result);
        } else {
            return notFound();
        }*/

    }


    @Transactional
    public Result updateBookById(Integer id) {

        if (null == id) {
            return badRequest("Id must be provided");
        }

        final JsonNode json = request().body().asJson();
        final Books newBooks = Json.fromJson(json, Books.class);

        newBooks.setId(id);

        final Books updatedBooks = bookDao.update(newBooks);

        final JsonNode result = Json.toJson(updatedBooks);
        return ok(result);
    }


    @Transactional
    public Result updateBookCountById(Integer id) {

        if (null == id) {
            return badRequest("Id must be provided");
        }

        final JsonNode json = request().body().asJson();
        final Books newBooks = Json.fromJson(json, Books.class);

        newBooks.setId(id);

        final Books updatedBooks = bookDao.updateCount(newBooks);

        final JsonNode result = Json.toJson(updatedBooks);
        return ok(result);
    }


    @Transactional
    public Result deleteBookById(Integer id) {

        if (null == id) {
            return badRequest("Id must be provided");
        }

        final Books books = bookDao.findBookById(id);



        Logger.debug("count="+ books.getCount());
        if(1!=books.getCount()){
            bookDao.updateCount(books);
        }
        else {


            bookDao.delete(id);

            for (String url : books.getImageUrls())
                imageDao.delete(url);
        }

        final JsonNode result = Json.toJson(books);
        return ok(result);
    }

    @Transactional
    public Result getAllBooks() {

        Collection<Books> books = bookDao.all();

        final JsonNode result = Json.toJson(books);
        return ok(result);
    }

}