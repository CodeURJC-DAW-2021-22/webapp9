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
import org.springframework.data.domain.Pageable;
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

    @GetMapping("/videogameStatistics/{page}")
    public String recommendedVideogamesShow(Model model, HttpServletRequest request, @PathVariable int page){
        
        String name = request.getUserPrincipal().getName();
        Usero userx = us.findByName(name).orElseThrow();
        
        Pageable paging = PageRequest.of(page, 9);
        Page<Videogame> videogames = vs.findRecomended(userx.getId(),paging); 

        model.addAttribute("games", videogames);


        return "videogameRecomended";

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

    @GetMapping("/showVideogame/{id}")
    public String showVideogame(Model model, @PathVariable long id){

        Optional <Videogame> videogame = vs.findById(id);

        if(videogame.isPresent()){
            model.addAttribute("videogame", videogame.get());
            model.addAttribute("new", videogame.get().getNotices());
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

        return "redirect:/videogame";
    }

}