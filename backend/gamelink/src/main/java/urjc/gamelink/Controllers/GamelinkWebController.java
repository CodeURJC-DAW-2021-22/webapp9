package urjc.gamelink.Controllers;

import java.io.IOException;
import java.security.Principal;
import java.sql.Date;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


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

<<<<<<< HEAD
    @GetMapping("/news/{page}")
    public String ajaxMoreNewsLoad(Model model, HttpSession session, @PathVariable int page) {

        Page<News> news = ns.findAll(PageRequest.of(page, 9)); 
    
        model.addAttribute("new", news);

        return "newsTemplate";

    }

    @GetMapping("/videogames/{page}")
    public String ajaxMoreVideogamesLoad(Model model, HttpSession session, @PathVariable int page) {

        Page<Videogame> videogames = vs.findAll(PageRequest.of(page, 9)); 
    
        model.addAttribute("games", videogames);

        return "videogameTemplate";

    }

=======
>>>>>>> f635e8654a634cfe8e85bf08c814c2649f442266
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

    @GetMapping("/signin")
    public String signin(Model model){

        return "signin";
    }

    @PostMapping("/signin")
    public String signin(Model model, Usero user, @RequestParam (required = true) String name, @RequestParam String email, 
        @RequestParam String password, @RequestParam String nick, @RequestParam String lastName) throws IOException{

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
        setUsImage(user, "static/Photos/defaultProfilePhoto.jpg");
        user.setEncodedPassword(passwordEncoder.encode(password));
        

        us.save(user);

        return "home";

    }

    private void setUsImage(Usero user, String classpathResource) throws IOException {
        user.setImage(true);
        Resource image = new ClassPathResource(classpathResource);
        user.setImageFile(BlobProxy.generateProxy((image).getInputStream(), (image).contentLength()));
    }

}