import { Component } from '@angular/core';
import { LoginService } from 'src/app/services/login.service'

@Component({
  selector: 'navBar',
  templateUrl: './navBar.component.html'
})


export class NavBarComponent{

    constructor(public loginService: LoginService){

    }

}