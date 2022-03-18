package urjc.gamelink.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name="tbl_purchase_code")
public class PurchaseCode {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String codeID;

    private String videogameName;

    private String discount;

    @ManyToOne
    private Videogame videogame;

    public PurchaseCode(){}

    public PurchaseCode(String codeID, String videogameName, String discount){
        this.codeID = codeID;
        this.videogameName = videogameName;
        this.discount = discount;
    }

    public String getCodeID(){
        return codeID;
    }

    public void setCodeID(String codeID){
        this.codeID = codeID;
    }

    public String getVideogameName(){
        return videogameName;
    }

    public void setVideogameName(String videogameName){
        this.videogameName = videogameName;
    }

    public String getDiscount(){
        return discount;
    }

    public void setDiscount(String discount){
        this.discount = discount;
    }

}
