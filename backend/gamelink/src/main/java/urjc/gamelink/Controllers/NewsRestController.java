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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
import urjc.gamelink.Service.NewsService;



    @RestController
    @RequestMapping("/api/news")
    public class NewsRestController {

        @Autowired
        private NewsService ns;


        ////////////////////////////////////////////////////////////////////////////////////////
        //////////////// News Section

        // Retruns all the news
        @GetMapping("/")
        public List<News> getNews() {

            return ns.findAll();
        }

        // Returns a page of news
        @GetMapping("/pages")
        public Page<News> findNewsPage(@RequestParam("page") int page) {

            int size = 9;
            Page<News> news = ns.findAll(PageRequest.of(page, size));

            return news;
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
        public ResponseEntity<News> updateNew(@PathVariable long id, @RequestBody News updatedNew)
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
        public ResponseEntity<News> deleteNew(@PathVariable long id) {

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
