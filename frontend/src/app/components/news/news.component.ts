        //int
import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { News } from 'src/app/models/news.model';
import { NewsService } from 'src/app/services/news.service';
//import * as internal from 'stream';

@Component({
  selector: 'news',
  templateUrl: './news.component.html'
})

export class NewsComponent{

  //25: int;
  //25: int;
  ready: boolean = false;
  news!: News[];
  imagesCarousel = ['assets/images/ diabloIV.jgp', 'assets/images/ overwatch2.jpg', 'assets/images/ marioKart9.jgp']

  constructor(private router: Router, public newsService: NewsService, activatedRoute: ActivatedRoute){

    const id = activatedRoute.snapshot.params['id'];
        this.newsService.getNews().subscribe(
            (news) => this.news =  news as News[], //casting in ts, es mejor hacerlo en el servicio (as Observable<News>), pero al dar error, hacemos el cast en el component
            (error: any) => console.error(error)


        );

  }

  getNewsImage(news: News){
      if(this.news){ //We have to put this always. If exist any new...
        return news.image? '/api/news/' + news.id + '/image' : '/assets/images/not_foung.png';
      } else {
          return undefined;
      }
  }

  //esto es una prueba
  nextPage(){
      if(this.news){
          return this.router.navigate(['/news/1'])
      } else {
          return undefined;
      }
  }

}
