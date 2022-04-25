import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";

import { News } from "../models/new.model"
import { Videogame } from "../models/videojuego.model";
import { Observable } from "rxjs";
import { Usero } from "../models/usero.model";

const URL = '/api/news/';

/////////////////////////////////////////////////////////////////////
// FALTA REVISAR Q FUNCIONE BIEN, Y DOS FUNCIONES MAS ABAJO
/////////////////////////////////////////////////////////////////////

@Injectable({ providedIn: 'root' })
export class VideogameService {

    constructor(private httpClient: HttpClient) {}

    getVideogames(): Observable<Videogame> {
        return this.httpClient.get(URL).pipe() as Observable<Videogame>
    }

    findVideogamePage() {
        return this.httpClient.get(URL + "pages")
    }

    getVideogame(id: number) {
        return this.httpClient.get(URL + id)
    }

    createVideogame(videogame: Videogame) {
        if (!videogame.id) {
            return this.httpClient.post(URL, videogame)
        } else {
            return this.httpClient.put(URL + videogame.id, videogame)
        }
    }

    updateVideogame(videogame: Videogame) {
        return this.httpClient.put(URL + videogame.id, videogame)
    }

    deleteVideogame(videogame: Videogame) {
        return this.httpClient.delete(URL + videogame.id)
    }

    uploadVideogameCompanyImage(videogame: Videogame, formData: FormData) {
		return this.httpClient.post(URL + videogame.id + '/companyImage', formData)
	}

    downloadVideogameCompanyImage(videogame: Videogame) {
        return this.httpClient.get(URL + videogame.id + '/companyImage')
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


    graphic() {
        return this.httpClient.get(URL + "stats/genres")
    }

    graphic2() {
        return this.httpClient.get(URL + "stats/sales")
    }
/*
    purchaseVideogame(videogame: Videogame, user: Usero) {
        return this.httpClient.put()
    }
*/
}