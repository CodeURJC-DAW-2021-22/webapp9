import { Component } from '@angular/core';
import { SignUpService } from '../../services/signUp.service'; 

@Component({
  selector: 'userProfile',
  templateUrl: './userProfile.component.html'
})
export class UserProfile {

  constructor(public userProfile: UserProfile) { }

  signup(event: any, nick: String, name: String, lastName: String, email: String, pass: String) {

    event.preventDefault();

    this.signUpService.signup(nick, name, lastName, email, pass);
  }

}