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
    private NewRepository ns; //this is the repository of news of the dataBase

    @Autowired
    private VideogameRepository vs; //this is the repository of videogames of the dataBase

    @Autowired
    private UseroRepository us; //this is the repository of users of the dataBase
    
    @Autowired
	private PasswordEncoder passwordEncoder;
    
    @PostConstruct
	public void init() throws IOException, URISyntaxException {
        /* inserting news into the database */
        News new1 = new News("¿Cuántas horas dura Elden Ring? Hay juego para rato",
                                "Hay MUY buenas noticias al respecto, y es que este título parece ser el más grande de toda la saga souls, traduciéndose eso en horas y horas de disfrute para los amantes de esta saga.",
                                "27/02/2022",
                                "Novedad"); 
        setNewImage(new1,"/static/Photos/eldenRing_2.jpg");
        ns.save(new1);

        News new2 = new News("PlayStation VR2 se lanzara a principios de 2023",
                                "Sony PlayStation ha ido compartiendo novedades importantes de PlayStation VR2, el nuevo dispositivo de realidad virtual para la PS5. Una de estas novedades ha sido su fecha de salida",
                                "26/02/2022",
                                "Tendencia"); 
        setNewImage(new2,"/static/Photos/ps5_vr2.jpeg");
        ns.save(new2);

        News new3 = new News("Forza Horizon 5 anuncia una nueva actualización gratuita",
                                "Xbox ya ha expresado multiples veces sus intenciones por mejorar la accesibilidad de sus juegos. Por ello esta actualización trae el lenguaje de signos a todas las cinematicas del juego",
                                "26/02/2022",
                                "Proximamente"); 
        setNewImage(new3,"/static/Photos/forzaHorizon5.jpeg");
        ns.save(new3);

        News new4 = new News("¿Nostalgico de Pac-Man? Esta colección con fecha recupera sus juegos junto a un sueño",
                                "Pac-Man Musium+ ha confirmado su lanzamiento en todas las plataformas actuales y en Xbox Game Pass desde el dia 1",
                                "26/02/2022",
                                "Tendencia");
        setNewImage(new4,"/static/Photos/pacManMusium.jpg");
        ns.save(new4);

        News new5 = new News("Super Smash Bros no estara en el EVO por decision de Nintendo",
                                "El mayor torneo de juegos de lucha esta ahora bajo el paraguas de Sony, que lo adquirio hace un año",
                                "25/02/2022",
                                "Nuevo");
        setNewImage(new5,"/static/Photos/superSmashBros.jpg");
        ns.save(new5);

        News new6 = new News("Pokemos GO recibirá nuevos Pokemon de Alola",
                                "Rowlet, Litten y Popplio acompañaran a las nuevas criaturas de la septima generación en el juego de Niantic",
                                "25/02/2022",
                                "Proximamente");
        setNewImage(new6,"/static/Photos/pokemonGo.jpg");
        ns.save(new6);

        News new7 = new News("¿Que barco mejorar en Lost Ark? Estos son nuestros consejos",
                                "La navegación encierra peligros para todos los jugadores nuevos en el juego. En esta lista encontraras los mejores consejos para poder empezar a surcar los mares de Lost Ark",
                                "25/02/2022",
                                "Tendencia");
        setNewImage(new7,"/static/Photos/lostArk_ship.jpg");
        ns.save(new7);

        News new8 = new News("Horizon Forbidden West diplica sus ventas digitales con respecto a su anterior juego",
                                "La nueva aventura de Aloy de Guerrilla Games sigue sigue una tendencia ascendente que venimos observando en los ultims años",
                                "24/02/2022",
                                "Novedad");
        setNewImage(new8,"/static/Photos/horizonForbiddenWest.jpeg");
        ns.save(new8);

        News new9 = new News("Call of Duty: Warzone corrige con su ultimo parche un error garrafal",
                                "La nueva actualización del battle royale free to play hace ajustes en la PPSh-41, entre otros cambios",
                                "24/02/2022",
                                "Proximamente");
        setNewImage(new9,"/static/Photos/callOfDuty.jpeg");
        ns.save(new9);

        News new10 = new News("GTA: The Triology anuncia nuevas actualizaciones",
                                "La colección la levantado quejas entre la comunidad por la cantidad de bugs graficos encontrados desde su lanzamiento",
                                "23/02/2022",
                                "Tendencia");
        setNewImage(new10,"/static/Photos/gtaTriology.jpg");
        ns.save(new10);

        News new11 = new News("Nintendo también compra estudios",
                                "La Gran N adquiere a desarrolladores de Zelda y Super Mario, a parte de incorporar a la compañia japonesa SRD",
                                "23/02/2022",
                                "Nuevo");
        setNewImage(new11,"/static/Photos/nintendo.png");
        ns.save(new11);

        News new12 = new News("Lost Ark en el horizonte proximo",
                                "Habeis leído bien, Lost Ark, el esperado juego de Amazón Games esta a punto de llegar a nuestras casas",
                                "23/02/2022",
                                "Proximamente");
        setNewImage(new12,"/static/Photos/lostark.jpg");
        ns.save(new12);

        News new13 = new News("Llega el nuevo parche 12.4 al League of Legends",
                                "En este parche encontraremos nuevos arreglos de bugs a parte del nerfeo de Zeni y Veigar a pesar de los anteriores nerfeos de parches pasados",
                                "22/02/2022",
                                "Nuevo");
        setNewImage(new13,"/static/Photos/leagueOfLegends.jpeg");
        ns.save(new13);

        News new14 = new News("Nueva informacion sobre Streets of Tarkov",
                                "Battlestate Games anunció esta mañana en twitter la preview del esperado mapa, asi como avances de lo que se viene en proximas actualizaciones",
                                "22/02/2022",
                                "Tendencia");
        setNewImage(new14,"/static/Photos/escapeFromTarkov.jpg");
        ns.save(new14);

        News new15 = new News("Dragon Ball FighterZ pone fecha a los combates entre Gpku y compañia en PC Game Pass",
                                "El servicio de Xbox ampliara su catalogo de juegos de lucha con los enfrentaminetos de la conocida franquicia de Dragon Ball",
                                "21/02/2022",
                                "Nuevo");
        setNewImage(new15,"/static/Photos/dragonBall.jpg");
        ns.save(new15);

        News new16 = new News("Ciberpunk 2077 no tendra metro, ni ahora ni nunca",
                                "Aunque era el medio de transporte mas solicitado por los fans, parece que se quedaa fuera de Night City, segun han comentado sus creadores",
                                "20/02/2022",
                                "Tendencia");
        setNewImage(new16,"/static/Photos/ciberpunk2077_metro.jpg");
        ns.save(new16);

        News new17 = new News("Destiny 2: La Reina Bruja tiene un buen debut en Steam",
                                "El juego registra un trafico de jugadores muy positivo desde el lanzamiento de su nueva expansion",
                                "20/02/2022",
                                "New");
        setNewImage(new17,"/static/Photos/destiny2_art.jpg");
        ns.save(new17);

        News new18 = new News("Los creadores de Gears 5 trabajan en varios proyectos por anunciar",
                                "Asi lo declara Aaron Greenberg, que deefine a The Coalition como maestro en el uso de Unreal Engine, ¿Nos esperamos un nuevo Gears of War o algo mas?",
                                "20/02/2022",
                                "Proximamente");
        setNewImage(new18,"/static/Photos/gears5.jpg");
        ns.save(new18);

        News new19 = new News("Assassin's Creed: Valhalla se actualiza y se podra jugar gratis este finde en todas las plataformas",
                                "La última aventura de Ubisoft es todo un exito para sus arcas, pero la coompañia parte en busca de nuevos jugadores",
                                "19/02/2022",
                                "Novedad");
        setNewImage(new19,"/static/Photos/assassinCreed.jpg");
        ns.save(new19);

        News new20 = new News("Total War: Warhammer 3 firma su segundo mejor estreno de un Total War en Steam",
                                "Grandes numeros para el videojuego de estrategia pese a su lanzamiento simultaneo en PC Game Pass",
                                "19/02/2022",
                                "Tendencia");
        setNewImage(new20,"/static/Photos/totalWarWarhammer3_battle.jpeg");
        ns.save(new20);

        /* Inserción de Videojeugos en la BBDDD */
        float price = 24.99f;
        Videogame vg1 = new Videogame("Total War: ROME",
            "Sega",
            "Europe",
            "Total War: ROME REMASTERED te permite experimentar de nuevo el juego que definió esta premiada saga de estrategia. Es hora de volver a disfrutar de este verdadero clásico, ahora remasterizado en 4K y repleto de mejoras visuales y de jugabilidad.",
            "SO: Windows 10 64-bit (version 20H2) \n Procesador: Intel Core i5-4570 | Ryzen 5 1600 \n Memoria: 8 GB de RAM \n Gráficos: NVIDIA GeForce GTX 770 4GB | AMD Radeon R9 290 4GB \n DirectX: Versión 11 \n Almacenamiento: 45 GB de espacio disponible",
            "Estrategia",
            price);
        setVgImage(vg1,"/static/Photos/totalWarRome.jpg");
        setVgCompanyImage(vg1,"/static/Photos/sega.jpg");
        vs.save(vg1);

        price = 29.99f;
        Videogame vg2 = new Videogame("Star Wars Battlefront 2",
            "EA",
            "Global",
            "¡Saca tu lado heroico en la aventura definitiva de STAR WARS™ con STAR WARS™ Battlefront™ II: Celebration Edition!",
            "SO: 64-bit Windows 10 or later \n Procesador: Processor (AMD): AMD FX 8350 Wraith Processor (Intel): Intel Core i7 6700 or equivalent \n Memoria: 16 GB de RAM \n Gráficos: Graphics card (AMD): AMD Radeon™ RX 480 4GB Graphics card (NVIDIA): NVIDIA GeForce® GTX 1060 3GB \n DirectX: Versión 11 \n Red: Conexión de banda ancha a Internet \n Almacenamiento: 60 GB de espacio disponible",
            "Shooter",
            price);
        setVgImage(vg2,"/static/Photos/starWarsBattlefront2.png");
        setVgCompanyImage(vg2,"/static/Photos/ea.png");
        vs.save(vg2);

        price = 9.99f;
        Videogame vg3 = new Videogame("Grand Theft Auto V",
            "Rockstar Games",
            "Global",
            "Grand Theft Auto V para PC ofrece a los jugadores la opción de explorar el galardonado mundo de Los Santos y el condado de Blaine con una resolución de 4K y disfrutar del juego a 60 fotogramas por segundo.",
            "SO: Windows 8.1 de 64 bits, Windows 8 de 64 bits, Windows 7 de 64 bits con Service Pack 1. \n Procesador: Intel Core i5 3470 a 3,2 GHz (4 CPU)/AMD X8 FX-8350 a 4 GHz (8 CPU). \n Memoria: 8 GB de RAM \n Gráficos: NVIDIA GTX 660 2 GB/AMD HD7870 2 GB. \n Almacenamiento: 72 GB de espacio disponible \n Tarjeta de sonido: compatible con DirectX 10.",
            "Accion",
            price);
        setVgImage(vg3,"/static/Photos/gtaV.jpeg");
        setVgCompanyImage(vg3,"/static/Photos/rockstarGamesIcon.png");
        vs.save(vg3);

        
        price = 12.99f;
        Videogame vg4 = new Videogame("Minecraft: Java Edition",
            "Microsoft",
            "Global",
            "¡Explora tu propio mundo único, sobrevive a la noche y crea todo lo que puedas imaginar!",
            "SO: Windows 10 64-bit (version 20H2) \n Procesador: Intel Core i5-4570 | Ryzen 5 1600 \n Memoria: 8 GB de RAM \n Gráficos: NVIDIA GeForce GTX 770 4GB | AMD Radeon R9 290 4GB \n DirectX: Versión 11 \n Almacenamiento: 45 GB de espacio disponible",
            "Supervivencia",
            price);
        setVgImage(vg4,"/static/Photos/minecraft.jpg");
        setVgCompanyImage(vg4,"/static/Photos/microsoft.png");
        vs.save(vg4);
    
        price = 55.85f;
        Videogame vg5 = new Videogame("Elden Ring",
            "From Software Inc.",
            "Asia",
            "EL NUEVO JUEGO DE ROL Y ACCIÓN DE AMBIENTACIÓN FANTÁSTICA. Álzate, Sinluz, y que la gracia te guíe para abrazar el poder del Círculo de Elden y encumbrarte como señor del Círculo en las Tierras Intermedias.",
            "SO: Windows 10/11\n Procesador: INTEL CORE I7-8700K or AMD RYZEN 5 3600X\n Memoria: 16 GB de RAM\n Gráficos: NVIDIA GEFORCE GTX 1070 8 GB or AMD RADEON RX VEGA 56 8 GB\n DirectX: Versión 12\n Almacenamiento: 60 GB de espacio disponible\n Tarjeta de sonido: Windows Compatible Audio Device",
            "Aventura",
            price);
        setVgImage(vg5,"/static/Photos/eldenRing.webp");
        setVgCompanyImage(vg5,"/static/Photos/fromSoftware.jpg");
        vs.save(vg5);

        price = 4.99f;
        Videogame vg6 = new Videogame("Genshin Impact",
            "Hoyoverse",
            "Europa",
            "Genshin Impact es un juego de acción ARPG de mundo abierto free-to-play con una mecánica de monetización de Gacha para conseguir elementos adicionales como personajes especiales y armas.",
            "SO: Windows 7 SP1 64-bit, Windows 8.1 64-bit o Windows 10 64-bit\n  Procesador: Intel Core i7 y superior o similar\n Memoria: 16 GB\n Gráficos: GeForce GTX 1060 6 GB y superior o similar\n Almacenamiento: 30 GB",
            "Aventura",
            price);
        setVgImage(vg6,"/static/Photos/genshinImpact.jpg");
        setVgCompanyImage(vg6,"/static/Photos/hoyoverse.jpg");
        vs.save(vg6);

        price = 19.85f;
        Videogame vg7 = new Videogame("ARK: Survival Evolved",
            "Studio Wildcard",
            "Global",
            "Juega como un hombre o una mujer desnudo, congelándote y muriéndote de hambre en una isla misteriosa. Debes cazar, cosechar, crear objetos, cultivar, y construir refugios para sobrevivir. Usa tu habilidad y astucia para matar, domesticar, criar y cabalgar dinosaurios y otras criaturas primitivas.",
            "SO: Windows 7/8.1/10 (64-bit versions)\n Procesador: Intel Core i5-2400/AMD FX-8320 or better\n Memoria: 8 GB de RAM\n Gráficos: NVIDIA GTX 670 2GB/AMD Radeon HD 7870 2GB or better\n DirectX: Versión 10\n Almacenamiento: 60 GB de espacio disponible",
            "Supervivencia",
            price);
        setVgImage(vg7,"/static/Photos/ark.webp");
        setVgCompanyImage(vg7,"/static/Photos/studioWildcard.png");
        vs.save(vg7);

        price = 9.75f;
        Videogame vg8 = new Videogame("Lost Ark",
            "Amazon Games",
            "America",
            "Embárcate en una odisea en el gigantesco y vibrante mundo de Lost Ark: explora lugares desconocidos, busca tesoros perdidos y ponte a prueba con la emocionante acción y combate de este RPG de acción gratuito.",
            "SO: Windows 10 (64 bits)\n Procesador: Intel i5 o AMD Ryzen 5\n Memoria: 16 GB de RAM\n Gráficos: NVIDIA GeForce GTX 1050\n DirectX: Versión 11\n Red: Conexión de banda ancha a Internet\n Almacenamiento: 50 GB de espacio disponible",
            "Rol",
            price);
        setVgImage(vg8,"/static/Photos/lostark.jpg");
        setVgCompanyImage(vg8,"/static/Photos/amazonGames.jpg");
        vs.save(vg8);

        price = 25.75f;
        Videogame vg9 = new Videogame("Fifa 22",
            "EA",
            "Global",
            "Powered by Football™. EA SPORTS™ FIFA 22 acerca aún más el juego a la realidad gracias a mejoras significativas en la jugabilidad y una nueva temporada de novedades en todos los modos.",
            "SO: Windows 10 - 64-Bit\n Procesador: Intel i5-3550 @ 3.40GHz or AMD FX 8150 @ 3.6GHz\n Memoria: 8 GB de RAM\n Gráficos: NVIDIA GeForce GTX 670 or AMD Radeon R9 270X\n Red: Conexión de banda ancha a Internet\n Almacenamiento: 50 GB de espacio disponible",
            "Deportes",
            price);
        setVgImage(vg9,"/static/Photos/fifa22.jpg");
        setVgCompanyImage(vg9,"/static/Photos/ea.png");
        vs.save(vg9);

        price = 22.99f;
        Videogame vg10 = new Videogame("Cities: Skylines",
            "Padarox Interactive",
            "Europa",
            "Introduce nuevos elementos a la mecánica de juego para plasmar la emoción y las complicaciones de mantener una ciudad de verdad, ampliando al mismo tiempo algunos de los temas ya conocidos de la experiencia del desarrollo urbanístico.",
            "SO: Windows® 10 Home 64 bit\n Procesador: Intel® Core™ I7 2700K | AMD® Ryzen 7 2700X\n Memoria: 16 GB de RAM\n Gráficos: Nvidia® GeForce™ GTX 580 (1.5 GB) | AMD® Radeon™ RX 560 (4 GB)\n DirectX: Versión 11\n Red: Conexión de banda ancha a Internet\n Almacenamiento: 4 GB de espacio disponible",
            "Construcción",
            price);
        setVgImage(vg10,"/static/Photos/citiesSkylines.jpg");
        setVgCompanyImage(vg10,"/static/Photos/paradox.jpg");
        vs.save(vg10);

        price = 14.99f;
        Videogame vg11 = new Videogame("Battlefield V",
            "Ea",
            "Global",
            "Esta es la mejor experiencia de Battlefield V. Vive el mayor conflicto de la humanidad con un completo arsenal de armas, vehículos y dispositivos, y todos los contenidos de personalización de los dos primeros años.",
            "SO: 64-bit Windows 10 or later\n Procesador: AMD Ryzen 3 1300X/Intel Core i7 4790\n Memoria: 12 GB de RAM\n Gráficos: NVIDIA GeForce® GTX 1060 6GB/AMD Radeon™ RX 580 8GB\n DirectX: Versión 11\n Almacenamiento: 50 GB de espacio disponible",
            "Shooter",
            price);
        setVgImage(vg11,"/static/Photos/battlefieldV.jpg");
        setVgCompanyImage(vg11,"/static/Photos/ea.png");
        vs.save(vg11);

        price = 20.99f;
        Videogame vg12 = new Videogame("Call of Duty: Black Ops III",
            "Activision",
            "Global",
            "Call of Duty® Black Ops III: Zombies Chronicles Edition incluye el juego original completo y la expansión de contenido Zombies Chronicles.",
            "SO: Windows 7 64-Bit / Windows 8 64-Bit / Windows 8.1 64-Bit\n Procesador: Intel® Core™ i3-530 @ 2.93 GHz / AMD Phenom™ II X4 810 @ 2.60 GHz\n Memoria: 6 GB de RAM\n Gráficos: NVIDIA® GeForce® GTX 470 @ 1GB / ATI® Radeon™ HD 6970 @ 1GB\n DirectX: Versión 11\n Red: Conexión de banda ancha a Internet\n Almacenamiento: 100 GB de espacio disponible",
            "Shooter",
            price);
        setVgImage(vg12,"/static/Photos/callOfDutyBlackOps3.jpg");
        setVgCompanyImage(vg12,"/static/Photos/activision.jpg");
        vs.save(vg12);

        price = 23.95f;
        Videogame vg13 = new Videogame("Horizon Zero Dawn",
            "Guerrilla Games",
            "Global",
            "Vive la misión legendaria de Aloy para desvelar los secretos de una futura Tierra dominada por máquinas. ¡Usa devastadores ataques contra tus depredadores y explora un majestuoso mundo abierto en este galardonado RPG de acción!",
            "SO: Windows 10 64-bits\n Procesador: Intel Core i7-4770K@3.5GHz or Ryzen 5 1500X@3.5GHz\n  Memoria: 16 GB de RAM\n  Gráficos: Nvidia GeForce GTX 1060 (6 GB) or AMD Radeon RX 580 (8GB)\n  DirectX: Versión 12\n Almacenamiento: 100 GB de espacio disponible",
            "Aventura",
            price);
        setVgImage(vg13,"/static/Photos/horizonZeroDawn.webp");
        setVgCompanyImage(vg13,"/static/Photos/guerrilla.png");
        vs.save(vg13);

        price = 35.95f;
        Videogame vg14 = new Videogame("Total War: Warhammer III",
            "Sega",
            "Europa",
            "El final cataclísmico de la trilogía de Total War™: WARHAMMER® ha llegado. Reagrupa a tus fuerzas y adéntrate en el Reino del Caos, una dimensión de terrores horripilantes en la que se decidirá el destino del mundo. ¿Conquistarás a tus demonios... o los dirigirás?",
            "SO: Windows 10 64-bit\n Procesador: Intel i5/Ryzen 5 series\n Memoria: 8 GB de RAM\n Gráficos: Nvidia GeForce GTX 1660 Ti/AMD RX 5600-XT\n DirectX: Versión 11\n Almacenamiento: 120 GB de espacio disponible",
            "Estrategia",
            price);
        setVgImage(vg14,"/static/Photos/totalWarWarhammer3.jpg");
        setVgCompanyImage(vg14,"/static/Photos/sega.jpg");
        vs.save(vg14);

        price = 45.95f;
        Videogame vg15 = new Videogame("GRID Legends",
            "EA",
            "Global",
            "GRID Legends te ofrece una competición automovilística trepidante. Crea eventos de ensueño, participa en carreras en directo, vive una historia dramática de producción virtual y disfruta de la sensación de las carreras más espectaculares.",
            "SO: 64-bit Windows 10/11\n Procesador: Intel i5 8600k, AMD Ryzen 5 2600x\n Memoria: 16 GB de RAM\n Gráficos: Nvidia GTX 1080, AMD RX590\n DirectX: Versión 12\n Red: Conexión de banda ancha a Internet\n Almacenamiento: 50 GB de espacio disponible",
            "Carreras",
            price);
        setVgImage(vg15,"/static/Photos/gridLegends.jpg");
        setVgCompanyImage(vg15,"/static/Photos/ea.png");
        vs.save(vg15);

        price = 4.98f;
        Videogame vg16 = new Videogame("Destiny 2",
            "Bungie",
            "Global",
            "Destiny 2 es un MMO de acción con un mundo único y dinámico al que tus amigos y tú os podéis unir en cualquier momento y desde cualquier lugar.",
            "SO: System Windows® 7 / Windows® 8.1 / Windows® 10 64-bit (latest Service Pack)\n Procesador: Processor Intel® Core™ i5 2400 3.4 GHz or i5 7400 3.5 GHz / AMD Ryzen R5 1600X 3.6 GHz\n Memoria: 8 GB de RAM\n Gráficos: NVIDIA® GeForce® GTX 970 4GB or GTX 1060 6GB / AMD R9 390 8GB Memory 8 GB RAM\n Red: Conexión de banda ancha a Internet\n Almacenamiento: 105 GB de espacio disponible",
            "Acción",
            price);
        setVgImage(vg16,"/static/Photos/destiny2.jpg");
        setVgCompanyImage(vg16,"/static/Photos/bungie.jpg");
        vs.save(vg16);

        price = 19.99f;
        Videogame vg17 = new Videogame("Microsoft Flight Simulator",
            "Microsoft",
            "Global",
            "Surca los cielos y disfruta la alegría de volar en la próxima generación de Microsoft Flight Simulator. El mundo está al alcance de la mano.",
            "SO: Windows 10\n Procesador: AMD Ryzen 3 1200 o Intel i5-4460\n Memoria: 8GB\n Gráficos: AMD Radeon RX 570 o Nvidia GTX 770\n Almacenamiento: 150 GB",
            "Simulacion",
            price);
        setVgImage(vg17,"/static/Photos/flightSimulator.jpg");
        setVgCompanyImage(vg17,"/static/Photos/microsoft.png");
        vs.save(vg17);

        price = 14.99f;
        Videogame vg18 = new Videogame("Phasmofobia",
            "Kinetic Games",
            "Asia",
            "Phasmophobia is a 4 player online co-op psychological horror. Paranormal activity is on the rise and it’s up to you and your team to use all the ghost hunting equipment at your disposal in order to gather as much evidence as you can.",
            "SO: Windows 10 64Bit\n Procesador: Intel Core i5-10600 / AMD Ryzen 5 3600\n Memoria: 8 GB de RAM\n Gráficos: NVIDIA RTX 2060 / AMD Radeon RX 5700\n Red: Conexión de banda ancha a Internet\n Almacenamiento: 18 GB de espacio disponible",
            "Terror",
            price);
        setVgImage(vg18,"/static/Photos/phasmofobia.jpg");
        setVgCompanyImage(vg18,"/static/Photos/kinetic.png");
        vs.save(vg18);

        price = 26.99f;
        Videogame vg19 = new Videogame("Rust",
            "Facepunch Studios",
            "Europa",
            "El único objetivo en Rust es sobrevivir. Todo quiere que mueras: la vida silvestre de la isla y otros habitantes, el medio ambiente, otros sobrevivientes. Haz lo que sea necesario para durar otra noche.",
            "SO: Windows 11 64bit\n Procesador: Intel Core i7-4790K / AMD Ryzen 5 1600\n Memoria: 16 GB de RAM\n Gráficos: GTX 980 / AMD R9 Fury\n DirectX: Versión 12\n Red: Conexión de banda ancha a Internet\n Almacenamiento: 25 GB de espacio disponible",
            "Supervivencia",
            price);
        setVgImage(vg19,"/static/Photos/rust.webp");
        setVgCompanyImage(vg19,"/static/Photos/facepunch.jpg");
        vs.save(vg19);

        price = 32.99f;
        Videogame vg20 = new Videogame("LEGO Star Wars: The Skywalker saga",
            "TT Games",
            "Global",
            "Disfruta de las nueve películas de la saga Star Wars en un videojuego totalmente innovador de LEGO. Vive aventuras divertidísimas, cargadas de humor ingenioso y la libertad de sumergirte de lleno en la galaxia de LEGO Star Wars.",
            "SO: Windows 10 64-bit\n Procesador: Intel Core i5-6600 or AMD Ryzen 3 3100\n Memoria: 8 GB de RAM\n Gráficos: GeForce GTX 780 or Radeon R9 290\n DirectX: Versión 11\n Almacenamiento: 40 GB de espacio disponible",
            "Aventura",
            price);
        setVgImage(vg20,"/static/Photos/legoStarWars.jpg");
        setVgCompanyImage(vg20,"/static/Photos/ttGames.png");
        vs.save(vg20);


        /* inserting users into the database */

        Usero usr = new Usero("usera", "useraPepe", "Uno", "usuario1@gmail.com");
        usr.setEncodedPassword(passwordEncoder.encode("passo"));
        ArrayList<String> roles1 = new ArrayList<>();
        roles1.add("USERO");
        usr.setRoles(roles1);
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

    private void setVgCompanyImage(Videogame vg1, String classpathResource) throws IOException {
        vg1.setImageCompany(true);
        Resource image = new ClassPathResource(classpathResource);
        vg1.setImageCompanyFile(BlobProxy.generateProxy((image).getInputStream(), (image).contentLength()));
    }

    public void setNewImage(News newx, String classpathResource) throws IOException {
		newx.setImage(true);
		Resource image =  new ClassPathResource(classpathResource);
		newx.setImageFile(BlobProxy.generateProxy((image).getInputStream(), (image).contentLength()));
	}
}
