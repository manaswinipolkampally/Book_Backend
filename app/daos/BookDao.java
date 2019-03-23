package daos;

import models.Books;

import java.util.Collection;

public interface BookDao extends CrudDao<Books,Integer> {

     Collection<Books> search(Books book);
     Collection<Books> searchByUsername(String username);
     Collection<Books> findBookByCategory(String name);
     Books findBookById(Integer Id);
     Collection<Books> findBookByUname(String username);


}
