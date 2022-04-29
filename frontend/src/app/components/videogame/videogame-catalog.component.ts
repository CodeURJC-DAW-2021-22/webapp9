import { Content } from '@angular/compiler/src/render3/r3_ast';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Videogame,VideogamePage } from 'src/app/models/videogame.model';
import { VideogameService } from 'src/app/services/videogame.service';

@Component({
  selector: 'videogame-catalog',
  templateUrl: './videogame-catalog.component.html'
})

export class VideogameCatalogComponent{
  
  ids!:number[];
  videogames!:Videogame[];
  videogamepage!: VideogamePage;
  page:number = 0;
  ready:boolean = false;
  constructor(private router: Router, public videogameService: VideogameService){
      videogameService.getVideogamesPage(this.page).subscribe(      
      data => {var x = data['content']  ;console.log(x);this.videogames= x as Videogame[];}  ,
      error => console.error(error)
    )
  }

  ngOnInit(){
    this.ready = true;
  }
  
  nextpage(){
    this.changepage(1)
    this.videogameService.getVideogamesPage(this.page).subscribe(      
    data => {var x = data['content']  ;console.log(x);this.videogames = x as Videogame[];}  ,
    error => console.error(error)
    )
  }

  prevpage(){
    this.changepage(-1)
    this.videogameService.getVideogamesPage(this.page).subscribe(      
      data => {var x = data['content']  ;console.log(x);this.videogames = x as Videogame[];}  ,
      error => console.error(error)
      )
  }

  changepage(num:number){
    if (num == -1){
      this.page -= 1;
    }else{
      this.page += 1;
    }
  }
  

}
