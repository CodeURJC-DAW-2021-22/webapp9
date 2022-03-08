package urjc.gamelink.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//import urjc.gamelink.Configuration.resultGraphic;
import urjc.gamelink.Repositories.UseroRepository;
import urjc.gamelink.Service.UseroService;
import java.util.List;

@RestController
public class GraphicController {
    @Autowired
    private UseroRepository ur;

    @GetMapping("/api/genres")
    public List<Object> graphic(){

        return ur.findByGenre();
    }

}
