import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { News } from '../models/new.model';
import { Observable } from 'rxjs';

const URL = '/api/news/';

@Injectable({ providedIn: 'root' })
export class NewsService {

    constructor(private httpClient: HttpClient) { }

    /*
    findById(id: number) {
        return this.repository.findById(id);
    }
    */
    getNewById(id: number): Observable<News> {
        return this.httpClient.get(URL + id) as Observable<News>;
    }

    exist(id: number) {
        return this.repository.existById(id);
    }

    findAll(pageable: Pageable) {
        return this.httpClient.findAll(pageable);
    }

    /*
    findAll() {
        return this.repository.findAll();
    }
    */
    getNews(): Observable<News> {
        return this.httpClient.get(URL) as Observable<News>;
    }

    /*save(new: News) {
        return this.httpClient.put(URL + new.id, new);
    }
    */
    saveNew(news: News) {
        return this.httpClient.put(URL + news.id, news);
    }

    /*
    delete(id: number) {
        this.repository.deleteById(id);
    }
    */
    deleteNew(news: News) {
        return this.httpClient.delete(URL + news.id);
    }

    findAll(of: PageRequest) {
        return this.repository.findAll(of);
    }

    findByIds(notices) {
        return this.repository.findAllById(notices);
    }

}