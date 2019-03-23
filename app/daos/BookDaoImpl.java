package daos;

import models.Books;

import play.Logger;
import play.db.jpa.JPAApi;

import javax.inject.Inject;
import javax.persistence.TypedQuery;
import javax.persistence.NoResultException;
import java.awt.print.Book;
import java.util.List;
import java.util.Collection;
import java.util.Optional;

public class BookDaoImpl implements BookDao {

    final JPAApi jpaApi;

    @Inject
    public BookDaoImpl(JPAApi jpaapi) {
        this.jpaApi = jpaapi;
    }

    public Books create(Books books) {

        if(null == books) {
            throw new IllegalArgumentException("Books must be provided");
        }

        jpaApi.em().persist(books);
        return books;
    }

    public Optional<Books> read(Integer id) {

        if (null == id) {
            throw new IllegalArgumentException("Id must be provided");
        }

        final Books books = jpaApi.em().find(Books.class, id);
        return books != null ? Optional.of(books) : Optional.empty();


    }

    public Books update(Books books) {

        if (null == books) {
            throw new IllegalArgumentException("Books must be provided");
        }

        if (null == books.getId()) {
            throw new IllegalArgumentException("Books id must be provided");
        }

        final Books existingBooks = jpaApi.em().find(Books.class, books.getId());
        if (null == existingBooks) {
            return null;
        }

        //existingBooks.setTitle(books.getTitle());
        //existingBooks.setAuthor(books.getAuthor());
        existingBooks.setPrice(books.getPrice());
        existingBooks.setCount(books.getCount());


        jpaApi.em().persist(existingBooks);

        return existingBooks;

    }

    public Books updateCount(Books books) {

        if (null == books) {
            throw new IllegalArgumentException("Books must be provided");
        }

        if (null == books.getId()) {
            throw new IllegalArgumentException("Books id must be provided");
        }

        final Books existingBooks = jpaApi.em().find(Books.class, books.getId());
        if (null == existingBooks) {
            return null;
        }


        existingBooks.setCount(books.getCount()-1);


        jpaApi.em().persist(existingBooks);

        return existingBooks;

    }

    public Books delete(Integer id) {

        if (null == id) {
            throw new IllegalArgumentException("Books id must be provided");
        }

        final Books existingBooks = jpaApi.em().find(Books.class, id);
        if (null == existingBooks) {
            return null;
        }
         jpaApi.em().remove(existingBooks);


        return existingBooks;
    }


    public Collection<Books> all(){

        TypedQuery<Books> query = jpaApi.em().createQuery("SELECT b FROM Books b", Books.class);
        List<Books> books = query.getResultList();

        return books;



        }


    @Override
    public Collection<Books> search(Books book) {
       List<Books> books = null;

       StringBuilder sb = new StringBuilder();
       sb.append("SELECT b from Books b ");
       try{

           if(null!= book.getTitle()){
               sb.append("where title = '"+book.getTitle()+"'");
           }

           if(null!= book.getAuthor()){
               sb.append(" where author = '"+book.getAuthor()+"'");
           }

           if(null!= book.getCategory()){
               sb.append(" where  category = '"+book.getCategory()+"'");
           }

           if(null!= book.getPrice()){
               sb.append(" where price = '"+book.getPrice()+"'");
           }

           TypedQuery<Books> query = jpaApi.em().createQuery(sb.toString(), Books.class);
           books = query.getResultList();

       }catch(NoResultException nre){

       }
        return books;

       // if((null==title) && (null==author))

       // TypedQuery<Books> query = jpaApi.em().createQuery("SELECT b FROM Books b where title LIKE '%"+title+"%' OR author LIKE '%"+author+"%'", Books.class);
       // List<Books> books= query.getResultList();

        //return books;
    }

    @Override
    public Collection<Books> findBookByCategory(String name) {
        TypedQuery<Books> query = jpaApi.em().createQuery("SELECT b FROM Books b where category LIKE '%"+name+"%'", Books.class);
        List<Books> books= query.getResultList();

        return books;
    }



    @Override
    public Books findBookById(Integer id) {
        TypedQuery<Books> query = jpaApi.em().createQuery("SELECT b FROM Books b where Id ="+id, Books.class);
        Books books= query.getSingleResult();

        return books;
    }

    @Override
    public Collection<Books> findBookByUname(String username) {

//        if(null == username) {
//            throw new IllegalArgumentException("username must be provided");
//        }
//        Logger.debug(username);

        TypedQuery<Books> query = jpaApi.em().createQuery("SELECT b FROM Books b where username LIKE '%"+username+"%'", Books.class);
        List<Books> books= query.getResultList();

        return books;
    }



    public Collection<Books> searchByUsername(String username){

        if(null == username) {
            throw new IllegalArgumentException("username must be provided");
        }

        Logger.debug(username);
        TypedQuery<Books> query = jpaApi.em().createQuery("SELECT b FROM Books b where username LIKE '%"+username+"%'", Books.class);
        List<Books> books = query.getResultList();
        return books;
    }

    }


