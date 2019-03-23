package models;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import controllers.*;


@Entity
public class Books {

    @ManyToOne
    @JoinColumn(name="username")
    private User user;

  /*  @OneToOne
    @JoinColumn(name="id")
    private Image image;*/



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private Integer id;


    @Basic
    @JsonProperty("title")
    private String title;
    //private Collection<Author> author;

    @Basic
    @JsonProperty("author")
    private String author;

    @Basic
    @JsonProperty("category")
    private String category;

    @Basic
    @JsonProperty("price")
    private Integer price;

    @Basic
    @JsonProperty("count")
    private Integer count;


    @Basic
    @JsonProperty("imageUrls")
    private String[] imageUrls;

    @Basic
    @JsonProperty("description")
    private String description;




    public Books() {

    }

    public Books(User user, Integer id, String title, String author, String category, Integer price, Integer count, String[] imageUrls, String description) {
        this.user = user;
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.price = price;
        this.count = count;
        this.imageUrls = imageUrls;
        this.description = description;
    }
/*public Books(Integer id, String title, String author, Integer price, Integer count, String url) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.count = count;
        this.url = url;
    }*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

   /* public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
*/

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String[] getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(String[] imageUrls) {
        this.imageUrls = imageUrls;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
