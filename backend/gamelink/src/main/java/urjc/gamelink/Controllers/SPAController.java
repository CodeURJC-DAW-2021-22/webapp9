package urjc.gamelink.Controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class SPAController {
    
    @GetMapping("/**/{path:[^\\.]*}")
    public String redirect() {
    return "forward:/";
    }
   
}
