package urjc.gamelink.Model;

import java.sql.Blob;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
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

    private String continent;

    //private String badge;
    
    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "TEXT")
    private String requirements;

    @Lob
    private Blob imageFile;

    private boolean imageVg;

    @Lob
    private Blob imageCompanyFile;

    private boolean imageCompany;

    @ManyToMany
    private List<News> notices;

    @OneToMany
    private List<PurchaseCode> codes;

    public Videogame() {}

    public Videogame(String name, String company, String continent, String description, String requirements, String genre, float price) {
        this.title = name;
        this.company = company;
        this.continent = continent;
        this.description = description;
        this.requirements = requirements;
        this.genre = genre;
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

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
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
        return this.imageVg;
    }

    public void setImage(boolean image){
        this.imageVg = image;
    }

    public Blob getImageCompanyFile() {
        return imageCompanyFile;
    }


    public void setImageCompanyFile(Blob imageCompanyFile) {
        this.imageCompanyFile = imageCompanyFile;
    }


    public boolean isImageCompany() {
        return imageCompany;
    }


    public void setImageCompany(boolean imageCompany) {
        this.imageCompany = imageCompany;
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
