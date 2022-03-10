package urjc.gamelink.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import urjc.gamelink.Model.Usero;
//import urjc.gamelink.Configuration.resultGraphic;
import urjc.gamelink.Repositories.UseroRepository;
import urjc.gamelink.Repositories.VideogameRepository;
import urjc.gamelink.Service.UseroService;
import urjc.gamelink.Service.VideogameService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import urjc.gamelink.Repositories.UseroRepository;

@RestController
public class GraphicController {
    
    @Autowired
    private UseroRepository ur;

    @Autowired
    private VideogameRepository vr;

    @GetMapping("/api/genres")
    public List<Object> graphic(){

        return ur.findByGenre();
    }

    @GetMapping("/api/videogameSold")
    public List<Object> graphic2() {
        return ur.findBySold();
    }

    @GetMapping("/videogameStatistics/prueba")
    public List<Object> recommendedVideogamesShow(HttpServletRequest request){
        
        String name = request.getUserPrincipal().getName();
        Usero user = ur.findByName(name).orElseThrow();

        //List<Object> videogames = vs.findByFavouriteGenre(user);

        //model.addAttribute("games", videogames);

        return vr.findByFavouriteGenre(user);

    }
}
