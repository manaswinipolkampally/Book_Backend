package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.io.BaseEncoding;
import controllers.security.Authenticator;
import controllers.security.IsAdmin;
import daos.UserDao;
import models.User;
import play.Logger;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.UUID;

public class UsersController extends Controller {

    private final static Logger.ALogger LOGGER = Logger.of(UsersController.class);
    private final static int HASH_ITERATIONS = 100;

    private UserDao userDao;

    @Inject
    public UsersController(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public Result registerUser() {

        LOGGER.info("registerUser");

        final JsonNode json = request().body().asJson();
        final User user = Json.fromJson(json, User.class);

        if (null == user.getUsername() ||
                null == user.getEmail() || null == user.getPhoneno() || null == user.getAddress() || null == user.getPincode()   ) {
            return badRequest("Missing mandatory parameters");
        }

        final String password = json.get("password").asText();
        if (null == password) {
            return badRequest("Missing mandatory parameters");
        }

        if (null != userDao.findUserByName(user.getUsername())) {
            return badRequest("User taken");
        }

        final String salt = generateSalt();

        final String hash = generateHash(salt, password, HASH_ITERATIONS);

        user.setHashIterations(HASH_ITERATIONS);
        user.setSalt(salt);
        user.setPasswordHash(hash);
        user.setState(User.State.VERIFIED);
        user.setRole(User.Role.USER);

        userDao.create(user);

        final JsonNode result = Json.toJson(user);

        return ok(result);
    }
    @Transactional
    private String generateSalt() {

        // TODO Generate random string

        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replace("-","");

        return uuid;

        //return "ABC";
    }
    @Transactional
    private String generateHash(String salt, String password, int iterations) {
        try {

            final String concat = salt + ":" + password;

            // TODO Run in a loop x iterations
            // TODO User a better hash function
            final MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(concat.getBytes());
            final String passwordHash = BaseEncoding.base16().lowerCase().encode(messageDigest);

            LOGGER.debug("Password hash {}", passwordHash);

            return passwordHash;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
    @Transactional
    public Result signInUser() {

        final JsonNode json = request().body().asJson();

        final String username = json.get("username").asText();
        final String password = json.get("passwordHash").asText();
        if (null == password || null == username) {
            return badRequest("Missing mandatory parameters");
        }

        final User existingUser = userDao.findUserByName(username);

        if (null == existingUser) {
            return unauthorized("Wrong username");
        }

        final String salt = existingUser.getSalt();
        final int iterations = existingUser.getHashIterations();
        final String hash = generateHash(salt, password, iterations);

        if (!existingUser.getPasswordHash().equals(hash)) {
            return unauthorized("Wrong password");
        }

        if (existingUser.getState() != User.State.VERIFIED) {
            return unauthorized("Account not verified");
        }

        existingUser.setAccessToken(generateAccessToken());

        userDao.update(existingUser);

        final JsonNode result = Json.toJson(existingUser);

        return ok(result);
    }
    @Transactional
    private String generateAccessToken() {

        // TODO Generate a random string of 20 (or more characters)

        String uuid = UUID.randomUUID().toString();
        uuid=uuid.replace("-","");

        return uuid;
    }

    @Authenticator
    @Transactional
    public Result signOutUser() {

       // if(null==Token)
           // return badRequest("Missing Mandatory Parameters");

        final User user = (User) ctx().args.get("user");

        //final User user = userDao.findUserByAuthToken(Token);

        if(null==user) {
            return unauthorized("Wrong User");
        }

        user.setAccessToken(null);

        userDao.update(user);

        return ok();
    }

    @Authenticator
    //@IsAdmin
    public Result getCurrentUser() {

        final User user = (User) ctx().args.get("user");

        final JsonNode result = Json.toJson(user);

        return ok(result);
    }

    @Transactional
    public Result getAllUsers() {

        Collection<User> users = userDao.all();

        final JsonNode result = Json.toJson(users);
        return ok(result);
    }

    @Transactional
    public Result updateUser() {

        final JsonNode json = request().body().asJson();
        final User user = Json.fromJson(json, User.class);



        if (null == user.getUsername() ||null == user.getEmail()|| null == user.getPhoneno() || null == user.getAddress() || null == user.getPincode()) {
            return badRequest("Missing mandatory parameters");
        }

        final User existingUser = userDao.findUserByName(user.getUsername());

        if (null == existingUser) {
            return unauthorized("Wrong username");
        }


        existingUser.setPhoneno(user.getPhoneno());
        existingUser.setPincode(user.getPincode());
        existingUser.setAddress(user.getAddress());


        userDao.update(existingUser);

        final JsonNode result = Json.toJson(existingUser);

        return ok(result);
    }



}
