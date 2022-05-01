import { NewsPage } from './../models/news.model';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { News } from '../models/news.model'
import { Usero } from '../models/usero.model'
import { catchError, Observable, throwError } from 'rxjs'

const URL = '/api/news/'

@Injectable({ providedIn: 'root' })
export class NewsService {

    constructor(private httpClient: HttpClient) { }

    getNews() {
        return this.httpClient.get(URL).pipe(
            catchError((error: any) => this.handleError(error))
        )
    }

    findNewsPage(page: number): Observable<NewsPage> {
        return this.httpClient.get(URL + "pages?page=" + page).pipe() as Observable<NewsPage> //NewsPage es la interfaz en el model de news
    }

    getNew(id: number): Observable<any> {
        return this.httpClient.get(URL + id).pipe(
            catchError((error: any) => this.handleError(error))
        ) as Observable<any>
    }

    createNew(news: News) {
        return this.httpClient.post(URL, news).pipe(
            catchError((error: any) => this.handleError(error))
        )
    }

    updateNew(news: News) {
        return this.httpClient.put(URL + news.id, news).pipe(
            catchError((error: any) => this.handleError(error))
        )
    }

    deleteNew(news: News) {
        return this.httpClient.delete(URL + news.id).pipe(
            catchError((error: any) => this.handleError(error))
        )
    }

    uploadNewImage(news: News, formData: FormData) {
        return this.httpClient.post(URL + news.id + '/image', formData).pipe(
            catchError((error: any) => this.handleError(error))
        )
    }

    downloadNewImage(news: News) {
        return this.httpClient.get(URL + news.id + '/image').pipe(
            catchError((error: any) => this.handleError(error))
        )
    }

    deleteNewImage(news: News) {
        return this.httpClient.delete(URL + news.id + '/image').pipe(
        )
    }
    /*
        readNew(news: News, user: Usero) {
            return this.httpClient.put()
        }
    */

    private handleError(error: any) {
        console.log("ERROR:");
        console.error(error);
        return throwError("Server error (" + error.status + "): " + error.text())
    }
}
