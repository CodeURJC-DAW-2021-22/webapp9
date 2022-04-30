import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { News } from 'src/app/models/news.model';
import { NewsService } from 'src/app/services/news.service';

@Component({
  selector: 'home',
  templateUrl: './home.component.html'
})




export class HomeComponent{
  news!: News[];


  constructor( public newsService: NewsService, activatedRoute: ActivatedRoute){

    const id = activatedRoute.snapshot.params['id'];
        this.newsService.getNews().subscribe(
            (news) => this.news =  news as News[], //casting in ts, es mejor hacerlo en el servicio (as Observable<News>), pero al dar error, hacemos el cast en el component
            (error: any) => console.error(error)


        );

  }

}
