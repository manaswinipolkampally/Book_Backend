package daos;

import models.User;
import play.Logger;
import play.db.jpa.JPAApi;

import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


public class UserDaoImpl implements UserDao{

    private final static Logger.ALogger LOGGER = Logger.of(UserDaoImpl.class);

    final JPAApi jpaApi;

    @Inject
    public UserDaoImpl(JPAApi jpaapi) {
        this.jpaApi = jpaapi;
    }


    @Override
    public User create(User user) {

        if(null == user) {
            throw new IllegalArgumentException("User Details must be provided");
        }

        jpaApi.em().persist(user);
        return user;


    }

    /*@Override
    public Optional<User> read(Integer id) {
        if (null == id) {
            throw new IllegalArgumentException("Id must be provided");
        }

        final User user = jpaApi.em().find(User.class, id);
        return user != null ? Optional.of(user) : Optional.empty();
    }*/

    @Override
    public User update(User user) {
       if(null==user){
           throw new IllegalArgumentException("user does not exit");
       }
        if (null == user.getUsername()) {
            throw new IllegalArgumentException("User Name must be provided");
        }

        final User existingUser = jpaApi.em().find(User.class, user.getUsername());
        if (null == existingUser) {
            throw new IllegalArgumentException("Invalid user");
        }

        existingUser.setUsername(user.getUsername());
        existingUser.setAccessToken(user.getAccessToken());
        existingUser.setPasswordHash(user.getPasswordHash());
        existingUser.setPhoneno(user.getPhoneno());
        existingUser.setAddress(user.getAddress());
        existingUser.setPincode(user.getPincode());



        jpaApi.em().persist(existingUser);

        return existingUser;
    }

   /* @Override
    public User delete(Integer id) {
        if (null == id) {
            throw new IllegalArgumentException("User id must be provided");
        }

        final User existingUser = jpaApi.em().find(User.class, id);
        if (null == existingUser) {
            return null;
        }

        jpaApi.em().remove(existingUser);

        return existingUser;
    }*/


    /*public Collection<User> all() {
        TypedQuery<User> query = jpaApi.em().createQuery("SELECT u FROM User u", User.class);
        List<User> user = query.getResultList();

        return user;
    }*/

    public User findUserByName(String username){
        if(null==username){
            throw new IllegalArgumentException("Username must be specified");
        }
        final User user = jpaApi.em().find(User.class,username);


        return user;
    }




   /* @Override
    public User findUserByName(String name) {

        User user = null;
        try {
            //LOGGER.debug("accessToken at find by level" + authToken);
            TypedQuery<User> query = jpaApi.em().createQuery("SELECT u from User u WHERE  u.username = '" + name +"' ", User.class);
            LOGGER.debug("queried");
            user = query.getSingleResult();
            LOGGER.debug("fetched query result to user");
        }
        catch(NoResultException nre){

        }
        if(null == user){
            return null;
        }
       return user;


    }*/

    public User findUserByAuthToken(String aToken) {
        User user;
        LOGGER.debug("Access token at find by level is:" + aToken);
        try {
            LOGGER.debug("accessToken at find by level" + aToken);
            TypedQuery<User> query = jpaApi.em().createQuery("SELECT u from User u WHERE  u.accessToken = '" + aToken +"' ", User.class);
            LOGGER.debug("queried");
            user = query.getSingleResult();
            LOGGER.debug("fetched query result to user");
        }

        catch(NoResultException nre){
            throw new IllegalArgumentException("Sign in to complete the action");
        }
        return user;

    }

    public Collection<User> all(){

        TypedQuery<User> query = jpaApi.em().createQuery("SELECT u FROM User u", User.class);
        List<User> users = query.getResultList();

        return users;



    }

}
