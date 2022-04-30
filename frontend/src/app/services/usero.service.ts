import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Usero } from '../models/usero.model';
import { Videogame } from '../models/videogame.model';
import { News } from '../models/news.model';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

const BASE_URL = '/api/users/';

@Injectable({ providedIn: 'root' })
export class UseroService {

    user!: Usero;

    constructor(private http: HttpClient) {}


	/*------------------GET METHODS------------------*/
    getUsers(): Observable<Usero[]> {
		return this.http.get(BASE_URL).pipe(
			//catchError((error: any) => this.handleError(error))
		) as Observable<Usero[]>;
	}

    getUser(id: number | string): Observable<Usero> {
		return this.http.get(BASE_URL + id).pipe(
			//catchError((error: any) => this.handleError(error))
		) as Observable<Usero>;
	}

	getVideogames(user: Usero): Observable<Videogame[]> {
		return this.http.get(BASE_URL + '/purchases' + user.id).pipe(
			//catchError((error: any) => this.handleError(error))
		) as Observable<Videogame[]>;
	}

	getUserReadNews(id: number | string): Observable<News[]> {
		return this.http.get(BASE_URL + '/purchases' + id).pipe(
			//catchError((error: any) => this.handleError(error))
		) as Observable<News[]>;
	}

	getRecommended(id: number | string): Observable<Videogame[]> {
		return this.http.get(BASE_URL + id + '/recommendations' ).pipe(
			//catchError((error: any) => this.handleError(error))
		) as Observable<Videogame[]>;
	}

	getMe(): Observable<Usero> {
		return this.http.get(BASE_URL + '/me').pipe(
			//catchError((error: any) => this.handleError(error))
		) as Observable<Usero>;
	}

	/*------------------CREATE METHODS------------------*/
	createUser(user: Usero) {

		if (!user.id) {
			return this.http.post(BASE_URL, user)
				.pipe(
					catchError((error: any) => this.handleError(error))
				);
		} else {
			return this.http.put(BASE_URL + user.id, user).pipe(
				catchError((error: any) => this.handleError(error))
			);
		}
	}

	updateUser(user: Usero) :  Observable<Usero>{
		return this.http.put(BASE_URL + user.id, user).pipe(
			//catchError((error: any) => this.handleError(error))
		)as Observable<Usero>;
	}

	/*------------------IMAGE METHODS------------------*/
	setUserImage(user: Usero, formData: FormData) {
		return this.http.post(BASE_URL + user.id + '/image', formData)
			.pipe(
				catchError((error: any) => this.handleError(error))
			);
	}

	deleteUserImage(user: Usero) {
		return this.http.delete(BASE_URL + user.id + '/image')
			.pipe(
				catchError((error: any) => this.handleError(error))
			);
	}

	/*------------------PASSWORD METHODS------------------*/
	updatePassword(user: Usero) {
		return this.http.put(BASE_URL + user.id + 'password', user).pipe(
			catchError((error: any) => this.handleError(error))
		);
	}

	/*------------------CREDIT CARDS METHODS------------------*/
	setCreditCard(user: Usero, creditCard: FormData) {
		return this.http.post(BASE_URL + user.id + '/creditCard', creditCard).pipe(
			catchError((error: any) => this.handleError(error))
		);
	}

	updateCreditCard(user: Usero) {
		return this.http.put(BASE_URL + user.id + '/creditCard', user).pipe(
			catchError((error: any) => this.handleError(error))
		)
	}


    private handleError(error: any) {
		console.log("ERROR:");
		console.error(error);
		return throwError("Server error (" + error.status + "): " + error.text())
	}

}