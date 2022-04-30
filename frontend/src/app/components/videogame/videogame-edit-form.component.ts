import { Component, Input } from '@angular/core';
import { Router,ActivatedRoute } from '@angular/router';
import { Videogame } from 'src/app/models/videogame.model';
import { VideogameService } from 'src/app/services/videogame.service';

@Component({
  selector: 'videogame-edit-form',
  templateUrl: './videogame-edit-form.component.html'
})

export class VideogameEditFormComponent{

  videogame!: Videogame;
  ready:boolean = false;

  constructor(private router: Router, activatedroute:ActivatedRoute, public videogameService: VideogameService){
    const id = activatedroute.snapshot.params['id'];
    videogameService.getVideogame(id).subscribe(      
      data => {console.log(data);this.videogame= data as Videogame},
      error => console.error(error)
    )

  }


  ngOnInit(){
    this.ready = true;
  }

}