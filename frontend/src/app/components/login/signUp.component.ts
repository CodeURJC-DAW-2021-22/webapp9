import { Component } from '@angular/core';
import { UseroService } from '../../services/usero.service';
import { Usero } from './../../models/usero.model';

@Component({
  selector: 'signup',
  templateUrl: './signUp.component.html'
})
export class SignUpComponent {

  constructor(public useroService: UseroService) { }

  createUser(event: any, nick: string, name: string, lastName: string, email: string, pass: String) {

    event.preventDefault();
    var user: Usero = { nick, name, lastName, email, creditCard: "",image: false, roles: ['USERO']}
    this.useroService.createUser(user, pass);
     
    if(user.id){
      alert("Usuario creado exitoso");
    }else{
      alert("Error al crear el usuario");
    }
   
   // this.router.navigate(['/login']);
  }

}
