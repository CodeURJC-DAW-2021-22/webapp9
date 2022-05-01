import { Component, Input } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { News } from 'src/app/models/news.model';
import { NewsService } from 'src/app/services/news.service';


@Component({
  selector: 'editNewForm',
  templateUrl: './editNewForm.component.html'
})


export class EditNewFormComponent {


  @Input() news!: News;
  file: any;

  constructor(public router: Router, public newsService: NewsService, activatedRoute: ActivatedRoute){

    const id = activatedRoute.snapshot.params['id'];
        this.newsService.getNew(id).subscribe(
            (news) => this.news =  news as News,
            (error: any) => console.error(error)

        );

  }

  uploadImage(news: News): void {

    const image = this.file.nativeElement.files[0];
    if (image) {
      let formData = new FormData();
      formData.append("imageFile", image);
      this.newsService.uploadNewImage(news, formData).subscribe(
        _ => this.afterUploadImage(news),
        error => alert('Error uploading book image: ' + error)
      );
    } else {
      this.afterUploadImage(news);
    }
  }

  private afterUploadImage(news: News){
    this.router.navigate(['/showNew/', news.id]);
  }


  deleteNew(news: News){
    this.newsService.deleteNew(news);
  }

  save(){
    this.newsService.updateNew(this.news).subscribe(
      (news) => this.uploadImage(news as News),
      (error: string) => alert('Error al guardar los datos: ' + error)
    );
  }

}
