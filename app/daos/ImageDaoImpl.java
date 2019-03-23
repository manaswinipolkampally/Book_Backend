package daos;

import controllers.BooksController;
import models.Books;
import models.Image;
import play.Logger;
import play.db.jpa.JPAApi;
import daos.ImageDao;

import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class ImageDaoImpl implements ImageDao {

    private final static Logger.ALogger LOGGER = Logger.of(BooksController.class);

    final JPAApi jpaApi;

    @Inject
    public ImageDaoImpl(JPAApi jpaApi) {
        this.jpaApi = jpaApi;
    }

//    @Override
//    public Collection<Image> getImageById(Integer id){
//
//        if(null == id){
//            throw new IllegalArgumentException("id must be provided");
//        }
//
//        LOGGER.debug(String.valueOf(id));
//         Query query= jpaApi.em().createQuery("SELECT imageUrl FROM Image where id = '" + id + "'", Image.class);
//        List images = query.getResultList();
//
//        return images;
//    }

    @Override
    public Image create(Image entity) {
        jpaApi.em().persist(entity);
        return entity;
    }

    @Override
    public Optional<Image> read(String id) {
        return Optional.empty();
    }

    @Override
    public Image update(Image entity) {
        jpaApi.em().persist(entity);
        return entity;

    }

    @Override
    public Image updateCount(Image entity) {

        jpaApi.em().persist(entity);
        return entity;
    }

    @Override
    public Image delete(String imageUrl) {
        if(null == imageUrl){
            throw new IllegalArgumentException("Image Id must be provided");
        }
        //LOGGER.debug("url id is "+id);
        final Image existingimage = jpaApi.em().find(Image.class, imageUrl);

        if(null == existingimage){
            throw new IllegalArgumentException("Invalid Image");
        }

        jpaApi.em().remove(existingimage);

        return existingimage;



    }

    @Override
    public Collection<Image> all() {
        return null;
    }

    @Override
    public String[] searchByBookId(Integer id) {
        LOGGER.debug("id is " + id);


        if(null == id) {
            throw new IllegalArgumentException("id must be provided");
        }


        Collection<Image> images = null;
        String[] array;

        List<String> img_list;

        try {
            String queryString = "SELECT imageUrl FROM Image i WHERE book.id = '" + id +"' ";
            LOGGER.debug("queryString{} " + queryString);
            TypedQuery<String> query = jpaApi.em().createQuery(queryString,String.class);
            img_list=  query.getResultList();
            array = img_list.toArray(new String[0]);

            //images = query.getResultList();

        }
        catch(NoResultException nre){
            throw new IllegalArgumentException("No image found corresponding to given book id");
        }
        return array;


    }




}