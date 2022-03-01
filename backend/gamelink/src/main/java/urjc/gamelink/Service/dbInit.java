package urjc.gamelink.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.annotation.PostConstruct;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import antlr.collections.List;
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
        /* inserting news into the database */
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

        /* inserting videogames into the database*/
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

        /* inserting users into the database */
        ArrayList<Videogame> vids = new ArrayList<>();
        vids.add(vg1);
        vids.add(vg2);

        Usero usr = new Usero("usera", "useraPepe", "Uno", "usuario1@gmail.com");
        usr.setEncodedPassword(passwordEncoder.encode("passo"));
        ArrayList<String> roles1 = new ArrayList<>();
        roles1.add("USERO");
        usr.setRoles(roles1);
        usr.setpurchaseVideogames(vids);
        usr.setCreditCard("ABCFHU6");
        us.save(usr);

        Usero usr2 = new Usero("usuario", "usuarioPepe", "Uno", "usuario2@gmail.com");
        usr2.setEncodedPassword(passwordEncoder.encode("pass"));
        ArrayList<String> roles2 = new ArrayList<>();
        roles2.add("USERO");
        usr2.setRoles(roles2);

        us.save(usr2);

        Usero usr3 = new Usero("admin", "adminPepe", "Uno", "admin@123.com");
        usr3.setEncodedPassword(passwordEncoder.encode("123"));
        ArrayList<String> roles3 = new ArrayList<>();
        roles3.add("USERO");
        roles3.add("ADMIN");
        usr3.setRoles(roles3);
        us.save(usr3);

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
