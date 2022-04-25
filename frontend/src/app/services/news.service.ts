import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { News } from '../models/new.model';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

const URL = '/api/news/';

@Injectable({ providedIn: 'root' })
export class NewsService {

    constructor(private httpClient: HttpClient) { }


    /*@GetMapping("/")
    public List<News> getNews() {

        return ns.findAll();
    }*/

    getNews(): Observable<News[]> {
      return this.httpClient.get(URL).pipe(
        catchError((error: any) => this.handleError(error))
      ) as Observable<News[]>;
    }

    /*@GetMapping("/pages")
    public Page<News> findNewsPage(@RequestParam("page") int page) {

        int size = 9;
        Page<News> news = ns.findAll(PageRequest.of(page, size));

        return news;
    }*/

    findNewsPage() {
      return this.httpClient.get(URL + "pages");
    }

    /*@GetMapping("/{id}")
    public ResponseEntity<News> getNew(@PathVariable long id) {
        Optional<News> newx = ns.findById(id);
        if (newx.isPresent()) {
            News ns = newx.get();
            return new ResponseEntity<>(ns, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }*/

    //getNewById
    getNew(id: number): Observable<News> {
      return this.httpClient.get(URL + id).pipe(
        catchError((error: any) => this.handleError(error))
      ) as Observable<News>;
    }

    /*@PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<News> createVideogame(@RequestBody News news) {

        ns.save(news);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(news.getId())
                .toUri();

        return ResponseEntity.created(location).body(news);

    }*/

    //addNew
    createNew(news: News) {

      if (!news.id) { //if dont exists, this method creates a new book
        return this.httpClient.post(URL, news)
          .pipe(
            //catchError(error => this.handleError(error))
          );
      } else { //else, if exists, this method update the existing book
        return this.httpClient.put(URL + news.id, news).pipe( //put(location, object to be located in the location) (en lo primero mete lo segundo, vamos)
          catchError((error: any) => this.handleError(error))
        );
      }
    }

    /*
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
    */

    updateNew(news: News){
      return this.httpClient.put(URL + news.id, news).pipe(
        catchError((error: any) => this.handleError(error))
      );
    }

    /*
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
    */

    deleteNew(news: News) {
      return this.httpClient.delete(URL + news.id).pipe(
        catchError((error: any) => this.handleError(error))
      );
    }

    /*
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
    */

    uploadNewImage(news: News, formData: FormData) {
      return this.httpClient.post(URL + news.id + '/image', formData)
        .pipe(
          catchError((error: any) => this.handleError(error))
        );
    }

    /*
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
    */

    downloadNewImage(news: News) {
      return this.httpClient.get(URL + news.id + '/image')
        .pipe(
          catchError((error: any) => this.handleError(error))
        );
    }

    /*
    // Deletes an image of a new image
    @DeleteMapping("/{id}/image")
    public ResponseEntity<Object> deleteNewImage(@PathVariable long id) {

        News newx = ns.findById(id).orElseThrow();

        newx.setImageFile(null);
        newx.setImage(false);

        ns.save(newx);

        return ResponseEntity.noContent().build();
    }
    */

    deleteNewImage(news: News) {
      return this.httpClient.delete(URL + news.id + '/image')
        .pipe(
          catchError((error: any) => this.handleError(error)) //en esta versión de angular tenemos que definir todas las variables
        );
    }

    //Duda terminar

    /*
    // Asign a purchase to a user
    @PutMapping("/{id}/read/{usId}")
    public ResponseEntity<Object> readNew(@PathVariable long id, @PathVariable long usId) {

        Usero user = us.findById(usId).orElseThrow();
        Optional<News> news = ns.findById(id);

        if (news.isPresent()) {
            news.get().setOneReadNew(user);
            news.get().setId(id);
            ns.save(news.get());

            return new ResponseEntity<>(user.getReadNotices(), HttpStatus.OK);

        } else {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    */

    private handleError(error: any) {
      console.log("ERROR:");
      console.error(error);
      return throwError("Server error (" + error.status + "): " + error.text())
    }

}
