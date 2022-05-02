import { Component } from '@angular/core';
import { Router,ActivatedRoute } from '@angular/router';
import { Videogame } from 'src/app/models/videogame.model';
import { LoginService } from 'src/app/services/login.service';
import { VideogameService } from 'src/app/services/videogame.service';
import { News } from 'src/app/models/news.model';
import { NewsService } from 'src/app/services/news.service';

@Component({
  selector: 'videogame-detail',
  templateUrl: './videogame-detail.component.html'
})

export class VideogameDetailComponent{


  news!: News[];
  videogame!: Videogame;

  constructor(private router: Router,public loginService: LoginService, activatedRoute: ActivatedRoute, public videogameService: VideogameService, newsService: NewsService){

    const id = activatedRoute.snapshot.params['id'];
    videogameService.getVideogame(id).subscribe(
        videogame => this.videogame = videogame,
        error => console.error(error)
    )


    newsService.getNew(id).subscribe(
      news => {this.news = news as News[]},
      error => console.error(error)
    )

  }

  removeVideogame() {
    const okResponse = window.confirm('Do you want to remove this videogame?');
    if (okResponse) {
        this.videogameService.deleteVideogame(this.videogame).subscribe(
            _ => this.router.navigate(['/videogamecatalog']), //Cambiar a el catalogo de videojuegos
            error => console.error(error)
        );
    }
}

    editVideogame() {
        this.router.navigate(['/videogame/edit/' + this.videogame.id]);
    }

    purchasevideogame(){
        var id = this.loginService.currentUser();
        this.router.navigate(['/videogame/' + this.videogame.id + '/purchase/' + id?.id]);
    }

    videogameImage(){
        return this.videogame.imageVg? '/api/videogames/'+this.videogame.id+'/image' : '/assets/images/no_image.png';
    }


    companyImage(){
        return this.videogame.imageCompany? '/api/videogames/'+this.videogame.id+'/companyImage' : '/assets/images/no_image.png';
    }

    islogged(){
        var user = this.loginService.currentUser();
        return user;
    }

    isAdmin(){
        return this.loginService.isAdmin();
      }
}
