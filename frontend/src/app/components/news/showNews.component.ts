import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { News } from 'src/app/models/news.model';
import { NewsService } from 'src/app/services/news.service';
import { LoginService } from 'src/app/services/login.service';
import { Videogame } from 'src/app/models/videogame.model';
import { VideogameService } from 'src/app/services/videogame.service';
'../../services/usero.service';

@Component({
  selector: 'showNews',
  templateUrl: './showNews.component.html'
})

export class ShowNewsComponent {

  news!: News;
  videogames!: Videogame[];

  constructor(private router: Router,public newsService: NewsService, public loginService: LoginService, activatedRoute: ActivatedRoute, videogameservice:VideogameService){

    const id = activatedRoute.snapshot.params['id'];
    this.newsService.getNew(id).subscribe(
      (news) => this.news = news as News,
      (error: any) => console.error(error)

    );

    

  }

  editNew() {
    this.router.navigate(['/new/edit/' + this.news.id]);
  }

  removeNew() {
    const okResponse = window.confirm('Do you want to remove this new?');
    if (okResponse) {
        this.newsService.deleteNew(this.news).subscribe(
            _ => this.router.navigate(['/news']),
            error => console.error(error)
        );
    }
}

  isAdmin() {
    return this.loginService.isAdmin();
  }

  newsImage() {
    if (this.news) { //We have to put this always. If exist any new...
      return this.news.image ? '/api/news/' + this.news.id + '/image' : '/assets/images/not_foung.png';
    } else {
      return undefined;
    }
  }


}
