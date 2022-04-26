import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { News } from 'src/app/models/new.model';
import { NewsService } from 'src/app/services/news.service';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'showNews',
  templateUrl: './showNews.component.html'
})

export class ShowNewsComponent{

  news: News | undefined;

  constructor(public newsService: NewsService, loginService: LoginService, activatedRoute: ActivatedRoute){

    const id = activatedRoute.snapshot.params['id'];
        this.newsService.getNew(id).subscribe(
            (news: News) => this.news = news,
            (error: any) => console.error(error)

        );

  }

}
