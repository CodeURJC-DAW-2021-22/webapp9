import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { News } from 'src/app/models/news.model';
import { NewsService } from 'src/app/services/news.service';


@Component({
  selector: 'newsTemplate',
  templateUrl: './newsTemplate.component.html'
})


export class NewsTemplateComponent{

    news!: News;

    constructor(public newsService: NewsService, activatedRoute: ActivatedRoute){

        const id = activatedRoute.snapshot.params['id'];
        this.newsService.getNew(id).subscribe(
            (news) => this.news =  news as News,
            (error: any) => console.error(error)

        );
    }




    newsImage(){
        if(this.news){ //We have to put this always. If exist any new...
          return this.news.image? '/api/news/' + this.news.id + '/image' : '/assets/images/not_foung.png';
        } else {
            return undefined;
        }
    }

    /*getNewsBadge(){
      if(this.news){
        return this.news?.badge
      } else {
        return undefined;
      }
    }*/




}

