import { Component } from '@angular/core';
import { News } from 'src/app/models/new.model';
import { NewsService } from '/../services/news.service';

@Component({
  selector: 'news',
  templateUrl: './news.component.html'
})

export class NewsComponent{

  news: News;

  constructor(public newsService: NewsService)

}
