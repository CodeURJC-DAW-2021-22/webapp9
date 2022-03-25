package urjc.gamelink.Controllers;

import java.io.IOException;
import java.security.Principal;
import java.sql.SQLException;
//import java.text.SimpleDateFormat;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import urjc.gamelink.Model.News;
import urjc.gamelink.Service.NewsService;
import urjc.gamelink.Service.VideogameService;

@Controller
public class NewsWebController {

    @Autowired
    private NewsService ns;

    @Autowired
    private VideogameService vs;

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

    @GetMapping("/news/{page}")
    public String ajaxMoreNewsLoad(Model model, HttpSession session, @PathVariable int page) {

        Page<News> news = ns.findAll(PageRequest.of(page, 9)); 
    
        model.addAttribute("new", news);

        return "newsTemplate";

    }

    @GetMapping("/news")
    public String getNews(Model model, HttpSession session) {


        Page<News> news = ns.findAll(PageRequest.of(0, 9)); 
    

        model.addAttribute("new", news);

        return "news";
    }

    @GetMapping("/showNews/{id}")
    public String showNews(Model model, @PathVariable long id){

        Optional <News> newx = ns.findById(id);
        if(newx.isPresent()){
            model.addAttribute("new", ns.findById(id).get());
            model.addAttribute("games", newx.get().getVideogamesRelated());
            model.addAttribute("id", id);
        }else{
            return "/";
        }
        

        return "showNews";

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
        news.setArgument("Pequeña descripción de tarjeta");
        ns.save(news);

        return "admin";
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

        return "redirect:/news";
    }



}
