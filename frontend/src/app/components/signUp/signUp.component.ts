import { Component } from '@angular/core';
// import { LoginService } from '../../services/login.service'; WE WILL NEED THIS LATER

@Component({
  selector: 'login',
  templateUrl: './signup.component.html'
})
export class LoginComponent {

  constructor(public signUpService: signUpService) { }



}