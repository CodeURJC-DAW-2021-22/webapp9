import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { News } from '../models/new.model';
import { Usero } from '../models/usero.model'
import { catchError, Observable, throwError } from 'rxjs';

const URL = '/api/news/';

@Injectable({ providedIn: 'root' })
export class NewsService {

    constructor(private httpClient: HttpClient) { }

    getsNews(): Observable<News> {
        return this.httpClient.get(URL).pipe(
            //catchError(error => this.handleError(error))
        ) as Observable<News>
    }

    findNewsPage() {
        return this.httpClient.get(URL + "pages")
    }

    getNew(id: number): Observable<News> {
        return this.httpClient.get(URL + id) as Observable<News>
    }

    createNew(news: News) {
        if (!news.id) {
            return this.httpClient.post(URL, news)
        } else {
            return this.httpClient.put(URL + news.id, news)
        }
    }

    uptadeNew(news: News) {
        return this.httpClient.put(URL + news.id, news)
    }

    deleteNew(news: News) {
        return this.httpClient.delete(URL + news.id)
    }

    uploadNewImage(news: News, formData: FormData) {
		return this.httpClient.post(URL + news.id + '/image', formData)
	}

    downloadNewImage(news: News) {
        return this.httpClient.get(URL + news.id + '/image')
    }

    deleteNewImage(news: News) {
        return this.httpClient.delete(URL + news.id + '/image')
    }
/*
    readNew(news: News, user: Usero) {
        return this.httpClient.put()
    }
*/
    /*
    private handleError(error: any) {
		console.log("ERROR:");
		console.error(error);
		return throwError("Server error (" + error.status + "): " + error.text())
	}
    */
}