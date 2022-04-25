import { Component } from '@angular/core';
import { UseroService } from '../../services/Usero.service'; 

@Component({
  selector: 'signup',
  templateUrl: './usero.component.html'
})
export class SignUpComponent {

  constructor(public useroService: UseroService) { }

  signup(event: any, nick: String, name: String, lastName: String, email: String, pass: String) {

    event.preventDefault();

    this.useroService.signup(nick, name, lastName, email, pass);
  }

}