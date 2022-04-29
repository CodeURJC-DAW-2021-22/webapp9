import { Component } from '@angular/core';
import { Router,ActivatedRoute } from '@angular/router';
import { Videogame } from 'src/app/models/videogame.model';
import { VideogameService } from 'src/app/services/videogame.service';

@Component({
  selector: 'videogame-catalog',
  templateUrl: './videogame-catalog.component.html'
})

export class VideogameCatalogComponent{
  
  ids!:number[];
  videogames!:Videogame[];
  ready:boolean = false;
  constructor(private router: Router, activatedRoute: ActivatedRoute, public videogameService: VideogameService){

  }

  ngOnInit(){
    this.videogameService.getVideogames().subscribe(      
      videogames => this.videogames = videogames as Videogame[],
      error => console.error(error)
    )
    this.ready = true;
  }

  

}
