import { Component } from '@angular/core';
import { Router,ActivatedRoute } from '@angular/router';
import { Videogame } from 'src/app/models/videogame.model';
import { VideogameService } from 'src/app/services/videogame.service';

@Component({
  selector: 'videogame-detail',
  templateUrl: './videogame-detail.component.html'
})

export class VideogameDetailComponent{

  videogame!: Videogame;

  constructor(private router: Router, activatedRoute: ActivatedRoute, public videogameService: VideogameService){
    
    const id = activatedRoute.snapshot.params['id'];
    videogameService.getVideogame(id).subscribe(
        videogame => this.videogame = videogame,
        error => console.error(error)
    )
  }
  //Forbidden error falta ser admin
  removeVideogame() {
    const okResponse = window.confirm('Do you want to remove this videogame?');
    if (okResponse) {
        this.videogameService.deleteVideogame(this.videogame).subscribe(
            _ => this.router.navigate(['/videogame/']), //Cambiar a el catalogo de videojuegos
            error => console.error(error)
        );
    }
}       
//Forbidden error falta ser admin
    editVideogame() {
        this.router.navigate(['/videogame/edit', this.videogame.id]);
    }

    gotovideogamescatalog() {
        this.router.navigate(['/videogame']);
    }

    videogameImage(){
        return this.videogame.imageVg? '/api/videogames/'+this.videogame.id+'/image' : '/assets/images/no_image.png';
    }

    
    companyImage(){
        return this.videogame.imageCompany? '/api/videogames/'+this.videogame.id+'/companyImage' : '/assets/images/no_image.png';
    }

}