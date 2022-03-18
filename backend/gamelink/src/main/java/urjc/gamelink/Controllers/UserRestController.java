package urjc.gamelink.Controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import urjc.gamelink.Model.Usero;
import urjc.gamelink.Repositories.UseroRepository;



@RestController
@RequestMapping("/api")
public class UserRestController {
	
	@Autowired
	private UseroRepository userRepository;

	@GetMapping("/me")
	public ResponseEntity<Usero> me(HttpServletRequest request) {
		
		Principal principal = request.getUserPrincipal();
		
		if(principal != null) {
			return ResponseEntity.ok(userRepository.findByName(principal.getName()).orElseThrow());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}