import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { News } from 'src/app/models/news.model';
import { NewsService } from 'src/app/services/news.service';

@Component({
  selector: 'home',
  templateUrl: './home.component.html'
})




export class HomeComponent{

  page:number = 0;
  ready: boolean = false;
  news!: News[];


  constructor( public newsService: NewsService, activatedRoute: ActivatedRoute){

    //const id = activatedRoute.snapshot.params['id'];

        this.newsService.findNewsPage(this.page).subscribe(
          (news) => {var x = news['content'] ;this.news = x as News[];}, //casting in ts, es mejor hacerlo en el servicio (as Observable<News>), pero al dar error, hacemos el cast en el component
          (error: any) => console.error(error)
      );
  }

  ngOnInit(){
    this.ready = true;
  }

  nextpage(){
    this.changepage(1)
    this.newsService.findNewsPage(this.page).subscribe(
      (news) => {var x = news['content'] ;this.news = x as News[];},
      (error: any) => console.error(error)
  );
  }

  prevpage(){
    this.changepage(-1)
    this.newsService.findNewsPage(this.page).subscribe(
      (news) => {var x = news['content'] ;this.news = x as News[];},
      (error: any) => console.error(error)
  );
  }

  changepage(num:number){
    if (num == -1){
      this.page -= 1;
    }else{
      this.page += 1;
    }
  }



}
