        //int
import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { News } from 'src/app/models/new.model';
import { NewsService } from 'src/app/services/news.service';
import * as internal from 'stream';

@Component({
  selector: 'news',
  templateUrl: './news.component.html'
})

export class NewsComponent{

  //25: int;
  //25: int;
  news: News | undefined;
  imagesCarousel = ['diabloIV.jgp', 'overwatch2.jpg', 'marioKart9.jgp'].map((n) => `./backend/src/main/resources/static/Photos/${n}`); //esto no se si está bien

  constructor(private router: Router, public newsService: NewsService, activatedRoute: ActivatedRoute){

    const id = activatedRoute.snapshot.params['id'];
        this.newsService.getNew(id).subscribe(
            (news: News) => this.news = news,
            (error: any) => console.error(error)


        );

  }

  getNewsImage(){
      if(this.news){ //We have to put this always. If exist any new...
          return this.news?.image+ '/api/news/' +this.news.id
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
