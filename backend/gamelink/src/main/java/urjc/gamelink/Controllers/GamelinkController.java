package urjc.gamelink.Controllers;

import java.security.Principal;
import java.sql.SQLException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
//import javax.smartcardio.CardTerminals.State;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import urjc.gamelink.Model.News;
import urjc.gamelink.Model.Usero;
import urjc.gamelink.Model.Videogame;
import urjc.gamelink.Repositories.UseroRepository;
import urjc.gamelink.Service.NewsService;
import urjc.gamelink.Service.UseroService;
import urjc.gamelink.Service.VideogameService;

@Controller
public class GamelinkController {

    @Autowired
    private NewsService ns;

    @Autowired
    private VideogameService vs;

    @Autowired
    private UseroService us;

    @Autowired
    private UseroRepository ur;


    

	@GetMapping("/news/{id}/image")
	public ResponseEntity<Object> downloadImage(@PathVariable long id) throws SQLException {

		Optional<News> news = ns.findById(id);
		if (news.isPresent() && news.get().getImageFile() != null) {

			Resource file = new InputStreamResource(news.get().getImageFile().getBinaryStream());

			return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "image/PNG")
					.contentLength(news.get().getImageFile().length()).body(file);

		} else {
			return ResponseEntity.notFound().build();
		}
	}


    @GetMapping("/")
    public String home(Model model){

        model.addAttribute("new", ns.findAll());
              
        return "home";

    }


    @GetMapping("/about")
    public String about(Model model){
        
        return "about";

    }

    @GetMapping("/admin")
    public String admin(Model model){
        
        return "admin";

    }

    @GetMapping("/paymentConfirmation")
    public String paymentConfirmation(Model model){
        
        return "paymentConfirmation";

    }

    @GetMapping("/videogameStatistics")
    public String videogameStatistics(Model model){
        
        return "videogameStatistics";

    }

    @GetMapping("/login")
    public String login(Model model){
        
        return "login";

    }

    @GetMapping("/loginError")
    public String loginError(Model model){
        
        return "loginError";

    }

    @GetMapping("/errorMessage")
    public String errorMessage(Model model){
        
        return "errorMessage";

    }

    @GetMapping("/news")
    public String news(Model model){
        
        return "news";

    }

    @GetMapping("/userProfile")
    public String userProfile(Model model, HttpServletRequest request){

        String name = request.getUserPrincipal().getName();
        Usero user = ur.findByName(name).orElseThrow();
        model.addAttribute("username", user.getName());
        model.addAttribute("nick", user.getNick());
        model.addAttribute("encodedPassword", user.getEncodedPassword());
        model.addAttribute("lastName", user.getLastName());
        model.addAttribute("creditCard", user.getCreditCard());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("Videogame", user.getPurchaseVideogames());

        return "userProfile";

    }
    
    @PostMapping("/userProfile")
    public String userProfile(Model model, HttpServletRequest request, @RequestParam String name,
                                @RequestParam String lastName, @RequestParam String nick, @RequestParam String email,
                                @RequestParam String creditCard){
                                    
        String useroName = request.getUserPrincipal().getName();
        Usero user = ur.findByName(useroName).orElseThrow();                            
        user.setName(name);
        user.setLastName(lastName);
        user.setNick(nick);
        user.setEmail(email);                            
        user.setCreditCard(creditCard);                            
        us.save(user);

        model.addAttribute("username", user.getName());
        model.addAttribute("nick", user.getNick());
        model.addAttribute("encodedPassword", user.getEncodedPassword());
        model.addAttribute("lastName", user.getLastName());
        model.addAttribute("creditCard", user.getCreditCard());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("Videogame", user.getPurchaseVideogames());

        return "userProfile";                            
    }

    @GetMapping("/signin")
    public String signin(Model model){

        return "signin";

    }


    @GetMapping("/showNews")
    public String showNews(Model model){
        
        return "showNews";

    }

    @GetMapping("/showVideogame")
    public String showVideogame(Model model){
        
        return "showVideogame";

    }

    @GetMapping("/videogame")
    public String videogame(Model model) {

        model.addAttribute("game_name" , "Battlefield 2042");

        return "videogame";
    }

    @ModelAttribute
	public void addAttributes(Model model, HttpServletRequest request) {

		Principal principal = request.getUserPrincipal();

		if (principal != null) {

			model.addAttribute("logged", true);
			model.addAttribute("userName", principal.getName());
			model.addAttribute("admin", request.isUserInRole("ADMIN"));

		} else {
			model.addAttribute("logged", false);
		}
	}
    @GetMapping("/usero/{id}/image")
	public ResponseEntity<Object> downloadImageUsero(@PathVariable long id) throws SQLException {

		Optional<Videogame> videogame = vs.findById(id);
		if (videogame.isPresent() && videogame.get().getImageFile() != null) {

			Resource file = new InputStreamResource(videogame.get().getImageFile().getBinaryStream());

			return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "image/PNG")
					.contentLength(videogame.get().getImageFile().length()).body(file);

		} else {
			return ResponseEntity.notFound().build();
		}
	}

}