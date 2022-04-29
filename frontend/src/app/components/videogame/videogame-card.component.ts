import { Component,Input } from '@angular/core';
import { Router } from '@angular/router';
import { Videogame } from 'src/app/models/videogame.model';
import { VideogameService } from 'src/app/services/videogame.service';

@Component({
  selector: 'videogame-card',
  templateUrl: './videogame-card.component.html'
})

export class VideogameCardComponent{

  @Input() id!:number;

  videogame!: Videogame;

  constructor(private router: Router, public videogameService: VideogameService){
    

  }
  
    ngOnInit() {
      this.videogameService.getVideogame(this.id).subscribe(
        videogame => this.videogame = videogame as Videogame,
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
