package urjc.gamelink.Model;

import java.sql.Blob;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;




@Entity(name = "tbl_user")
public class Usero {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nick;

    private String name;
    
    private String lastName;

    private String email;

    private String encodedPassword;
    
    private String creditCard;

    private boolean image;
    
    @Lob
    @JsonIgnore
    private Blob imageFile;

    @JsonIgnore
    @ManyToMany(mappedBy="users")  
     private List<News> readNotices;

    @JsonIgnore
    @ManyToMany(mappedBy="users")     
     private List<Videogame> purchaseVideogames;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles;

    public Usero() {
    }

    public Usero(String name, String nick, String lastName, String email) {
        this.name = name;
        this.nick = nick;
        this.lastName = lastName;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public List<News> getReadNotices() {
        return readNotices;
    }

    public void setReadNotices(List<News> readNotices) {
        this.readNotices = readNotices;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getEncodedPassword() {
        return encodedPassword;
    }

    public void setEncodedPassword(String encodedPassword) {
        this.encodedPassword = encodedPassword;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public List<Videogame> getPurchaseVideogames() {
        return purchaseVideogames;
    }

    public void setpurchaseVideogames(List<Videogame> purchaseVideogames) {
       this.purchaseVideogames = purchaseVideogames;
    }
    
    

}
