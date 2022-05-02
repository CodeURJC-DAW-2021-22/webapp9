import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";

import { Videogame, VideogamePage } from "../models/videogame.model";
import { Observable, throwError } from "rxjs";
import { catchError } from 'rxjs/operators';

const URL = '/api/videogames/';


@Injectable({ providedIn: 'root' })
export class VideogameService {

    constructor(private httpClient: HttpClient) { }

    getVideogames(): Observable<Videogame[]> {
        var videogame = this.httpClient.get(URL).pipe() as Observable<Videogame[]>
        return videogame
    }

    getVideogamesPage(page: number): Observable<VideogamePage> {

        var videogames = this.httpClient.get(URL + "pages?page=" + page).pipe() as Observable<VideogamePage>
        return videogames
    }

    getVideogame(id: number | string): Observable<any> {
        return this.httpClient.get(URL + id).pipe(
            catchError(error => this.handleError(error))
        ) as Observable<any>;
    }

    private handleError(error: any) {
        console.log("ERROR:");
        console.error(error);
        return throwError("Server error (" + error.status + "): " + error.text())
    }

    createVideogame(videogame: Videogame) {
        return this.httpClient.post(URL, videogame).pipe(
            catchError((error: any) => this.handleError(error))
        )
    }

    updateVideogame(videogame: Videogame) {
        return this.httpClient.put(URL + videogame.id, videogame)
    }

    deleteVideogame(videogame: Videogame) {
        return this.httpClient.delete(URL + videogame.id).pipe(catchError(error => this.handleError(error)));
    }

    uploadVideogameImage(videogame: Videogame, formData: FormData) {
        return this.httpClient.post(URL + videogame.id + '/image', formData)
    }

    uploadVideogameCompanyImage(videogame: Videogame, formData: FormData) {
        return this.httpClient.post(URL + videogame.id + '/companyImage', formData)
    }

    deleteVideogameCompanyImage(videogame: Videogame) {
        return this.httpClient.delete(URL + videogame.id + '/companyImage')
    }
    /*
        addRelatedNew(videogame: Videogame) {
            return this.httpClient.put()
        }
    */
    ////////////////////////////////// GRAFICAS ///////////////////////////////////////


    graphicGenres() {
        return this.httpClient.get(URL + "stats/genres")
    }

    graphicSales() {
        return this.httpClient.get(URL + "stats/sales")
    }
    /*
        purchaseVideogame(videogame: Videogame, user: Usero) {
            return this.httpClient.put()
        }
    */
}
