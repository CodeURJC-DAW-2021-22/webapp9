package urjc.gamelink;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GamelinkController {

    @GetMapping("/videojuegos")
    public String greeting(Model model) {

        model.addAttribute("game_name" , "Battlefield 2042");

        return "Videojuegos";
    }

    @GetMapping("/inicio")
    public String inicio(Model model){

        return "MenuHome";

    }

    @GetMapping("/perfil")
    public String perfilusuario(Model model){

        return "PerfilUsuario";

    }

}