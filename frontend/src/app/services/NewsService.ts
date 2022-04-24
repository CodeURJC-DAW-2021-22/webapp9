import { Service } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { News } from '../Model/News';
import { NewRepository } from '../Repositories/NewRepository';

@Service
export class NewsService {

    constructor(private httpClient: HttpClient) {}

    private repository: NewRepository;

    findById(id: number) {
        return this.repository.findById(id);
    }

    exist(id: number) {
        return this.repository.existById(id);
    }

    findAll(pageable: Pageable) {
        return this.repository.findAll(pageable);
    }

    findAll() {
        return this.repository.findAll();
    }

    save(new: News) {
        return this.httpClient.put(URL + new.id, new);
    }

    delete(id: number) {
        this.repository.deleteById(id);
    }

    findAll(of: PageRequest) {
        return this.repository.findAll(of);
    }

    findByIds(notices) {
        return this.repository.findAllById(notices);
    }
}