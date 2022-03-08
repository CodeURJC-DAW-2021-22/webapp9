package urjc.gamelink.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import urjc.gamelink.Repositories.UseroRepository;

@RestController
public class GraphicController {
    @Autowired
    private UseroRepository ur;

    @GetMapping("/api/videogameSold")
    public List<Object> graphic() {
        return ur.findBySold();
    }
}
