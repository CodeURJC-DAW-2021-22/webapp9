import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Usero } from '../models/usero.model';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

const BASE_URL = '/api/users';

@Injectable({ providedIn: 'root' })
export class SignupService {

    user?: Usero;

    constructor(private http: HttpClient) {}

    getUsers(): Observable<Usero[]> {
		return this.http.get(BASE_URL).pipe(
			//catchError(error => this.handleError(error)) da un error raro
		) as Observable<Usero[]>;
	}

    getUser(id: number | string): Observable<Usero> {
		return this.http.get(BASE_URL + id).pipe(
			//catchError(error => this.handleError(error))
		) as Observable<Usero>;
	}

    createUser(user: Usero, password: String) {
        this.http.post(BASE_URL + '/signup', {username: user, password: password});
    }

    updateUser(user: Usero) {
        this.http.post(BASE_URL + '/updateUser', {});
    }

    private handleError(error: any) {
		console.log("ERROR:");
		console.error(error);
		return throwError("Server error (" + error.status + "): " + error.text())
	}

}