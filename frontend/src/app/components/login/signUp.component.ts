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
    var user: Usero = { nick, name, lastName, email, creditCard: "", image: true, roles: ['USERO']}
    formData.append('nick', nick);
    formData.append('name', name);
    formData.append('lastName', lastName);
    formData.append('email', email);
    formData.append('password', password);
    //this.useroService.createUser(user);
    this.useroService.createUser(formData);
   
   // this.router.navigate(['/login']);
  }

}
