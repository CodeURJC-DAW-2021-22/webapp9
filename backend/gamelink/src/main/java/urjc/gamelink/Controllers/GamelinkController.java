package urjc.gamelink.Controllers;

import java.io.IOException;
import java.security.Principal;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
//import javax.smartcardio.CardTerminals.State;

import org.hibernate.engine.jdbc.BlobProxy;
import org.jboss.jandex.VoidType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import urjc.gamelink.Model.News;
import urjc.gamelink.Repositories.NewRepository;
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

    @Autowired
	private PasswordEncoder passwordEncoder;


    
     //this will show admin mode (if the user is and admin) and userProfile (if user is registrated)
    @ModelAttribute
	public void showAdminMode(Model model, HttpServletRequest request) {
		Principal principal = request.getUserPrincipal();

		if (principal != null) {

			model.addAttribute("logged", true);
			model.addAttribute("isAdmin", request.isUserInRole("ADMIN")); //look for 'ADMIN' in the database of the user

		} else {
			model.addAttribute("logged", false);
		}
	}

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


    @GetMapping("/videogame/{id}/imageVg") //this will download the videogame photo
	public ResponseEntity<Object> downloadImageVideogame(@PathVariable long id) throws SQLException {

		Optional<Videogame> videogame = vs.findById(id);
		if (videogame.isPresent() && videogame.get().getImageFile() != null) {

			Resource file = new InputStreamResource(videogame.get().getImageFile().getBinaryStream());

			return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "imageVg/PNG")
					.contentLength(videogame.get().getImageFile().length()).body(file);

		} else {
			return ResponseEntity.notFound().build();
		}
	}

    @GetMapping("/videogame/{id}/imageCompany") //this will download the company photo (videogame)
	public ResponseEntity<Object> downloadImageCompany(@PathVariable long id) throws SQLException {

		Optional<Videogame> videogame = vs.findById(id);
		if (videogame.isPresent() && videogame.get().getImageCompanyFile() != null) {

			Resource file = new InputStreamResource(videogame.get().getImageCompanyFile().getBinaryStream());

			return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "imageCompany/PNG")
					.contentLength(videogame.get().getImageCompanyFile().length()).body(file);

		} else {
			return ResponseEntity.notFound().build();
		}
	}

    @GetMapping("/")
    public String home(Model model, HttpSession session) {


        Page<News> news = ns.findAll(PageRequest.of(0, 3)); 
    
        model.addAttribute("new", news);


        return "home";
    }

    @GetMapping("/news/{page}")
    public String ajaxMoreNewsLoad(Model model, HttpSession session, @PathVariable int page) {

        Page<News> news = ns.findAll(PageRequest.of(page, 9)); 
    
        model.addAttribute("new", news);

        return "NewsTemplate";

    }

    @GetMapping("/videogames/{page}")
    public String ajaxMoreVideogamesLoad(Model model, HttpSession session, @PathVariable int page) {

        Page<Videogame> videogames = vs.findAll(PageRequest.of(page, 9)); 
    
        model.addAttribute("games", videogames);

        return "videogameTemplate";

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
    public String getNews(Model model, HttpSession session) {


        Page<News> news = ns.findAll(PageRequest.of(0, 9)); 
    

        model.addAttribute("new", news);

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
        model.addAttribute("id", user.getId());

        return "userProfile";

    }
    
    @PostMapping("/userProfile")
    public String userProfile(Model model, HttpServletRequest request, @RequestParam String name,
                                @RequestParam String lastName, @RequestParam String nick, @RequestParam String email,
                                @RequestParam String creditCard, MultipartFile imageField) throws IOException{
                                    
        String useroName = request.getUserPrincipal().getName();
        Usero user = ur.findByName(useroName).orElseThrow();                            
        user.setName(name);
        user.setLastName(lastName);
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
    public String signin(Model model, Usero user, @RequestParam String password){

        ArrayList<String> lista = new ArrayList<>();
        lista.add("USERO");
        user.setRoles(lista);
        user.setEncodedPassword(passwordEncoder.encode(password));
        

        us.save(user);

        return "home";

    }


    @GetMapping("/showNews/{id}")
    public String showNews(Model model, @PathVariable long id){

        Optional <News> newx = ns.findById(id);
        if(newx.isPresent()){
            model.addAttribute("new", ns.findById(id).get());
        }else{
            return "/";
        }
        

        return "showNews";

    }

    @GetMapping("/showVideogame/{id}")
    public String showVideogame(Model model, @PathVariable long id){

        Optional <Videogame> videogame = vs.findById(id);

        if(videogame.isPresent()){
            model.addAttribute("videogame", videogame.get());
            model.addAttribute("id", id);
        }

        
        return "showVideogame";

    }

    @GetMapping("/videogame")
    public String videogame(Model model) {

        Page<Videogame> videogames = vs.findAll(PageRequest.of(0, 9)); 
    

        model.addAttribute("games", videogames);


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

    @GetMapping("/createNew")
    public String createNew(Model model) {


        model.addAttribute("videogame", vs.findAll());

        return "createNew";
    }

    @PostMapping("/createNew")
    public String createNewForm(Model model, News news, MultipartFile imageField, @RequestParam(required = false) List<Long> relatedGame)
            throws IOException {

        if (!imageField.isEmpty()) {
            news.setImageFile(BlobProxy.generateProxy(imageField.getInputStream(), imageField.getSize()));
            news.setImage(true);
        }

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        news.setDate(dtf.format(now));

        if (relatedGame != null) {
            news.setVideogamesRelated(vs.findByIds(relatedGame));
        }

        ns.save(news);

        return "Admin";
    }

    @GetMapping("/createVideogame")
    public String createVideogame(Model model) {

        model.addAttribute("news", ns.findAll());

        return "createVideogame";
    }

    @PostMapping("/createVideogame")
    public String createVideogameForm(Model model, Videogame videogame,@RequestParam(name = "imageField") MultipartFile imageField, @RequestParam(name ="companyField") MultipartFile companyField, @RequestParam(required = false) List<Long> notices) throws IOException {

        if (!imageField.isEmpty()) {
            videogame.setImageFile(BlobProxy.generateProxy(imageField.getInputStream(), imageField.getSize()));
            videogame.setImage(true);
        }

        if (!companyField.isEmpty()) {
            videogame.setImageCompanyFile(BlobProxy.generateProxy(companyField.getInputStream(), companyField.getSize()));
            videogame.setImageCompany(true);
        }
        
        if (notices!=null) {
            videogame.setNotices(ns.findByIds(notices));
        }

        vs.save(videogame);

        return "Admin";
    }

    @GetMapping("/editVg/{id}")
    public String editVideogame(Model model, @PathVariable long id){

        Optional <Videogame> videogame = vs.findById(id);

        if(videogame.isPresent()){
            model.addAttribute("videogame", videogame.get());
        }

        model.addAttribute("news", ns.findAll());
        


        return "editVideogame";
    }

    @PostMapping("/editVg/{id}")
    public String editVideogameForm(Model model, Videogame videogame, @PathVariable long id, @RequestParam(name = "imageField") MultipartFile imageField, @RequestParam(name ="imageField1") MultipartFile companyField, @RequestParam(required = false) List<Long> notices) throws IOException{

            Optional<Videogame> aux = vs.findById(id);

            if(!imageField.isEmpty() ){
                videogame.setImageFile(BlobProxy.generateProxy(imageField.getInputStream(), imageField.getSize()));
                
            }else{
                videogame.setImageFile(aux.get().getImageFile());
                videogame.setImage(true);
            }

            if (!companyField.isEmpty()) {
                videogame.setImageCompanyFile(BlobProxy.generateProxy(companyField.getInputStream(), companyField.getSize()));
                
            }else{
                videogame.setImageCompanyFile(aux.get().getImageCompanyFile());
                videogame.setImageCompany(true);
            }

            if(notices != null){
                videogame.setNotices(ns.findByIds(notices));
            }


        videogame.setId(id);

        vs.save(videogame);

        return "redirect:/showVideogame/" + id;
    }

    @GetMapping("/deleteVg/{id}")
    public String deleteVideogame(Model model, @PathVariable long id){
   
        Optional<Videogame> videogame = vs.findById(id);
		if (videogame.isPresent()) {
			vs.delete(id);
		}

        return "videogame";
    }

    @GetMapping("/editNew/{id}")
    public String editNew(Model model, @PathVariable long id){

        Optional <News> newx = ns.findById(id);

        if(newx.isPresent()){
            model.addAttribute("new", newx.get());
        }

        model.addAttribute("videogame", vs.findAll());
        


        return "editNew";
    }

    @PostMapping("/editNew/{id}")
    public String editNewForm(Model model, News newx, @PathVariable long id, MultipartFile imageField, @RequestParam(required = false) List<Long> videogames) throws IOException{

        Optional<News> aux = ns.findById(id);

        if(!imageField.isEmpty()){
            newx.setImageFile(BlobProxy.generateProxy(imageField.getInputStream(), imageField.getSize()));
            newx.setImage(true);
        }else{
            if(aux.isPresent()){
                newx.setImageFile(aux.get().getImageFile());
                newx.setImage(true);
            }

        }
        
        if (videogames != null) {
            newx.setVideogamesRelated(vs.findByIds(videogames));
        }

        newx.setId(id);

        ns.save(newx);

        return "redirect:/showNews/" + id;
    }

    @GetMapping("/deleteNew/{id}")
    public String deleteNew(Model model, @PathVariable long id){
   
        Optional<News> newx = ns.findById(id);
		if (newx.isPresent()) {
			ns.delete(id);
		}

        return "news";
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


}