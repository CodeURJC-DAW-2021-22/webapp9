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
import urjc.gamelink.Repositories.NewRepository;
import urjc.gamelink.Repositories.VideogameRepository;

@Service
public class dbInit {

    @Autowired
    private NewRepository ns;

    @Autowired
    private VideogameRepository vs;
    
    
    @PostConstruct
	public void init() throws IOException, URISyntaxException {
        News new1 = new News("Apex","klk klk klk","Manoplo","12/10/2022","3 minutes","incoming"); 
        setNewImage(new1,"/static/Fotos/AvatarAndrea.PNG");
        ns.save(new1);
    }
    
    public void setNewImage(News newx, String classpathResource) throws IOException {
		newx.setImage(true);
		Resource image =  new ClassPathResource(classpathResource);
		newx.setImageFile(BlobProxy.generateProxy((image).getInputStream(), (image).contentLength()));
	}
}
