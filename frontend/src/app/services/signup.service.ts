import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Usero } from '../models/usero.model';

const BASE_URL = '/api/signUp';

@Injectable({ providedIn: 'root' })
export class SignupService {

    user?: Usero;

    constructor(private http: HttpClient) {}

    signUp(nick: string, name: string, lastName: string, email: string, pass: string) {

        this.http.post(BASE_URL + '/signup', {username: user, password: pass})

    }

}