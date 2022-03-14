package urjc.gamelink.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import urjc.gamelink.Service.UseroService;

import java.util.List;

@RestController
public class GraphicController {
    
    @Autowired
    private UseroService us;

    @GetMapping("/api/genres")
    public List<Object> graphic(){

        return us.findByGenre();
    }

    @GetMapping("/api/videogameSold")
    public List<Object> graphic2() {
        return us.findBySold();
    }

}
