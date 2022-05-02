import { Component, Input } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { News } from 'src/app/models/news.model';
import { NewsService } from 'src/app/services/news.service';


@Component({
  selector: 'editNew',
  templateUrl: './editNew.component.html'
})


export class EditNewComponent{

  news!: News;

constructor(public newsService: NewsService, activatedRoute: ActivatedRoute, private router: Router){

  const id = activatedRoute.snapshot.params['id'];
  this.newsService.getNew(id).subscribe(
    (news) => this.news =  news as News,
    (error: any) => console.error(error)
  )


  }

}