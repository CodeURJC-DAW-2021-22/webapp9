import { Component } from '@angular/core';
import { SignUpService } from '../../services/signUp.service'; 

@Component({
  selector: 'signup',
  templateUrl: './signup.component.html'
})
export class SignUpComponent {

  constructor(public signUpService: SignUpService) { }

  signup(event: any, nick: String, name: String, lastName: String, email: String, pass: String) {

    event.preventDefault();

    this.signUpService.signup(nick, name, lastName, email, pass);
  }

}