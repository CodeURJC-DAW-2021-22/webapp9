import { Component } from '@angular/core';
import { Router,ActivatedRoute } from '@angular/router';
import { Videogame } from 'src/app/models/videojuego.model';
import { VideogameService } from 'src/app/services/videogame.service';

@Component({
  selector: 'videogame-card',
  templateUrl: './videogame-card.component.html'
})

export class VideogameCardComponent{

  videogame!: Videogame;

  constructor(private router: Router, activatedRoute: ActivatedRoute, public videogameService: VideogameService){
    
    const id = activatedRoute.snapshot.params['id'];
    videogameService.getVideogame(id).subscribe(
        videogame => this.videogame = videogame,
        error => console.error(error)
    )
  }

    gotoVideogame() {
        this.router.navigate(['/videogame/'+this.videogame.id]);
    }

    videogameImage(){
        return this.videogame.imageVg? '/api/videogames/'+this.videogame.id+'/image' : '/assets/images/no_image.png';
    }
    
    companyImage(){
        return this.videogame.imageCompany? '/api/videogames/'+this.videogame.id+'/companyImage' : '/assets/images/no_image.png';
    }

}
