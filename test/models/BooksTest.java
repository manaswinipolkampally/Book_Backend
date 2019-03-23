package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BooksTest {

    Books books;

    @Before
    public void setUp() throws Exception {
        books = new Books(1,"Title","Author",1000,5);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void createBook() {
        //final Books books = new Books(1, "Title");

        assertTrue(books.getId()==1);
        assertEquals("Title", books.getTitle());
        assertEquals("Author", books.getAuthor());
        assertEquals("Price", books.getPrice());
        assertEquals("Count", books.getCount());


    }

    @Test
    public void updateBook() {

        books.setTitle("New Title");

        assertEquals("New Title", books.getTitle());
    }


}