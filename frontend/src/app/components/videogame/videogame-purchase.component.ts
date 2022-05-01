import { Component, Input } from '@angular/core';
import { Router,ActivatedRoute } from '@angular/router';
import { Usero } from 'src/app/models/usero.model';
import { Videogame } from 'src/app/models/videogame.model';
import { UseroService } from 'src/app/services/usero.service';
import { VideogameService } from 'src/app/services/videogame.service';

@Component({
  selector: 'videogame-purchase',
  templateUrl: './videogame-purchase.component.html'
})

export class VideogamePurchaseComponent{

  videogame!: Videogame;
  user!: Usero;
  date!: Date;
  constructor(private router: Router, activatedroute:ActivatedRoute, public videogameService: VideogameService, useroService: UseroService){
    const id = activatedroute.snapshot.params['id'];
    const id2 = activatedroute.snapshot.params['id2'];

    useroService.getUser(id2).subscribe(
      data => {this.user= data as Usero},
      error => console.error(error)
    )

    videogameService.getVideogame(id).subscribe(      
      data => {this.videogame= data as Videogame},
      error => console.error(error)
    )

  }

  ngOnInit(){
    const now = new Date();
    this.date = now;
  }

  buygame(){
    this.videogameService.purchasegame(this.videogame.id,this.user.id)
  }

  videogameImage(){
    return this.videogame.imageVg? '/api/videogames/'+this.videogame.id+'/image' : '/assets/images/no_image.png';
}

}