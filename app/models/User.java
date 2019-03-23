package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;


@Entity
public class User {



    public enum Role {
        ADMIN,
        USER
    }

    public enum State {
        PENDING,
        VERIFIED,
        LOCKED
    }

    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private Integer id;*/

    @Id
    @Column(unique=true,nullable=false)
    @JsonProperty("username")
    private String username;

    @JsonIgnore
    private String passwordHash;
    @JsonIgnore
    private String salt;
    @JsonIgnore
    private Integer hashIterations;

    @Basic
    @Column(unique=true,nullable=false)
    @JsonProperty("email")
    private String email;

    @Basic
    @JsonProperty("role")
    private Role role;

    @Basic
    @JsonProperty("state")
    private State state;

    @Basic
    @JsonProperty("accessToken")
    private String accessToken;

    @Basic
    @Column(nullable=false)
    @JsonProperty("phoneno")
    private String phoneno;

    @Basic
    @Column(nullable=false)
    @JsonProperty("address")
    private String address;

    @Basic
    @JsonProperty("pincode")
    private String pincode;


    public User() {
    }

    public User( String username, String passwordHash, String salt, Integer hashIterations, String email, Role role, State state, String accessToken, String phoneno, String address, String pincode) {

        this.username = username;
        this.passwordHash = passwordHash;
        this.salt = salt;
        this.hashIterations = hashIterations;
        this.email = email;
        this.role = role;
        this.state = state;
        this.accessToken = accessToken;
        this.phoneno = phoneno;
        this.address = address;
        this.pincode = pincode;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getHashIterations() {
        return hashIterations;
    }

    public void setHashIterations(Integer hashIterations) {
        this.hashIterations = hashIterations;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }


    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
}