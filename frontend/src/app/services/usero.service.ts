import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Usero } from '../models/usero.model';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

const BASE_URL = '/api/users';

@Injectable({ providedIn: 'root' })
export class UseroService {

    user?: Usero;

    constructor(private http: HttpClient) {}

    getUsers(): Observable<Usero[]> {
		return this.http.get(BASE_URL).pipe(
			catchError((error: any) => this.handleError(error))
		) as Observable<Usero[]>;
	}

    getUser(id: number | string): Observable<Usero> {
		return this.http.get(BASE_URL + id).pipe(
			catchError((error: any) => this.handleError(error))
		) as Observable<Usero>;
	}

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

	updateUser(user: Usero) {
		return this.http.put(BASE_URL + user.id, user).pipe(
			catchError((error: any) => this.handleError(error))
		);
	}

	updatePassword(user: Usero) {
		return this.http.put(BASE_URL + user.id + '/password', user).pipe(
			catchError((error: any) => this.handleError(error))
		);
	}

	setUserCreditCard(user: Usero) {

		if (!user.creditCard) {
			return this.http.post(BASE_URL, user.id + '/creditCard')
				.pipe(
					catchError((error: any) => this.handleError(error))
				);
		} else {
			return this.http.put(BASE_URL + user.id + '/creditCard', user).pipe(
				catchError((error: any) => this.handleError(error))
			);
		}
	}





    /*createUser(user: Usero, password: String) {
        this.http.post(BASE_URL + '/signup', {username: user, password: password});
    }

    updateUser(user: Usero) {
        this.http.post(BASE_URL + '/updateUser', {});
    }*/

    private handleError(error: any) {
		console.log("ERROR:");
		console.error(error);
		return throwError("Server error (" + error.status + "): " + error.text())
	}

}