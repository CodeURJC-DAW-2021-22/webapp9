import { Component } from '@angular/core';
import { SignUpService } from '../../services/usero.service'; 

@Component({
  selector: 'signup',
  templateUrl: './signup.component.html'
})
export class LoginComponent {

  constructor(public signUpService: SignUpService) { }

  signup(event: any, nick: String, name: String, lastName: String, email: String, pass: String) {

    event.preventDefault();

    this.signUpService.logIn(nick, name, lastName, email, pass);
  }

}