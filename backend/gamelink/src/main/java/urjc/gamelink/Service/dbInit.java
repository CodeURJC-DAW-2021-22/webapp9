package urjc.gamelink.Service;

import java.io.IOException;
import java.net.URISyntaxException;

//import java.io.IOException;
//import java.net.URISyntaxException;

import javax.annotation.PostConstruct;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import urjc.gamelink.Model.News;
import urjc.gamelink.Model.Usero;
import urjc.gamelink.Model.Videogame;
import urjc.gamelink.Repositories.NewRepository;
import urjc.gamelink.Repositories.UseroRepository;
import urjc.gamelink.Repositories.VideogameRepository;

@Service
public class dbInit {

    @Autowired
    private NewRepository ns; //this is the repository of news of the dataBase

    @Autowired
    private VideogameRepository vs; //this is the repository of videogames of the dataBase

    @Autowired
    private UseroRepository us; //this is the repository of users of the dataBase
    
    
    @PostConstruct
	public void init() throws IOException, URISyntaxException {
        /* Inserción de noticias en la BBDDD */
        News new1 = new News("Apex","klk klk klk","Manoplo","12/10/2022","3 minutes","incoming"); 
        setNewImage(new1,"/static/Photos/AndreasAvatar.PNG");
        ns.save(new1);

        News new2 = new News("lol","klk klk klk","Sarandongo","12/10/2022","3 minutes","update"); 
        setNewImage(new2,"/static/Photos/AndreasAvatar.PNG");
        ns.save(new2);

        News new3 = new News("lost ark","klk klk klk","TOtolo","12/10/2022","3 minutes","incoming"); 
        setNewImage(new3,"/static/Photos/AndreasAvatar.PNG");
        ns.save(new3);

        News new4 = new News("Battlefront 2","bla bla bla bla","Pirulai","14/03/2022","2 minutes","update");
        setNewImage(new4,"/static/Photos/csgo.png");
        ns.save(new4);

        /* Inserción de Videojeugos en la BBDDD */
        float price = 24.99f;
        Videogame vg1 = new Videogame("Togue tower","klk klkl klklkdsadsakl",price);
        setVgImage(vg1,"/static/Photos/AndreasAvatar.PNG");
        vs.save(vg1);

        price = 44.99f;
        Videogame vg2 = new Videogame("Nano tower","klk klkl klklkdsadsakl",price);
        setVgImage(vg2,"/static/Photos/AndreasAvatar.PNG");
        vs.save(vg2);

        price = 64.99f;
        Videogame vg3 = new Videogame("Crop tower","klk klkl klklkdsadsakl",price);
        setVgImage(vg3,"/static/Photos/AndreasAvatar.PNG");
        vs.save(vg3);

        price = 19.99f;
        Videogame vg4 = new Videogame("Battlefront 2","the best game ever",price);
        setVgImage(vg3,"/static/Photos/starWars_Grogu.jpeg");
        vs.save(vg4);

        /* Inserción de usuarios en la BBDDD */

        Usero u1 = new Usero("Pabvlo","123corteingles","user");
        setUsImage(u1,"/static/Photos/AndreasAvatar.PNG");
        us.save(u1);

        Usero u2 = new Usero("Mato","123corteingles","ADMIN");
        setUsImage(u2,"/static/Photos/AndreasAvatar.PNG");
        us.save(u2);
        
        Usero u3 = new Usero("Pabvloskhi","password","ADMIN");
        setUsImage(u3, "/static/Photos/ManisAvatar.PNG");
        us.save(u3);

    }
    
    private void setUsImage(Usero u1, String classpathResource) throws IOException {
        u1.setImage(true);
        Resource image = new ClassPathResource(classpathResource);
        u1.setImageFile(BlobProxy.generateProxy((image).getInputStream(), (image).contentLength()));
    }

    private void setVgImage(Videogame vg1, String classpathResource) throws IOException {
        vg1.setImage(true);
        Resource image = new ClassPathResource(classpathResource);
        vg1.setImageFile(BlobProxy.generateProxy((image).getInputStream(), (image).contentLength()));
    }

    public void setNewImage(News newx, String classpathResource) throws IOException {
		newx.setImage(true);
		Resource image =  new ClassPathResource(classpathResource);
		newx.setImageFile(BlobProxy.generateProxy((image).getInputStream(), (image).contentLength()));
	}
}
