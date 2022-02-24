package urjc.gamelink.Service;

import java.io.IOException;
import java.net.URISyntaxException;

import java.io.IOException;
import java.net.URISyntaxException;

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
    private NewRepository ns;

    @Autowired
    private VideogameRepository vs;

    @Autowired
    private UseroRepository us;
    
    
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

        News new4 = new News("wow","en fin","mi abuela","12/11/2022","4 minutes","incoming"); 
        setNewImage(new4,"/static/Photos/archeAge.jpg");
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

        price = 80.99f;
        Videogame vg4 = new Videogame("wow","hjhjjhjhjhjh",price);
        setVgImage(vg4,"/static/Photos/archeAge.jpg");
        vs.save(vg4);

        /* Inserción de usuarios en la BBDDD */

        Usero u1 = new Usero("Pabvlo","123corteingles","USER");
        setUsImage(u1,"/static/Photos/AndreasAvatar.PNG");
        us.save(u1);

        Usero u2 = new Usero("Mato","123corteingles","ADMIN");
        setUsImage(u2,"/static/Photos/AndreasAvatar.PNG");
        us.save(u2);

        Usero u3 = new Usero("Juan","12345","USER");
        setUsImage(u3,"/static/Photos/archeAge.jpg");
        us.save(u3);
        

    }
    
    private void setUsImage(Usero user, String classpathResource) throws IOException {
        user.setImage(true);
        Resource image = new ClassPathResource(classpathResource);
        user.setImageFile(BlobProxy.generateProxy((image).getInputStream(), (image).contentLength()));
    }

    private void setVgImage(Videogame videogame, String classpathResource) throws IOException {
        videogame.setImage(true);
        Resource image = new ClassPathResource(classpathResource);
        videogame.setImageFile(BlobProxy.generateProxy((image).getInputStream(), (image).contentLength()));
    }

    public void setNewImage(News newx, String classpathResource) throws IOException {
		newx.setImage(true);
		Resource image =  new ClassPathResource(classpathResource);
		newx.setImageFile(BlobProxy.generateProxy((image).getInputStream(), (image).contentLength()));
	}
}
