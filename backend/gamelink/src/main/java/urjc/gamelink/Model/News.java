package urjc.gamelink.Model;

import java.sql.Blob;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "tbl_news")
public class News {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    
    @Column(columnDefinition = "TEXT")
    private String argument;

    private boolean image;

    @JsonIgnore
    @Lob
    private Blob imageFile;

    private String date;

    private String badge;

    private String readTime;

    @JsonIgnore
    @ManyToMany(mappedBy = "notices")
     private List<Videogame> videogamesRelated;

     @JsonIgnore
     @ManyToMany
     private List<Usero> users;

     public News() {
    }

    public News(String title,String description, String date,String readTime, String badge ,String argument) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.badge = badge;
        this.readTime = readTime;
        this.argument = argument;
    }

    public List<Usero> getUsers() {
        return users;
    }

    public void setUsers(List<Usero> users) {
        this.users = users;
    }

    public String getReadTime() {
        return readTime;
    }

    public String getArgument() {
        return argument;
    }

    public void setArgument(String argument) {
        this.argument = argument;
    }

    public void setReadTime(String readTime) {
        this.readTime = readTime;
    }

    public String getBadge() {
        return badge;
    }

    public void setBadge(String badge) {
        this.badge = badge;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Blob getImageFile() {
        return imageFile;
    }

    public void setImageFile(Blob imageFile) {
        this.imageFile = imageFile;
    }

    public boolean getImage(){
        return this.image;
    }

    public void setImage(boolean image){
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Videogame> getVideogamesRelated() {
        return videogamesRelated;
    }

    public void setVideogamesRelated(List<Videogame> videogamesRelated) {
        this.videogamesRelated = videogamesRelated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOneReadNew(Usero user) {
        this.users.add(user);
    }

  
}
