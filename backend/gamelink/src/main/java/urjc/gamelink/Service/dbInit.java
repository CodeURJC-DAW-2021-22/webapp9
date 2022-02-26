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
import org.springframework.security.crypto.password.PasswordEncoder;
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
    
    @Autowired
	private PasswordEncoder passwordEncoder;
    
    @PostConstruct
	public void init() throws IOException, URISyntaxException {
        /* Inserción de noticias en la BBDDD */
        News new1 = new News("¿Cuántas horas dura Elden Ring? Hay juego para rato",
                                "Hay MUY buenas noticias al respecto, y es que este título parece ser el más grande de toda la saga souls, traduciéndose eso en horas y horas de disfrute para los amantes de esta saga."
                                ,"12/10/2022",
                                "3 minutes",
                                "incoming"); 

        setNewImage(new1,"/static/Photos/eldenRing_2.jpg");
        ns.save(new1);

        News new2 = new News("lol","klk klk klk","12/10/2022","3 minutes","update"); 
        setNewImage(new2,"/static/Photos/AndreasAvatar.PNG");
        ns.save(new2);

        News new3 = new News("lost ark","klk klk klk","12/10/2022","3 minutes","incoming"); 
        setNewImage(new3,"/static/Photos/AndreasAvatar.PNG");
        ns.save(new3);

        News new4 = new News("wow","mi abuela","12/11/2022","4 minutes","incoming"); 
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
     
        us.save(new Usero("usuario", passwordEncoder.encode("pass"), "USERO"));
        us.save(new Usero("admin", passwordEncoder.encode("123"), "USERO", "ADMIN"));

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
