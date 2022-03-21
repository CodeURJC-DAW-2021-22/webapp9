package urjc.gamelink.Controllers;

import java.io.IOException;
import java.security.Principal;
import java.sql.Date;
import java.sql.SQLException;
//import java.text.SimpleDateFormat;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
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
import urjc.gamelink.Service.NewsService;
import urjc.gamelink.Service.UseroService;
import urjc.gamelink.Service.VideogameService;

@Controller
public class GamelinkWebController {

    @Autowired
    private NewsService ns;

    @Autowired
    private VideogameService vs;

    @Autowired
    private UseroService us;

    @Autowired
	private PasswordEncoder passwordEncoder;
    
    @ModelAttribute
	public void addAttributes(Model model, HttpServletRequest request) {

		Principal principal = request.getUserPrincipal();

		if (principal != null) {

			model.addAttribute("logged", true);
			model.addAttribute("userName", principal.getName());
			model.addAttribute("isAdmin", request.isUserInRole("ADMIN"));

		} else {
			model.addAttribute("logged", false);
		}
	}

    @GetMapping("/")
    public String home(Model model, HttpSession session) {


        Page<News> news = ns.findAll(PageRequest.of(0, 3)); 
    
        model.addAttribute("new", news);


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

    @GetMapping("/paymentConfirmation/{id}")
    public String paymentConfirmation(Model model, HttpServletRequest request, @PathVariable long id){
        String name = request.getUserPrincipal().getName();
        Usero user = us.findByName(name).orElseThrow();
        //SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        model.addAttribute("date",date);
        Optional <Videogame> videogame = vs.findById(id);

        if(videogame.isPresent()){
            model.addAttribute("videogame", videogame.get());
        }else{
            return "redirect:/";
        }

        model.addAttribute("user", user);
        return "paymentConfirmation";

    }

    @GetMapping("/payment/{id}")
    public String paymentConfirmation2(Model model, HttpServletRequest request, @PathVariable long id){
        String name = request.getUserPrincipal().getName();
        Usero user = us.findByName(name).orElseThrow();
        Optional <Videogame> videogame = vs.findById(id);
        videogame.get().setOnePurchaseVideogame(user);
        us.save(user);
        return "redirect:/";
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


    @GetMapping("/userProfile")
    public String userProfile(Model model, HttpServletRequest request){

        String name = request.getUserPrincipal().getName();
        Usero user = us.findByName(name).orElseThrow();
        model.addAttribute("username", user.getName());
        model.addAttribute("nick", user.getNick());
        model.addAttribute("encodedPassword", user.getEncodedPassword());
        model.addAttribute("lastName", user.getLastName());
        model.addAttribute("creditCard", user.getCreditCard());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("Videogame", user.getPurchaseVideogames());
        model.addAttribute("id", user.getId());

        return "userProfile";

    }
    
    @PostMapping("/userProfile")
    public String userProfile(Model model, HttpServletRequest request, @RequestParam String nick, @RequestParam String email,
                                @RequestParam String creditCard, MultipartFile imageField) throws IOException{
                                    
        String useroName = request.getUserPrincipal().getName();
        Usero user = us.findByName(useroName).orElseThrow();  
        user.setNick(nick);
        user.setEmail(email);                            
        user.setCreditCard(creditCard);

        if(!imageField.isEmpty()){
            user.setImageFile(BlobProxy.generateProxy(imageField.getInputStream(), imageField.getSize()));
            user.setImage(true);
        }  

        us.save(user);


        return "redirect:/userProfile";                            
    }

    @GetMapping("/signin")
    public String signin(Model model){

        return "signin";
    }

    @PostMapping("/signin")
    public String signin(Model model, Usero user, @RequestParam (required = true) String name, @RequestParam String email, 
        @RequestParam String password, @RequestParam String nick, @RequestParam String lastName){

        if (name.equals("") || name == null){
            return "errorMessage";
        }

        ArrayList<String> lista = new ArrayList<>();
        lista.add("USERO");
        user.setName(name);
        user.setEmail(email);
        user.setNick(nick);
        user.setLastName(lastName);
        user.setRoles(lista);
        user.setEncodedPassword(passwordEncoder.encode(password));
        

        us.save(user);

        return "home";

    }

    @GetMapping("/profile/{id}/image")
	public ResponseEntity<Object> downloadImageProfile(@PathVariable long id) throws SQLException {

		Optional<Usero> user = us.findById(id);
		if (user.isPresent() && user.get().getImageFile() != null) {

			Resource file = new InputStreamResource(user.get().getImageFile().getBinaryStream());

			return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "image/PNG")
					.contentLength(user.get().getImageFile().length()).body(file);

		} else {
			return ResponseEntity.notFound().build();
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

    @GetMapping("/showVideogameUser/{id}")
    public String videogamePurchaseUser(Model model, HttpServletRequest request, @PathVariable long id) {
        Principal principal = request.getUserPrincipal();

        if (principal != null) {
            return "redirect:/paymentConfirmation/"+ id;
        } else {
            return "redirect:/errorMessage";
        }
    } 

}