package urjc.gamelink.Controllers;

import java.sql.SQLException;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import urjc.gamelink.Model.News;
import urjc.gamelink.Repositories.NewRepository;
import urjc.gamelink.Service.NewsService;
import urjc.gamelink.Service.VideogameService;

@Controller
public class GamelinkController {

    @Autowired
    private NewsService ns;

    @Autowired
    private VideogameService vs;

    private int pagina = 0;

    
    
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
    public String home(Model model, HttpSession session) {


        Page<News> news = ns.findAll(PageRequest.of(0, 3)); 
    
        model.addAttribute("new", news);


        return "home";
    }

    @GetMapping("/home/{page}")
    public String ajaxMoreNewsLoad(Model model, HttpSession session, @PathVariable int page) {

        Page<News> news = ns.findAll(PageRequest.of(page, 3)); 
    
        model.addAttribute("new", news);

        return "NewsTemplate";

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

	
    /*@GetMapping("/news")
    public String news(Model model){

        model.addAttribute("new", ns.findAll());
        
        return "news";

    }*/

    @GetMapping("/news")
    public String getNews(Model model, HttpSession session) {


        Page<News> news = ns.findAll(PageRequest.of(pagina, 3)); 
    

        model.addAttribute("next", news);

        model.addAttribute("hasPrev", news.hasPrevious());
        model.addAttribute("hasNext", news.hasNext());
        model.addAttribute("nextPage", news.getNumber()+1);
		model.addAttribute("prevPage", news.getNumber()-1);	

        return "news";
    }


    @GetMapping("/userProfile")
    public String userProfile(Model model){
        
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




}