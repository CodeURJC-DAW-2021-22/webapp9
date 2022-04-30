import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Usero } from 'src/app/models/usero.model';
import { LoginService } from 'src/app/services/login.service'
import { UseroService } from 'src/app/services/usero.service';

@Component({
  selector: 'navBar',
  templateUrl: './navBar.component.html'
})


export class NavBarComponent{

    user?: Usero;

    constructor(public loginService: LoginService, public userService: UseroService, activatedRoute: ActivatedRoute){
      const id = activatedRoute.snapshot.params['id'];
        this.userService.getUser(id).subscribe(
            (user) => this.user =  user as Usero,
            (error: any) => console.error(error)

        );
    }

    /*ngOnInit(){
      this.user = this.loginService.currentUser();
    }*/
    
    
}