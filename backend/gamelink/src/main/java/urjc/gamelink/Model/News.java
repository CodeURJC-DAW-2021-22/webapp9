package urjc.gamelink.Model;

import java.sql.Blob;
import java.util.List;

import javax.persistence.Column;
//import javax.persistence.ElementCollection;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;

@Entity(name = "tbl_news")
public class News {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    private boolean image;

    @Lob
    private Blob imageFile;

    private String author;

    private String date;

    private String readTime;

    private String badge;


    @ManyToMany
     private List<Videogame> videogamesRelated;

     public News() {
    }

    public News(String title,String description, String author, String date ,String readtime, String badge) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.date = date;
        this.readTime = readtime;
        this.badge = badge;
    }

    
    public String getReadTime() {
        return readTime;
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

    public void setImageFile(Blob image) {
        this.imageFile = imageFile;
    }

    public boolean getImage(){
        return this.image;
    }

    public void setImage(boolean image){
        this.image = image;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

}