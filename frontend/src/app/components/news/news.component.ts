        //int
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { News } from 'src/app/models/news.model';
import { NewsService } from 'src/app/services/news.Service';

@Component({
  selector: 'news',
  templateUrl: './news.component.html'
})

export class NewsComponent{

  //25: int;
  //25: int;
  news: News | undefined;

  constructor(private router: Router, public newsService: NewsService){
    
  }

}
