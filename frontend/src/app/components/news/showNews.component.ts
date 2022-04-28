import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { News } from 'src/app/models/news.model';
import { NewsService } from 'src/app/services/news.service';
import { LoginService } from 'src/app/services/login.service';
'../../services/usero.service';

@Component({
  selector: 'showNews',
  templateUrl: './showNews.component.html'
})

export class ShowNewsComponent{

  news!: News;

  constructor(public newsService: NewsService, public loginService: LoginService, activatedRoute: ActivatedRoute){

    const id = activatedRoute.snapshot.params['id'];
        this.newsService.getNew(id).subscribe(
            (news) => this.news =  news as News,
            (error: any) => console.error(error)

        );

  }

  isAdmin(){
    return this.loginService.isAdmin();
  }

}
