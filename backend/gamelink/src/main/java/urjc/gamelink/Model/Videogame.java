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
    private String shortDescription;

    @Column(columnDefinition = "TEXT")
    private String history;

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

    private String cpuR;
    private String ramR;
    private String ssooR;
    private String gpuR;
    private String storageR;


    
    private String cpuM;
    private String ramM;
    private String ssooM;
    private String gpuM;
    private String storageM;


    public Videogame() {}

    public Videogame(String title,String company, String continet, String description,String genre,  float price, String cpuR,
            String ramR, String ssooR, String gpuR, String storageR, String cpuM, String ramM,
            String ssooM, String gpuM, String storageM, String shortDescription, String longDesciption) {
        this.title = title;
        this.price = price;
        this.genre = genre;
        this.company = company;
        this.description = description;
        this.cpuR = cpuR;
        this.ramR = ramR;
        this.ssooR = ssooR;
        this.continent = continet;
        this.gpuR = gpuR;
        this.storageR = storageR;

        this.cpuM = cpuM;
        this.ramM = ramM;
        this.ssooM = ssooM;
        this.gpuM = gpuM;
        this.storageM = storageM;

        this.shortDescription = shortDescription;
        this.history = longDesciption;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String gethistory() {
        return history;
    }

    public void sethistory(String history) {
        this.history = history;
    }



    public String getCpuR() {
        return cpuR;
    }

    public void setCpuR(String cpuR) {
        this.cpuR = cpuR;
    }

    public String getRamR() {
        return ramR;
    }

    public void setRamR(String ramR) {
        this.ramR = ramR;
    }

    public String getSsooR() {
        return ssooR;
    }

    public void setSsooR(String ssooR) {
        this.ssooR = ssooR;
    }

    public String getGpuR() {
        return gpuR;
    }

    public void setGpuR(String gpuR) {
        this.gpuR = gpuR;
    }

    public String getStorageR() {
        return storageR;
    }

    public void setStorageR(String storageR) {
        this.storageR = storageR;
    }


    public String getCpuM() {
        return cpuM;
    }

    public void setCpuM(String cpuM) {
        this.cpuM = cpuM;
    }

    public String getRamM() {
        return ramM;
    }

    public void setRamM(String ramM) {
        this.ramM = ramM;
    }

    public String getSsooM() {
        return ssooM;
    }

    public void setSsooM(String ssooM) {
        this.ssooM = ssooM;
    }

    public String getGpuM() {
        return gpuM;
    }

    public void setGpuM(String gpuM) {
        this.gpuM = gpuM;
    }

    public String getStorageM() {
        return storageM;
    }

    public void setStorageM(String storageM) {
        this.storageM = storageM;
    }


    public boolean isImageVg() {
        return imageVg;
    }

    public void setImageVg(boolean imageVg) {
        this.imageVg = imageVg;
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

    public void setRating(float rating) {
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
