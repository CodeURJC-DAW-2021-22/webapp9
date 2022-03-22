package urjc.gamelink.Controllers;

import java.io.IOException;
import java.net.URI;
import java.security.Principal;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import urjc.gamelink.Model.News;
import urjc.gamelink.Model.Usero;
import urjc.gamelink.Repositories.UseroRepository;
import urjc.gamelink.Service.UseroService;



@RestController
@RequestMapping("/api/users")
public class UserRestController {
	
	@Autowired
	private UseroService us;

        
        @GetMapping("/")
        public List<Usero> getUsers() {

            return us.findAll();
        }

        // Retruns a user
        @GetMapping("/{id}")
        public ResponseEntity<Usero> getUser(@PathVariable long id) {
            Optional<Usero> user = us.findById(id);
            if (user.isPresent()) {
                Usero userx = user.get();
                return new ResponseEntity<>(userx, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        }

        // Creates a user
        @PostMapping("/")
        @ResponseStatus(HttpStatus.CREATED)
        public Usero createUser(@RequestBody Usero user) {

            us.save(user);

            return user;
        }

        // Modifies a user
        @PutMapping("/{id}")
        public ResponseEntity<Usero> updateUser(@PathVariable long id, @RequestBody Usero updatedUser)
                throws SQLException {

            if (us.exist(id)) {
                if (updatedUser.getImage()) {
                    Usero user = us.findById(id).orElseThrow();
                    if (user.getImage()) {
                        updatedUser.setImageFile(BlobProxy.generateProxy(user.getImageFile().getBinaryStream(),
                                user.getImageFile().length()));
                    }
                }

                updatedUser.setId(id);
                us.save(updatedUser);

                return new ResponseEntity<>(updatedUser, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        // Deletes a user
        @DeleteMapping("/{id}")
        public ResponseEntity<News> deleteUser(@PathVariable long id) {

            try {
                us.delete(id);
                return new ResponseEntity<>(null, HttpStatus.OK);

            } catch (EmptyResultDataAccessException e) {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        }
        
      // Uploads an image to user image
        @PostMapping("/{id}/image")
        public ResponseEntity<Usero> uploadUserImage(@PathVariable long id,
                @RequestParam MultipartFile imageFile)
                throws IOException {

            Usero user = us.findById(id).orElseThrow();

            URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();

            user.setImage(true);
            user.setImageFile(BlobProxy.generateProxy(imageFile.getInputStream(), imageFile.getSize()));
            us.save(user);

            return ResponseEntity.created(location).build();
        }

        // Downloads an image of user image
        @GetMapping("/{id}/image")
        public ResponseEntity<Object> downloadUserImage(@PathVariable long id) throws SQLException {

            Usero user = us.findById(id).orElseThrow();

            if (user.getImageFile() != null) {

                Resource file = new InputStreamResource(user.getImageFile().getBinaryStream());

                return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
                        .contentLength(user.getImageFile().length()).body(file);

            } else {
                return ResponseEntity.notFound().build();
            }
        }

        // Deletes an image of a user image
        @DeleteMapping("/{id}/image")
        public ResponseEntity<Object> deleteUserImage(@PathVariable long id) {

            Usero user = us.findById(id).orElseThrow();

            user.setImageFile(null);
            user.setImage(false);

            us.save(user);

            return ResponseEntity.noContent().build();
        }
        

    
	@GetMapping("/me")
	public ResponseEntity<Usero> me(HttpServletRequest request) {
		
		Principal principal = request.getUserPrincipal();
		
		if(principal != null) {
			return ResponseEntity.ok(us.findByName(principal.getName()).orElseThrow());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}