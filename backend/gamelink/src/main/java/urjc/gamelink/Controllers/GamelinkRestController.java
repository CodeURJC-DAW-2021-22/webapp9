package urjc.gamelink.Controllers;

import java.io.IOException;
import java.net.URI;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

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
import urjc.gamelink.Model.Videogame;
import urjc.gamelink.Service.NewsService;
import urjc.gamelink.Service.UseroService;
import urjc.gamelink.Service.VideogameService;

public class GamelinkRestController {

    @RestController
    @RequestMapping("/api/videogames")
    public class VideogamesRestController {

        @Autowired
        private NewsService ns;

        @Autowired
        private VideogameService vs;

        @Autowired
        private UseroService us;

        ////////////////////////////////////////////////////////////////////////////////////////
        //////////////// Videogame Section

        // Retruns all the videogames
        @GetMapping("/")
        public List<Videogame> getVideogames() {

            return vs.findAll();
        }

        // Retruns a videogame
        @GetMapping("/{id}")
        public ResponseEntity<Videogame> getVideogame(@PathVariable long id) {
            Optional<Videogame> videogame = vs.findById(id);
            if (videogame.isPresent()) {
                Videogame vg = videogame.get();
                return new ResponseEntity<>(vg, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        }

        // Creates a videogame
        @PostMapping("/")
        @ResponseStatus(HttpStatus.CREATED)
        public Videogame createVideogame(@RequestBody Videogame vg) {

            vs.save(vg);

            return vg;
        }

        // Modifies a videogame
        @PutMapping("/{id}")
        public ResponseEntity<Videogame> updateVideogame(@PathVariable long id, @RequestBody Videogame updatedVg)
                throws SQLException {

            if (vs.exist(id)) {
                if (updatedVg.getImage()) {
                    Videogame vg = vs.findById(id).orElseThrow();
                    if (vg.getImage()) {
                        updatedVg.setImageFile(BlobProxy.generateProxy(vg.getImageFile().getBinaryStream(),
                                vg.getImageFile().length()));
                    }
                }

                updatedVg.setId(id);
                vs.save(updatedVg);

                return new ResponseEntity<>(updatedVg, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        // Deletes a videogame
        @DeleteMapping("/{id}")
        public ResponseEntity<Videogame> deleteVideogame(@PathVariable long id) {

            try {
                vs.delete(id);
                return new ResponseEntity<>(null, HttpStatus.OK);

            } catch (EmptyResultDataAccessException e) {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        }

        // Uploads an image to videogame image
        @PostMapping("/{id}/image")
        public ResponseEntity<Videogame> uploadVgImage(@PathVariable long id, @RequestParam MultipartFile imageFile)
                throws IOException {

            Videogame vg = vs.findById(id).orElseThrow();

            URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();

            vg.setImage(true);
            vg.setImageFile(BlobProxy.generateProxy(imageFile.getInputStream(), imageFile.getSize()));
            vs.save(vg);

            return ResponseEntity.created(location).build();
        }

        // Downloads an image of videogame image
        @GetMapping("/{id}/image")
        public ResponseEntity<Object> downloadVgImage(@PathVariable long id) throws SQLException {

            Videogame vg = vs.findById(id).orElseThrow();

            if (vg.getImageFile() != null) {

                Resource file = new InputStreamResource(vg.getImageFile().getBinaryStream());

                return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
                        .contentLength(vg.getImageFile().length()).body(file);

            } else {
                return ResponseEntity.notFound().build();
            }
        }

        // Deletes an image of a videogame image
        @DeleteMapping("/{id}/image")
        public ResponseEntity<Object> deleteVgImage(@PathVariable long id) {

            Videogame vg = vs.findById(id).orElseThrow();

            vg.setImageFile(null);
            vg.setImage(false);

            vs.save(vg);

            return ResponseEntity.noContent().build();
        }

        // Uploads an image to videogame company image
        @PostMapping("/{id}/companyImage")
        public ResponseEntity<Videogame> uploadVgCompanyImage(@PathVariable long id,
                @RequestParam MultipartFile imageFile)
                throws IOException {

            Videogame vg = vs.findById(id).orElseThrow();

            URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();

            vg.setImageCompany(true);
            vg.setImageCompanyFile(BlobProxy.generateProxy(imageFile.getInputStream(), imageFile.getSize()));
            vs.save(vg);

            return ResponseEntity.created(location).build();
        }

        // Downloads an image of videogame company image
        @GetMapping("/{id}/companyImage")
        public ResponseEntity<Object> downloadVgCompanyImage(@PathVariable long id) throws SQLException {

            Videogame vg = vs.findById(id).orElseThrow();

            if (vg.getImageCompanyFile() != null) {

                Resource file = new InputStreamResource(vg.getImageCompanyFile().getBinaryStream());

                return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
                        .contentLength(vg.getImageCompanyFile().length()).body(file);

            } else {
                return ResponseEntity.notFound().build();
            }
        }

        // Deletes an image of a videogame company image
        @DeleteMapping("/{id}/companyImage")
        public ResponseEntity<Object> deleteVgCompanyImage(@PathVariable long id) {

            Videogame vg = vs.findById(id).orElseThrow();

            vg.setImageCompanyFile(null);
            vg.setImageCompany(false);

            vs.save(vg);

            return ResponseEntity.noContent().build();
        }
        
        ////////////////////////////////////////////////////////////////////////////////////////
        //////////////// Chars data Section

        @GetMapping("/stats/genres")
        public List<Object> graphic() {

            return us.findByGenre();
        }

        @GetMapping("/stats/sales")
        public List<Object> graphic2() {
            return us.findBySold();
        }
    }
    
    @RestController
    @RequestMapping("/api/news")
    public class NewsRestController {
        ////////////////////////////////////////////////////////////////////////////////////////
        //////////////// News Section

        // Retruns all the news
        @GetMapping("/")
        public List<News> getNews() {

            return ns.findAll();
        }

        // Retruns a new
        @GetMapping("/{id}")
        public ResponseEntity<News> getNew(@PathVariable long id) {
            Optional<News> newx = ns.findById(id);
            if (newx.isPresent()) {
                News ns = newx.get();
                return new ResponseEntity<>(ns, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        }

        // Creates a new
        @PostMapping("/")
        @ResponseStatus(HttpStatus.CREATED)
        public News createNew(@RequestBody News newx) {

            ns.save(newx);

            return newx;
        }

        // Modifies a new
        @PutMapping("/{id}")
        public ResponseEntity<News> updateBook(@PathVariable long id, @RequestBody News updatedNew)
                throws SQLException {

            if (ns.exist(id)) {
                if (updatedNew.getImage()) {
                    News newx = ns.findById(id).orElseThrow();
                    if (newx.getImage()) {
                        updatedNew.setImageFile(BlobProxy.generateProxy(newx.getImageFile().getBinaryStream(),
                                newx.getImageFile().length()));
                    }
                }

                updatedNew.setId(id);
                ns.save(updatedNew);

                return new ResponseEntity<>(updatedNew, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        // Deletes a new
        @DeleteMapping("/{id}")
        public ResponseEntity<News> deleteBook(@PathVariable long id) {

            try {
                ns.delete(id);
                return new ResponseEntity<>(null, HttpStatus.OK);

            } catch (EmptyResultDataAccessException e) {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        }

        // Uploads an image to new image
        @PostMapping("/{id}/image")
        public ResponseEntity<News> uploadNewImage(@PathVariable long id,
                @RequestParam MultipartFile imageFile)
                throws IOException {

            News newx = ns.findById(id).orElseThrow();

            URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();

            newx.setImage(true);
            newx.setImageFile(BlobProxy.generateProxy(imageFile.getInputStream(), imageFile.getSize()));
            ns.save(newx);

            return ResponseEntity.created(location).build();
        }

        // Downloads an image of new image
        @GetMapping("/{id}/image")
        public ResponseEntity<Object> downloadNewImage(@PathVariable long id) throws SQLException {

            News newx = ns.findById(id).orElseThrow();

            if (newx.getImageFile() != null) {

                Resource file = new InputStreamResource(newx.getImageFile().getBinaryStream());

                return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
                        .contentLength(newx.getImageFile().length()).body(file);

            } else {
                return ResponseEntity.notFound().build();
            }
        }

        // Deletes an image of a new image
        @DeleteMapping("/{id}/image")
        public ResponseEntity<Object> deleteNewImage(@PathVariable long id) {

            News newx = ns.findById(id).orElseThrow();

            newx.setImageFile(null);
            newx.setImage(false);

            ns.save(newx);

            return ResponseEntity.noContent().build();
        }

    }
    
    @RestController
    @RequestMapping("/api/users")
    public class NewsRestController {
        
        @GetMapping("/")
        public List<Usero> getUsers() {

            return us.findAll();
        }

        // Retruns a user
        @GetMapping("/{id}")
        public ResponseEntity<Usero> getUser(@PathVariable long id) {
            Optional<Usero> user = us.findById(id);
            if (user.isPresent()) {
                Usero userx = usero.get();
                return new ResponseEntity<>(userx, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        }

        // Creates a user
        @PostMapping("/")
        @ResponseStatus(HttpStatus.CREATED)
        public News createUser(@RequestBody Usero user) {

            ns.save(user);

            return user;
        }

        // Modifies a user
        @PutMapping("/{id}")
        public ResponseEntity<News> updateBook(@PathVariable long id, @RequestBody Usero updatedUser)
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
        public ResponseEntity<News> deleteBook(@PathVariable long id) {

            try {
                us.delete(id);
                return new ResponseEntity<>(null, HttpStatus.OK);

            } catch (EmptyResultDataAccessException e) {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        }
        
      // Uploads an image to user image
        @PostMapping("/{id}/image")
        public ResponseEntity<Usero> uploadNewImage(@PathVariable long id,
                @RequestParam MultipartFile imageFile)
                throws IOException {

            Usero user = us.findById(id).orElseThrow();

            URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();

            user.setImage(true);
            user.setImageFile(BlobProxy.generateProxy(imageFile.getInputStream(), imageFile.getSize()));
            us.save(usero);

            return ResponseEntity.created(location).build();
        }

        // Downloads an image of user image
        @GetMapping("/{id}/image")
        public ResponseEntity<Object> downloadNewImage(@PathVariable long id) throws SQLException {

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
        public ResponseEntity<Object> deleteNewImage(@PathVariable long id) {

            Usero user = us.findById(id).orElseThrow();

            user.setImageFile(null);
            user.setImage(false);

            us.save(user);

            return ResponseEntity.noContent().build();
        }
    }
        
}
