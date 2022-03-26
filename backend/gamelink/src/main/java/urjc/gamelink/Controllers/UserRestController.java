package urjc.gamelink.Controllers;

import java.io.IOException;
import java.net.URI;
import java.security.Principal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;

import urjc.gamelink.Model.News;
import urjc.gamelink.Model.Usero;
import urjc.gamelink.Model.Videogame;
import urjc.gamelink.Service.UseroService;
import urjc.gamelink.Service.VideogameService;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    @Autowired
    private UseroService us;

    @Autowired
    private VideogameService vs;

    @Autowired
    private PasswordEncoder passwordEncoder;

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
    public ResponseEntity<Usero> createUser(Usero user, @RequestParam String password) {

        user.setEncodedPassword(passwordEncoder.encode(password));
        ArrayList<String> list = new ArrayList<>();
        list.add("USERO");
        user.setRoles(list);
        us.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId())
                .toUri();

        return ResponseEntity.created(location).body(user);
    }

    // Modifies a user
    @PutMapping("/{id}")
    public ResponseEntity<Usero> updateUser(@PathVariable long id, Usero updatedUser)
            throws SQLException {

        if (us.exist(id)) {
            Usero user = us.findById(id).orElseThrow();
            if (updatedUser.getImage()) {
                if (user.getImage()) {
                    updatedUser.setImageFile(BlobProxy.generateProxy(user.getImageFile().getBinaryStream(),
                            user.getImageFile().length()));
                }
            }

            updatedUser.setRoles(user.getRoles());
            updatedUser.setCreditCard(user.getCreditCard());
            updatedUser.setEncodedPassword(user.getEncodedPassword());
            updatedUser.setId(id);
            us.save(updatedUser);

            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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

    // Update user password
    @PutMapping("/{id}/password")
    public ResponseEntity<Object> upadatePassword(@PathVariable long id, @RequestParam String password) {

        Optional<Usero> user = us.findById(id);
        if (user.isPresent()) {
            user.get().setEncodedPassword(passwordEncoder.encode(password));
            user.get().setId(id);
            us.save(user.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    // Add user a credit card
    @PostMapping("/{id}/creditCard")
    public ResponseEntity<Object> addCreditCard(@PathVariable long id, @RequestParam String creditCard) {

        Optional<Usero> user = us.findById(id);
        if (user.isPresent()) {
            user.get().setCreditCard(creditCard);
            user.get().setId(id);
            us.save(user.get());
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    // Add user a credit card
    @PutMapping("/{id}/creditCard")
    public ResponseEntity<Object> updateCreditCard(@PathVariable long id, @RequestParam String creditCard) {

        Optional<Usero> user = us.findById(id);
        if (user.isPresent()) {
            user.get().setCreditCard(creditCard);
            user.get().setId(id);
            us.save(user.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    // Returns the data of the videogames of a user
    @GetMapping("/purchases/{id}")
    public ResponseEntity<List<Videogame>> getUserVideogames(@PathVariable long id) {
        Optional<Usero> user = us.findById(id);
        if (user.isPresent()) {
            List<Videogame> vgs = user.get().getPurchaseVideogames();
            return new ResponseEntity<>(vgs, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Returns the data of the news of a user
    @GetMapping("/readNews/{id}")
    public ResponseEntity<List<News>> getUserReadNews(@PathVariable long id) {
        Optional<Usero> user = us.findById(id);
        if (user.isPresent()) {
            List<News> news = user.get().getReadNotices();
            return new ResponseEntity<>(news, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    // Find recommended videogames
    @GetMapping("/{id}/recommendations")
    public ResponseEntity<List<Videogame>> findRecomended(@PathVariable long id) {

        Optional<Usero> user = us.findById(id);
        if (user.isPresent()) {
            List<Videogame> videogames = vs.findRecomended2(id);
            return new ResponseEntity<>(videogames, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/me")
    public ResponseEntity<Usero> me(HttpServletRequest request) {

        Principal principal = request.getUserPrincipal();

        if (principal != null) {
            return ResponseEntity.ok(us.findByName(principal.getName()).orElseThrow());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}