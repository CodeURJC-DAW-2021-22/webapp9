package urjc.gamelink.Controllers;

import java.io.IOException;
import java.net.URI;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonView;

import org.aspectj.weaver.ast.And;
import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
import urjc.gamelink.Model.Videogame;
import urjc.gamelink.Service.NewsService;
import urjc.gamelink.Service.UseroService;
import urjc.gamelink.Service.VideogameService;


    
    @RestController
    @RequestMapping("/api/videogames")
    public class VideogamesRestController {

        @Autowired
        private VideogameService vs;

        @Autowired
        private UseroService us;

        @Autowired
        private NewsService ns;

        ////////////////////////////////////////////////////////////////////////////////////////
        //////////////// Videogame Section

        // Retruns all the videogames
        @GetMapping("/")
        public List<Videogame> getVideogames() {

            return vs.findAll();
        }

        // Returns a apge of videogames
        @GetMapping("/pages")
        public Page<Videogame> findVideogmamePage(@RequestParam("page") int page) {

            int size = 9;
            Page<Videogame> videogames = vs.findAll(PageRequest.of(page, size));

                return videogames;
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
        public ResponseEntity<Videogame> createVideogame(@RequestBody Videogame vg) {

            vs.save(vg);

            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(vg.getId()).toUri();
           
            return ResponseEntity.created(location).body(vg);

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

        //Add a new to the related news of a videogame
        @PutMapping("/{id}/addRelatedNew/{idn}")
        public ResponseEntity<List<News>> addRelatedNew(@PathVariable long id,@PathVariable long idn){
            if(vs.exist(id) && ns.exist(idn)){
                Videogame vg = vs.findById(id).get();
                vg.appendNew(ns.findById(idn).get());
                vg.setId(id);
                vs.save(vg);
                return new ResponseEntity<>(vg.getNotices(),HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
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

        // Asign a purchase to a user
        @PutMapping("/{id}/purchase/{usId}")
        public ResponseEntity<Object> purchaseVideogame(@PathVariable long id, @PathVariable long usId) {

            Usero user = us.findById(usId).orElseThrow();
            Optional<Videogame> vg = vs.findById(id);

            if (vg.isPresent()) {
                vg.get().setOnePurchaseVideogame(user);
                vg.get().setId(id);
                vs.save(vg.get());

                return new ResponseEntity<>(user.getPurchaseVideogames(), HttpStatus.OK);

            } else {

                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        }


    }

