import { Component } from '@angular/core';
import { UseroService } from '../../services/usero.service';
import { Usero } from './../../models/usero.model';

@Component({
  selector: 'signup',
  templateUrl: './signUp.component.html'
})
export class SignUpComponent {

  password!: string;

  constructor(public useroService: UseroService) { }

  createUser(event: any, nick: string, name: string, lastName: string, email: string, password: string) {

    event.preventDefault();
    const formData = new FormData();
    formData.append('nick', nick);
    formData.append('name', name);
    formData.append('lastName', lastName);
    formData.append('email', email);
    formData.append('password', password);
    this.useroService.createUser(formData);
   
   
  }

}
