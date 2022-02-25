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

import org.springframework.lang.NonNull;

@Entity(name = "tbl_videogame")
public class Videogame {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id = null;
    
    @NonNull
    private String title;

    @NonNull
    private float price;

    private float rating;

    @NonNull
    private String genre;

    private String company;
    
    @Column(columnDefinition = "TEXT")
    private String description;

    @Lob
    private Blob imageFile;

    private boolean image;

    @ManyToMany
     private List<News> notices;

    public Videogame() {}
    

    public Videogame(String name, String description, float price) {
        this.title = name;
        this.description = description;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price =price;
    }

    public float getRating() {
        return rating;
    }

    public void  setRating(Float rating) {
        this.rating = rating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company =company;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Blob getImageFile() {
        return imageFile;
    }

    public void setImageFile(Blob image) {
        this.imageFile = image;
    }

    public boolean getImage(){
        return this.image;
    }

    public void setImage(boolean image){
        this.image = image;
    }

    public List<News> getNotices() {
        return notices;
    }

    public void setNotices(List<News>notices) {
        this.notices = notices;
    }

    @Override
    public String toString() {
        return "Videojuego [id=" + id + ", title=" + title + ", description=" + description + "Precio=" +price+"]";
    }

}