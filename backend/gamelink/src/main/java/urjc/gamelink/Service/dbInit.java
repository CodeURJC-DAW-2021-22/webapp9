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
    private NewRepository ns; //this is the repository of news of the dataBase

    @Autowired
    private VideogameRepository vs; //this is the repository of videogames of the dataBase

    @Autowired
    private UseroRepository us; //this is the repository of users of the dataBase
    
    @Autowired
	private PasswordEncoder passwordEncoder;
    
    @PostConstruct
	public void init() throws IOException, URISyntaxException {
        /* Inserción de noticias en la BBDDD */
        News new1 = new News("¿Cuántas horas dura Elden Ring? Hay juego para rato",
                                "Hay MUY buenas noticias al respecto, y es que este título parece ser el más grande de toda la saga souls, traduciéndose eso en horas y horas de disfrute para los amantes de esta saga.",
                                "27/02/2022",
                                "3 minutos",
                                "Novedad"); 
        setNewImage(new1,"/static/Photos/eldenRing_2.jpg");
        ns.save(new1);

        News new2 = new News("PlayStation VR2 se lanzara a principios de 2023",
                                "Sony PlayStation ha ido compartiendo novedades importantes de PlayStation VR2, el nuevo dispositivo de realidad virtual para la PS5. Una de estas novedades ha sido su fecha de salida",
                                "26/02/2022",
                                "5 minutos",
                                "Tendencia"); 
        setNewImage(new2,"/static/Photos/ps5_vr2.jpeg");
        ns.save(new2);

        News new3 = new News("Forza Horizon 5 anuncia una nueva actualización gratuita",
                                "Xbox ya ha expresado multiples veces sus intenciones por mejorar la accesibilidad de sus juegos. Por ello esta actualización trae el lenguaje de signos a todas las cinematicas del juego",
                                "26/02/2022",
                                "2 minutos",
                                "Proximamente"); 
        setNewImage(new3,"/static/Photos/forzaHorizon5.jpeg");
        ns.save(new3);

        News new4 = new News("¿Nostalgico de Pac-Man? Esta colección con fecha recupera sus juegos junto a un sueño",
                                "Pac-Man Musium+ ha confirmado su lanzamiento en todas las plataformas actuales y en Xbox Game Pass desde el dia 1",
                                "26/02/2022",
                                "3 minutos",
                                "Tendencia");
        setNewImage(new4,"/static/Photos/pacManMusium.jpg");
        ns.save(new4);

        News new5 = new News("Super Smash Bros no estara en el EVO por decision de Nintendo",
                                "El mayor torneo de juegos de lucha esta ahora bajo el paraguas de Sony, que lo adquirio hace un año",
                                "25/02/2022",
                                "6 minutos",
                                "Nuevo");
        setNewImage(new5,"/static/Photos/superSmashBros.jpg");
        ns.save(new5);

        News new6 = new News("Pokemos GO recibirá nuevos Pokemon de Alola",
                                "Rowlet, Litten y Popplio acompañaran a las nuevas criaturas de la septima generación en el juego de Niantic",
                                "25/02/2022",
                                "1 minuto",
                                "Proximamente");
        setNewImage(new6,"/static/Photos/pokemonGo.jpg");
        ns.save(new6);

        News new7 = new News("¿Que barco mejorar en Lost Ark? Estos son nuestros consejos",
                                "La navegación encierra peligros para todos los jugadores nuevos en el juego. En esta lista encontraras los mejores consejos para poder empezar a surcar los mares de Lost Ark",
                                "25/02/2022",
                                "10 minutos",
                                "Tendencia");
        setNewImage(new7,"/static/Photos/lostArk_ship.jpg");
        ns.save(new7);

        News new8 = new News("Horizon Forbidden West diplica sus ventas digitales con respecto a su anterior juego",
                                "La nueva aventura de Aloy de Guerrilla Games sigue sigue una tendencia ascendente que venimos observando en los ultims años",
                                "24/02/2022",
                                "5 minutos",
                                "Novedad");
        setNewImage(new8,"/static/Photos/horizonForbiddenWest.jpeg");
        ns.save(new8);

        News new9 = new News("Call of Duty: Warzone corrige con su ultimo parche un error garrafal",
                                "La nueva actualización del battle royale free to play hace ajustes en la PPSh-41, entre otros cambios",
                                "24/02/2022",
                                "3 minutos",
                                "Proximamente");
        setNewImage(new9,"/static/Photos/callOfDuty.jpeg");
        ns.save(new9);

        News new10 = new News("GTA: The Triology anuncia nuevas actualizaciones",
                                "La colección la levantado quejas entre la comunidad por la cantidad de bugs graficos encontrados desde su lanzamiento",
                                "23/02/2022",
                                "7 minutos",
                                "Tendencia");
        setNewImage(new10,"/static/Photos/gtaTriology.jpg");
        ns.save(new10);

        News new11 = new News("Nintendo también compra estudios",
                                "La Gran N adquiere a desarrolladores de Zelda y Super Mario, a parte de incorporar a la compañia japonesa SRD",
                                "23/02/2022",
                                "4 minutos",
                                "Nuevo");
        setNewImage(new11,"/static/Photos/nintendo.png");
        ns.save(new11);

        News new12 = new News("Lost Ark en el horizonte proximo",
                                "Habeis leído bien, Lost Ark, el esperado juego de Amazón Games esta a punto de llegar a nuestras casas",
                                "23/02/2022",
                                "3 minutos",
                                "Proximamente");
        setNewImage(new12,"/static/Photos/lostark.jpg");
        ns.save(new12);

        News new13 = new News("Llega el nuevo parche 12.4 al League of Legends",
                                "En este parche encontraremos nuevos arreglos de bugs a parte del nerfeo de Zeni y Veigar a pesar de los anteriores nerfeos de parches pasados",
                                "22/02/2022",
                                "2 minutos",
                                "Nuevo");
        setNewImage(new13,"/static/Photos/leagueOfLegends.jpeg");
        ns.save(new13);

        News new14 = new News("Nueva informacion sobre Streets of Tarkov",
                                "Battlestate Games anunció esta mañana en twitter la preview del esperado mapa, asi como avances de lo que se viene en proximas actualizaciones",
                                "22/02/2022",
                                "5 minutos",
                                "Tendencia");
        setNewImage(new14,"/static/Photos/escapeFromTarkov.jpg");
        ns.save(new14);

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
     
        us.save(new Usero("usuario", passwordEncoder.encode("pass"), "USERO"));
        us.save(new Usero("admin", passwordEncoder.encode("123"), "USERO", "ADMIN"));

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
