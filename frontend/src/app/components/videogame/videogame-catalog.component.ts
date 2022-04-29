import { Component } from '@angular/core';
import { Router,ActivatedRoute } from '@angular/router';
import { VideogameService } from 'src/app/services/videogame.service';

@Component({
  selector: 'videogame-catalog',
  templateUrl: './videogame-catalog.component.html'
})

export class VideogameCatalogComponent{
  
  selectid:number = 29;
  
  constructor(private router: Router, activatedRoute: ActivatedRoute, public videogameService: VideogameService){

  }


  

}
