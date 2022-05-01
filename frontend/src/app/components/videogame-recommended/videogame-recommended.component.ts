import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Usero } from 'src/app/models/usero.model';
import { Videogame } from 'src/app/models/videogame.model';
import { LoginService } from 'src/app/services/login.service';
import { UseroService } from 'src/app/services/usero.service';

@Component({
  selector: 'app-videogame-recommended',
  templateUrl: './videogame-recommended.component.html',
  styleUrls: ['./videogame-recommended.component.css']
})
export class VideogameRecommendedComponent implements OnInit {

  videogames!:Videogame[];

  constructor(private router: Router, public useroService: UseroService, public loginService: LoginService){
    const id = loginService.currentUser()?.id;
    useroService.getRecommended(id as number).subscribe(      
      videogame => this.videogames= videogame as Videogame[] ,
      error => console.error(error)
    )
  }

  ngOnInit(){ }

}
