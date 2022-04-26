import { Component } from '@angular/core';
import { UseroService } from '../../services/usero.service';

@Component({
  selector: 'signup',
  templateUrl: './signUp.component.html'
})
export class SignUpComponent {

  constructor(public useroService: UseroService) { }

  createUser(event: any, nick: String, name: String, lastName: String, email: String, pass: String) {

    event.preventDefault();

    this.useroService.createUser(nick, name, lastName, email, pass);
  }

}
